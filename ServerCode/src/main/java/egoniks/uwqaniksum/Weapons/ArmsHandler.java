package egoniks.uwqaniksum.Weapons;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class ArmsHandler {
    public static void handle(Weapon weapon, Player player) {

        ItemStack weaponItem = new ItemStack(weapon.getWeaponMaterial());

        ItemMeta metaWeaponItem = weaponItem.getItemMeta();
        metaWeaponItem.getPersistentDataContainer().set(NamespacedKey.fromString("name"), PersistentDataType.STRING, weapon.name());
        metaWeaponItem.setDisplayName(weapon.getWeaponName());
        weaponItem.setItemMeta(metaWeaponItem);

        player.getInventory().addItem(weaponItem);

    }
}
