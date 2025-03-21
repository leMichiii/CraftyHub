package de.lemichiii.craftyhub.items;

import de.lemichiii.craftyhub.CraftyHub;
import de.lemichiii.craftyhub.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class SpielerManagement implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getItem() != null) {
            if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (event.getItem().getType() == Material.BREWING_STAND && event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lSpieler Management")) {
                    openInventory(player);
                }
            }
        }
    }

    private void openInventory(Player player) {
        Inventory inventory = Bukkit.createInventory(null, InventoryType.HOPPER, "§d§lSpieler Management");

        for (int i = 0; i < 5; i++) {
            inventory.setItem(i, new ItemBuilder(Material.MAGENTA_STAINED_GLASS_PANE).setName(" ").build());
        }
        inventory.setItem(1, new ItemBuilder(Material.LIME_DYE).setName("§a§lSpieler anzeigen").build());
        inventory.setItem(3, new ItemBuilder(Material.GRAY_DYE).setName("§7§lSpieler verstecken").build());
        player.openInventory(inventory);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getCurrentItem() != null) {
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lSpieler anzeigen")) {

                event.setCancelled(true);
                player.closeInventory();
            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7§lSpieler verstecken")) {

                event.setCancelled(true);
                player.closeInventory();
            }
        }
    }

}
