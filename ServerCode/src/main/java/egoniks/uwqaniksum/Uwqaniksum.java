package egoniks.uwqaniksum;

import egoniks.uwqaniksum.Allys.CreateAllyCMD;
import egoniks.uwqaniksum.Allys.Events.EventInventory;
import egoniks.uwqaniksum.Enemies.CreateEnemyCMD;
import egoniks.uwqaniksum.Enemies.Events.EventTakeDamage;
import egoniks.uwqaniksum.Enemies.HealthBar;
import egoniks.uwqaniksum.Weapons.HandleCMD;
import org.bukkit.Bukkit;
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
    }
}
