package egoniks.uwqaniksum.Allys;

import egoniks.uwqaniksum.Enemies.Enemy;
import egoniks.uwqaniksum.Enemies.HealthBar;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

public class SettingAlly {
    public static void setAlly(Player player, Ally ally) {
        LivingEntity entity = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(), ally.getTypeMob());
        entity.getPersistentDataContainer().set(NamespacedKey.fromString("name"), PersistentDataType.STRING, ally.name());
        entity.setCustomNameVisible(true);
        entity.setCustomName(ally.getNameMob());
    }
}
