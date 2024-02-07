package egoniks.uwqaniksum.Enemies.Events;

import egoniks.uwqaniksum.Quests.Quest;
import egoniks.uwqaniksum.Enemies.Enemy;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.persistence.PersistentDataType;

import java.util.Map;

public class EntityDie implements Listener {
    @EventHandler
    public void isDead(EntityDeathEvent event){
        LivingEntity entity = (LivingEntity) event.getEntity();
        Player player = (Player) entity.getKiller();
        for(NamespacedKey key : player.getPersistentDataContainer().getKeys()){
            String[] parts = key.toString().split(":");
            Quest quest = Quest.valueOf(parts[1]);
                if(quest.getQuestIsEnable()){
                    String name = entity.getPersistentDataContainer().get(NamespacedKey.fromString("name"), PersistentDataType.STRING);
                    Enemy enemy = Enemy.valueOf(name);
                    if(quest.getQuestMobsAndHowMuchToKill().containsKey(enemy)){
                        int localTotalKills = quest.getQuestMobsAndHowMuchKillYet().get(enemy);
                        Map<Enemy, Integer> localMap = quest.getQuestMobsAndHowMuchKillYet();
                        localMap.put(enemy, localTotalKills+1);
                        quest.setQuestMobsAndHowMuchKillYet(localMap);
                    }
                }
        }

    }
}
