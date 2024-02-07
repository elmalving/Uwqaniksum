package egoniks.uwqaniksum;

import egoniks.uwqaniksum.Allys.CreateAllyCMD;
import egoniks.uwqaniksum.Enemies.Events.EntityDie;
import egoniks.uwqaniksum.Allys.Inventories.InvEvents.EventInventory;
import egoniks.uwqaniksum.Enemies.CreateEnemyCMD;
import egoniks.uwqaniksum.Enemies.Events.EventTakeDamage;
import egoniks.uwqaniksum.Enemies.HealthBar;
import egoniks.uwqaniksum.Weapons.HandleCMD;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Uwqaniksum extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("giveweapon").setExecutor(new HandleCMD());

        Bukkit.getPluginManager().registerEvents(new EventTakeDamage(), this);

        getCommand("spawnmob").setExecutor(new CreateEnemyCMD());

        Bukkit.getPluginManager().registerEvents(new HealthBar(), this);

        Bukkit.getPluginManager().registerEvents(new EventInventory(), this);
        getCommand("spawnquester").setExecutor(new CreateAllyCMD());
        Bukkit.getPluginManager().registerEvents(new EntityDie(), this);
    }
    @Override
    public void onDisable(){
        for (Player player : Bukkit.getOnlinePlayers()) {
            for (NamespacedKey key : player.getPersistentDataContainer().getKeys()){
                player.getPersistentDataContainer().remove(key);
            }
        }
    }
}
