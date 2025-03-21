package de.lemichiii.craftyhub.listener;

import de.lemichiii.craftyhub.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage("§7[§a+§7] §d" + player.getDisplayName());
        getItems(player);
        player.setFoodLevel(20);
        player.setHealth(20);
        player.setLevel(2025);
        player.setGameMode(GameMode.ADVENTURE);
        player.sendTitle("§2§lWillkommen", "§c§l" + player.getDisplayName(), 20, 10, 20);

        Location location = new Location(Bukkit.getWorld("world"), 735.387, 23.00, -1012.444, 91.0F, 1.5F);
        player.teleport(location);
    }

    private void getItems(Player player) {
        player.getInventory().setItem(2, new ItemBuilder(Material.BREWING_STAND).setName("§d§lSpieler Management").build());
        player.getInventory().setItem(4, new ItemBuilder(Material.NETHER_STAR).setName("§d§lTeleporter").build());
    }
}
