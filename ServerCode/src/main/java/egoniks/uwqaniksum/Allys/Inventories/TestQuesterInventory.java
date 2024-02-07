package egoniks.uwqaniksum.Allys.Inventories;

import egoniks.uwqaniksum.Quests.Quest;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TestQuesterInventory {
    public static TestQuesterInventory instance = new TestQuesterInventory();
    public final Inventory inv = Bukkit.createInventory(null, 9, "TestQuester");


    public TestQuesterInventory() {

        ItemStack quest1 = Util.createQuest(Quest.quest1);
        inv.setItem(0, quest1);
        ItemStack quest2 = Util.createQuest(Quest.quest2);
        inv.setItem(1, quest2);
        ItemStack quest3 = Util.createQuest(Quest.quest3);
        inv.setItem(2, quest3);
    }
}
