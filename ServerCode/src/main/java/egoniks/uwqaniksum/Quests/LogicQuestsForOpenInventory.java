package egoniks.uwqaniksum.Quests;

import egoniks.uwqaniksum.Allys.Inventories.Util;
import egoniks.uwqaniksum.Enemies.Enemy;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;
import java.util.Map;

public class LogicQuestsForOpenInventory {
    public static void LogicFarm(ItemStack item, Player player){
        int status = item.getItemMeta().getPersistentDataContainer().get(NamespacedKey.fromString("status"), PersistentDataType.INTEGER);
        String name = item.getItemMeta().getPersistentDataContainer().get(NamespacedKey.fromString("name"), PersistentDataType.STRING);
        Quest quest = Quest.valueOf(name);
        int strokes = quest.getStrokes();
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.getLore();
        Map<Enemy,Integer> mapNeedForQuest = quest.getQuestMobsAndHowMuchToKill();
        Map<Enemy,Integer> mapKilledForQuest = quest.getQuestMobsAndHowMuchKillYet();
        if(status == 1){
                for(Enemy enemy : mapNeedForQuest.keySet()){
                    lore.set(strokes, enemy.getNameMob() + " " + mapKilledForQuest.get(enemy) + "/" + mapNeedForQuest.get(enemy));
                    if(mapKilledForQuest.containsKey(enemy) && mapKilledForQuest.get(enemy) >= mapNeedForQuest.get(enemy)) {
                        player.getPersistentDataContainer().remove(NamespacedKey.fromString(quest.name()));
                        quest.setQuestIsEnable(false);
                        meta.getPersistentDataContainer().set(NamespacedKey.fromString("status"), PersistentDataType.INTEGER, 2);
                        lore.set(lore.size() - 1, "Вы можете сдать этот квест");
                    }
                }
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
        meta.setLore(lore);
        item.setItemMeta(meta);
    }
}
