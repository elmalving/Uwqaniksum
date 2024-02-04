package egoniks.uwqaniksum.Enemies;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.persistence.PersistentDataType;

public enum Enemy {

    TESTENEMI(500, "TestMob", EntityType.ZOMBIE);
    private int hp;
    private String nameMob;
    private EntityType typeMob;

    Enemy(int hp, String nameMob, EntityType typeMob) {
        this.hp = hp;
        this.nameMob = nameMob;
        this.typeMob = typeMob;
    }

    public static Enemy getEnemyFrom(LivingEntity entity) {
        String name = entity.getPersistentDataContainer().get(NamespacedKey.fromString("name"), PersistentDataType.STRING);
        if (name == null) {
            return null;
        }

        Enemy enemy = valueOf(name);
        return enemy;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getNameMob() {
        return nameMob;
    }

    public void setNameMob(String nameMob) {
        this.nameMob = nameMob;
    }

    public EntityType getTypeMob() {
        return typeMob;
    }

    public void setTypeMob(EntityType typeMob) {
        this.typeMob = typeMob;
    }
}
