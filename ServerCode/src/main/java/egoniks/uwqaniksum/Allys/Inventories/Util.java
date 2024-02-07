package egoniks.uwqaniksum.Allys.Inventories;

import egoniks.uwqaniksum.Quests.Quest;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class Util {
    public static ItemStack createQuest(Quest quest){
        ItemStack itemStack = new ItemStack(Material.WRITABLE_BOOK);
        ItemMeta meta = itemStack.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setLore(quest.getQuestLore());
        meta.getPersistentDataContainer().set(NamespacedKey.fromString("status"), PersistentDataType.INTEGER, 0);
        meta.getPersistentDataContainer().set(NamespacedKey.fromString("type"), PersistentDataType.STRING, quest.getQuestType());
        meta.getPersistentDataContainer().set(NamespacedKey.fromString("name"), PersistentDataType.STRING, quest.name());
        meta.setDisplayName(quest.getQuestTitle());
        itemStack.setItemMeta(meta);
        return itemStack;
    }
    public static boolean isItemsInInventory(Player player, List<ItemStack> items){
        for(ItemStack checkItem : items){
            if(!player.getInventory().contains(checkItem)) {
                return false;
            }
        }
        return true;
    }
}
