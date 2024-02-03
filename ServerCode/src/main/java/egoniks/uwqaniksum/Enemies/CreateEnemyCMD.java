package egoniks.uwqaniksum.Enemies;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateEnemyCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (strings.length == 0) {
                player.sendMessage("Укажи имя моба");
                return true;
            }
            try {
                Enemy enemy = Enemy.valueOf(strings[0]);
                SettingEnemy.setEnemy(player, enemy);
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
