package egoniks.uwqaniksum.Quests;

import egoniks.uwqaniksum.Allys.Inventories.Util;
import egoniks.uwqaniksum.Enemies.Enemy;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;
import java.util.Map;

public class LogicQuests {
    public static void LogicLore(ItemStack item){
        int status = item.getItemMeta().getPersistentDataContainer().get(NamespacedKey.fromString("status"), PersistentDataType.INTEGER);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.getLore();
        switch (status){
            case 0:
                item.setType(Material.WRITABLE_BOOK);
                meta.addEnchant(Enchantment.DURABILITY, 1, true);
                lore.set(lore.size()-1, "Вы можете сдать этот квест");
                meta.getPersistentDataContainer().set(NamespacedKey.fromString("status"), PersistentDataType.INTEGER, 2);
                break;
            case 2:
                item.setType(Material.BOOK);
                meta.addEnchant(Enchantment.DURABILITY, 1, true);
                meta = item.getItemMeta();
                lore.set(lore.size()-1, "Вы выполнили этот квест");
                meta.getPersistentDataContainer().set(NamespacedKey.fromString("status"), PersistentDataType.INTEGER, 3);
                break;
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
    }
    public static void LogicFarm(ItemStack item, Player player){
        int status = item.getItemMeta().getPersistentDataContainer().get(NamespacedKey.fromString("status"), PersistentDataType.INTEGER);
        String name = item.getItemMeta().getPersistentDataContainer().get(NamespacedKey.fromString("name"), PersistentDataType.STRING);
        Quest quest = Quest.valueOf(name);
        int strokes = quest.getStrokes();
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.getLore();
        Map<Enemy,Integer> mapNeedForQuest = quest.getQuestMobsAndHowMuchToKill();
        Map<Enemy,Integer> mapKilledForQuest = quest.getQuestMobsAndHowMuchKillYet();

        switch (status){
            case 0:
                item.setType(Material.WRITABLE_BOOK);
                lore.set(lore.size()-1, "Вы выполняете этот квест");
                meta.addEnchant(Enchantment.DURABILITY, 1, true);
                quest.setQuestIsEnable(true);
                player.getPersistentDataContainer().set(NamespacedKey.fromString(quest.name()), PersistentDataType.BOOLEAN, quest.getQuestIsEnable());
                meta.getPersistentDataContainer().set(NamespacedKey.fromString("status"), PersistentDataType.INTEGER, 1);
                break;
            case 1:
                for(Enemy enemy : mapNeedForQuest.keySet()){
                    lore.set(strokes, enemy.getNameMob() + " " + mapKilledForQuest.get(enemy) + "/" + mapNeedForQuest.get(enemy));
                    if(mapKilledForQuest.containsKey(enemy) && mapKilledForQuest.get(enemy) >= mapNeedForQuest.get(enemy)){
                        player.getPersistentDataContainer().remove(NamespacedKey.fromString(quest.name()));
                        quest.setQuestIsEnable(false);
                        meta.getPersistentDataContainer().set(NamespacedKey.fromString("status"), PersistentDataType.INTEGER, 2);
                        lore.set(lore.size()-1, "Вы можете сдать этот квест");
                    }
                }
                break;
            case 2:
                item.setType(Material.BOOK);
                meta = item.getItemMeta();
                lore.set(lore.size()-1, "Вы выполнили этот квест");
                meta.getPersistentDataContainer().set(NamespacedKey.fromString("status"), PersistentDataType.INTEGER, 3);
                break;
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
    }
    public static void LogicItem(ItemStack item, Player player){
        int status = item.getItemMeta().getPersistentDataContainer().get(NamespacedKey.fromString("status"), PersistentDataType.INTEGER);
        String name = item.getItemMeta().getPersistentDataContainer().get(NamespacedKey.fromString("name"), PersistentDataType.STRING);
        Quest quest = Quest.valueOf(name);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.getLore();
        List<ItemStack> items = quest.getQuestItems();
        if(status == 1 || status == 2){
            if(Util.isItemsInInventory(player, items)){
                meta.getPersistentDataContainer().set(NamespacedKey.fromString("status"), PersistentDataType.INTEGER, 2);
                lore.set(lore.size()-1, "Вы можете сдать этот квест");
            }else{
                meta.getPersistentDataContainer().set(NamespacedKey.fromString("status"), PersistentDataType.INTEGER, 1);
                lore.set(lore.size()-1, "Вы выполняете этот квест");
            }
        }
        switch (status){
            case 0:
                item.setType(Material.WRITABLE_BOOK);
                lore.set(lore.size()-1, "Вы выполняете этот квест");
                meta.addEnchant(Enchantment.DURABILITY, 1, true);
                meta.getPersistentDataContainer().set(NamespacedKey.fromString("status"), PersistentDataType.INTEGER, 1);
                break;
            case 2:
                item.setType(Material.BOOK);
                meta = item.getItemMeta();
                lore.set(lore.size()-1, "Вы выполнили этот квест");
                for(ItemStack itemToDelete : items){
                    player.getInventory().remove(itemToDelete);
                }
                meta.getPersistentDataContainer().set(NamespacedKey.fromString("status"), PersistentDataType.INTEGER, 3);
                break;
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
    }
}
