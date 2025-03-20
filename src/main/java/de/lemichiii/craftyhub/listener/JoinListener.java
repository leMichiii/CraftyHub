package de.lemichiii.craftyhub.listener;

import de.lemichiii.craftyhub.utils.ItemBuilder;
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


    }

    private void getItems(Player player) {
        player.getInventory().setItem(4, new ItemBuilder(Material.NETHER_STAR).setName("§d§lTeleporter").build());
    }

}
