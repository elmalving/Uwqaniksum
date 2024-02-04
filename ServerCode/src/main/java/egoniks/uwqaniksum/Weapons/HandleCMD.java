package egoniks.uwqaniksum.Weapons;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HandleCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (strings.length == 0) {
                player.sendMessage("Укажи имя оружия");
                return true;
            }
            try {
                Weapon weapon = Weapon.valueOf(strings[0]);
                ArmsHandler.handle(weapon, player);

                return true;
            } catch (IllegalArgumentException e) {
                player.sendMessage("Неверное имя оружия");
                return true;
            }
        }
        System.out.println("U arnt Player");
        return false;
    }
}
