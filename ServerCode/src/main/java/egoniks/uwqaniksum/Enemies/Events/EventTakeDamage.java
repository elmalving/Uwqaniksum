package egoniks.uwqaniksum.Enemies.Events;

import egoniks.uwqaniksum.Weapons.Weapon;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EventTakeDamage implements Listener {
    @EventHandler
    public void takeDamage(EntityDamageByEntityEvent event) {

        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();

            Weapon weapon = Weapon.getWeaponFrom(player.getInventory().getItemInMainHand());
            double damage = weapon.getDamage();
            event.setDamage(damage);


        }
    }
}
