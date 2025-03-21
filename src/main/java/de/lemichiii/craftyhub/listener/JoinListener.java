package de.lemichiii.craftyhub.listener;

import de.lemichiii.craftyhub.utils.ItemBuilder;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Calendar;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage("§7[§a+§7] §d" + player.getDisplayName());
        getItems(player);
        player.setFoodLevel(20);
        player.setHealth(20);
        player.setLevel(2025);
        player.setExp(Calendar.YEAR);
        player.setGameMode(GameMode.ADVENTURE);
        player.sendTitle("§2§lWillkommen", "§c§l" + player.getDisplayName(), 20, 10, 20);
    }

    private void getItems(Player player) {
        player.getInventory().setItem(2, new ItemBuilder(Material.BREWING_STAND).setName("§d§lSpieler Management").build());
        player.getInventory().setItem(4, new ItemBuilder(Material.NETHER_STAR).setName("§d§lTeleporter").build());
    }
}
