package egoniks.uwqaniksum.Allys.Events;

import egoniks.uwqaniksum.Allys.Inventories.TestQuesterInventory;
import egoniks.uwqaniksum.Allys.Inventories.Util;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class EventInventory implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getInventory() == TestQuesterInventory.instance.inv){
            event.setCancelled(true);
            if(event.getCurrentItem() != null){
                int status = event.getCurrentItem().getItemMeta().getPersistentDataContainer().get(NamespacedKey.fromString("status"), PersistentDataType.INTEGER);
                ItemMeta meta = event.getCurrentItem().getItemMeta();
                List<String> lore = meta.getLore();
                if(status == -1){
                    event.getCurrentItem().setType(Material.WRITABLE_BOOK);
                    lore.set(event.getCurrentItem().getItemMeta().getLore().size()-1, "Вы можете взять этот квест");
                    meta.getPersistentDataContainer().set(NamespacedKey.fromString("status"), PersistentDataType.INTEGER, 0);
                }
                else if(status == 0){
                    event.getCurrentItem().setType(Material.WRITABLE_BOOK);
                    lore.set(event.getCurrentItem().getItemMeta().getLore().size()-1, "Вы выполняете этот квест");
                    meta.addEnchant(Enchantment.DURABILITY, 1, true);
                    meta.getPersistentDataContainer().set(NamespacedKey.fromString("status"), PersistentDataType.INTEGER, 1);
                }
                else if(status == 1){
                    event.getCurrentItem().setType(Material.WRITABLE_BOOK);
                    lore.set(event.getCurrentItem().getItemMeta().getLore().size()-1, "Вы можете сдать этот квест");
                    meta.getPersistentDataContainer().set(NamespacedKey.fromString("status"), PersistentDataType.INTEGER, 2);
                }
                else if(status == 2){
                    event.getCurrentItem().setType(Material.BOOK);
                    meta = event.getCurrentItem().getItemMeta();
                    lore.set(event.getCurrentItem().getItemMeta().getLore().size()-1, "Вы выполнили этот квест");
                    meta.getPersistentDataContainer().set(NamespacedKey.fromString("status"), PersistentDataType.INTEGER, 3);
                }
                meta.setLore(lore);
                event.getCurrentItem().setItemMeta(meta);
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEntityEvent event){
        if(event.getRightClicked().getCustomName().equals("TestQuester")){
            event.getPlayer().openInventory(TestQuesterInventory.instance.inv);
        }
    }
}
