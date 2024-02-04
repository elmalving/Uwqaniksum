package egoniks.uwqaniksum.Allys.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestQuesterInventory {
    public static TestQuesterInventory instance = new TestQuesterInventory();
    public final Inventory inv = Bukkit.createInventory(null, 9, "TestQuester");

    List<String> lore = new ArrayList<>(Arrays.asList(
            "Дать денег максимке",
            "Избить Егоникса",
            "",
            "Вы не можете взять этот квест"
    ));

    private ItemStack quest = Util.createQuest(lore,"TestQuest", -1);

    public TestQuesterInventory() {
        inv.setItem(0,quest);
    }
}
