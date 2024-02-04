package egoniks.uwqaniksum.Allys;

import egoniks.uwqaniksum.Enemies.Enemy;
import egoniks.uwqaniksum.Enemies.SettingEnemy;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class CreateAllyCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (strings.length == 0) {
                player.sendMessage("Укажи имя моба");
                return true;
            }
            try {
                Ally ally = Ally.valueOf(strings[0]);
                SettingAlly.setAlly(player, ally);
                return true;
            } catch (IllegalArgumentException e) {
                player.sendMessage("Неверное имя моба");
                return true;
            }
        }
        System.out.println("U arnt Player");
        return false;
    }
}
