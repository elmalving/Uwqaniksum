package egoniks.uwqaniksum.Weapons;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import javax.naming.Name;
import javax.naming.NamingEnumeration;

public enum Weapon {

    TESTWEAPON(100, "TESTWEAPON", Material.STICK);

    public static Weapon getWeaponFrom(ItemStack itemStack){
        ItemMeta meta = itemStack.getItemMeta();
        String name = meta.getPersistentDataContainer().get(NamespacedKey.fromString("name"), PersistentDataType.STRING);
        if(name == null){
            return null;
        }

        Weapon weapon = valueOf(name);
        return weapon;
    }

    private double damage;
    private String weaponName;
    private Material weaponMaterial;

    Weapon(double damage, String weaponName, Material weaponMaterial) {
        this.damage = damage;
        this.weaponName = weaponName;
        this.weaponMaterial = weaponMaterial;
    }

    public double getDamage() {
        return damage;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public Material getWeaponMaterial() {
        return weaponMaterial;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public void setWeaponMaterial(Material weaponMaterial) {
        this.weaponMaterial = weaponMaterial;
    }
}
