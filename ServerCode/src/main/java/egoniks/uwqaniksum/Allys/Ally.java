package egoniks.uwqaniksum.Allys;

import org.bukkit.entity.EntityType;
import org.bukkit.inventory.Inventory;

public enum Ally {
    TESTQUESTER("TestQuester", EntityType.VILLAGER);

    private String nameMob;
    private EntityType typeMob;

    Ally(String nameMob, EntityType typeMob) {
        this.nameMob = nameMob;
        this.typeMob = typeMob;
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
