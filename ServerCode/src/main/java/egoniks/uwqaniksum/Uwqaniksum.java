package egoniks.uwqaniksum;

import egoniks.uwqaniksum.Enemies.Events.EventTakeDamage;
import egoniks.uwqaniksum.Weapons.HandleCMD;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Uwqaniksum extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        //ку дебилы
        getCommand("giveweapon").setExecutor(new HandleCMD());
        Bukkit.getPluginManager().registerEvents(new EventTakeDamage(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
