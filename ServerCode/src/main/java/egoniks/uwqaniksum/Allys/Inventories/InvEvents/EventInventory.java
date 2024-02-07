package egoniks.uwqaniksum.Allys.Inventories.InvEvents;

import egoniks.uwqaniksum.Quests.LogicQuests;
import egoniks.uwqaniksum.Quests.LogicQuestsForOpenInventory;
import egoniks.uwqaniksum.Allys.Inventories.TestQuesterInventory;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class EventInventory implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getInventory() == TestQuesterInventory.instance.inv && event.getWhoClicked() instanceof Player){
            event.setCancelled(true);
            ItemStack itemStack = event.getCurrentItem();
            Player player = (Player) event.getWhoClicked();
            String type = event.getCurrentItem().getItemMeta().getPersistentDataContainer().get(NamespacedKey.fromString("type"), PersistentDataType.STRING);
            switch (type) {
                case "lore":
                    LogicQuests.LogicLore(itemStack);
                    break;
                case "farm":
                    LogicQuests.LogicFarm(itemStack, player);
                    break;
                case "item":
                    LogicQuests.LogicItem(itemStack, player);
                    break;
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEntityEvent event){
        if(event.getRightClicked().getCustomName().equals("TestQuester")){
            event.getPlayer().openInventory(TestQuesterInventory.instance.inv);

        }
    }
    @EventHandler
    public void ReloadItemsEvent(InventoryOpenEvent event){
        Inventory inventory = event.getInventory();
        if(event.getPlayer() instanceof Player && inventory == TestQuesterInventory.instance.inv){
            Player player = (Player) event.getPlayer();
            for(ItemStack item : inventory.getContents()){
                if(item != null){
                    String type = item.getItemMeta().getPersistentDataContainer().get(NamespacedKey.fromString("type"), PersistentDataType.STRING);
                    switch (type) {
                        case "farm":
                            LogicQuestsForOpenInventory.LogicFarm(item, player);
                            break;
                        case "item":
                            LogicQuestsForOpenInventory.LogicItem(item, player);
                            break;
                    }
                }
            }
        }
    }
}
