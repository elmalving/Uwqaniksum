package egoniks.uwqaniksum.Enemies;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

public class SettingEnemy {
    public static void setEnemy(Player player, Enemies enemy) {
        LivingEntity entity = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(), enemy.getTypeMob());
        entity.getPersistentDataContainer().set(NamespacedKey.fromString("name"), PersistentDataType.STRING, enemy.name());
        entity.setCustomNameVisible(true);
        entity.setMaxHealth(enemy.getHp());
        entity.setHealth(enemy.getHp());
        entity.setCustomName(enemy.getNameMob());
    }
}
