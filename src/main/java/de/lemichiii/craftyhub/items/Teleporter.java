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
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class Teleporter implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getItem() != null) {
            if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (event.getItem().getType() == Material.NETHER_STAR && event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lTeleporter")) {
                    openInventory(player);
                }
            }
        }
    }

    private void openInventory(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9*3, "§d§lTeleporter");

        for (int i = 0; i < 27; i++) {
            inventory.setItem(i, new ItemBuilder(Material.MAGENTA_STAINED_GLASS_PANE).setName(" ").build());
        }
        inventory.setItem(13, new ItemBuilder(Material.ENDER_PEARL).setName("§d§lSpawn").build());
        inventory.setItem(11, new ItemBuilder(Material.IRON_PICKAXE).setName("§d§lCityBuild").build());
        player.openInventory(inventory);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getCurrentItem() != null) {
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§d§lSpawn")) {
                Location location = new Location(Bukkit.getWorld("world"), 735.387, 23.00, -1012.444, 91.0F, 1.5F);
                player.teleport(location);
                player.sendMessage(CraftyHub.getInstance().getPrefix() + "§7Du bist nun beim §d§lSpawn§7.");
                player.closeInventory();
            }
        }
    }

}
