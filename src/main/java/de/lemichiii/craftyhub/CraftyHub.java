package de.lemichiii.craftyhub;

import de.lemichiii.craftyhub.items.SpielerManagement;
import de.lemichiii.craftyhub.items.Teleporter;
import de.lemichiii.craftyhub.listener.JoinListener;
import de.lemichiii.craftyhub.listener.ProtectionListener;
import de.lemichiii.craftyhub.listener.QuitListener;
import lombok.Getter;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class CraftyHub extends JavaPlugin {

    private final ConsoleCommandSender consoleSender = this.getServer().getConsoleSender();

    @Getter
    private String prefix = "§7[§dCraftyHub§7] ";
    @Getter
    private String noperms = prefix + "§cDazu hast du keine Rechte.";
    @Getter
    private String console = prefix + "§cDazu musst du ein Spieler sein.";

    @Override
    public void onEnable() {
        this.consoleSender.sendMessage(prefix + "§2Das §d§lCraftyHub §2Plugin wurde aktiviert.");

        this.getServer().getPluginManager().registerEvents(new JoinListener(), this);
        this.getServer().getPluginManager().registerEvents(new QuitListener(), this);
        this.getServer().getPluginManager().registerEvents(new ProtectionListener(), this);
        this.getServer().getPluginManager().registerEvents(new Teleporter(), this);
        this.getServer().getPluginManager().registerEvents(new SpielerManagement(), this);
    }

    @Override
    public void onDisable() {
        this.consoleSender.sendMessage(prefix + "§4Das §d§lCraftyHub §4Plugin wurde deaktiviert.");
    }

    public static CraftyHub getInstance() {
        return CraftyHub.getPlugin(CraftyHub.class);
    }

}
