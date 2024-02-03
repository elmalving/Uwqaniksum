package egoniks.uwqaniksum.Enemies;


import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.persistence.PersistentDataType;

public class HealthBar implements Listener {
    public static void addHealthBar(LivingEntity entity, Enemy enemy) {
        entity.setCustomName(enemy.getNameMob() + ChatColor.BOLD + " " + ChatColor.RED + Math.round(enemy.getHp()) + ChatColor.WHITE + "/" + ChatColor.RED + Math.round(enemy.getHp()));
    }

    public static void updateHealthBar(LivingEntity entity, Enemy enemy, double curhp) {
        if (curhp < 0) {
            curhp = 0;
        }
        ;
        entity.setCustomName(enemy.getNameMob() + ChatColor.BOLD + " " + ChatColor.RED + Math.round(curhp) + ChatColor.WHITE + "/" + ChatColor.RED + Math.round(enemy.getHp()));
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity().getPersistentDataContainer().get(NamespacedKey.fromString("name"), PersistentDataType.STRING) != null) {
            Enemy enemy = Enemy.valueOf(event.getEntity().getPersistentDataContainer().get(NamespacedKey.fromString("name"), PersistentDataType.STRING));
            updateHealthBar((LivingEntity) event.getEntity(), enemy, ((LivingEntity) event.getEntity()).getHealth() - event.getDamage());
        }
    }
}
