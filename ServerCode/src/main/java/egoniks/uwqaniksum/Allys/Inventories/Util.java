package egoniks.uwqaniksum.Allys.Inventories;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import javax.print.attribute.Attribute;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public static ItemStack createQuest(List<String> lore, String name, int status){
        ItemStack itemStack = new ItemStack(Material.BOOK);
        ItemMeta meta = itemStack.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setLore(lore);
        meta.getPersistentDataContainer().set(NamespacedKey.fromString("status"), PersistentDataType.INTEGER, status);
        meta.setDisplayName(name);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

}
