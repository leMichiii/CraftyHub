package de.lemichiii.craftyhub;

import de.lemichiii.craftyhub.items.TeleporterItem;
import de.lemichiii.craftyhub.listener.JoinListener;
import de.lemichiii.craftyhub.listener.ProtectionListener;
import de.lemichiii.craftyhub.listener.QuitListener;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class CraftyHub extends JavaPlugin {

    private final ConsoleCommandSender consoleSender = this.getServer().getConsoleSender();

    @Getter
    private String prefix = "§7[§dCraftyHub§7] ";
    @Getter
    private String noperms = getPrefix() + "§cDazu hast du keine Rechte.";
    @Getter
    private String console = getPrefix() + "§cDazu musst du ein Spieler sein.";

    @Override
    public void onEnable() {
        this.consoleSender.sendMessage(getPrefix() + "§2Das §d§lCraftyHub §2Plugin wurde aktiviert.");

        this.getServer().getPluginManager().registerEvents(new JoinListener(), this);
        this.getServer().getPluginManager().registerEvents(new QuitListener(), this);
        this.getServer().getPluginManager().registerEvents(new ProtectionListener(), this);
        this.getServer().getPluginManager().registerEvents(new TeleporterItem(), this);
    }

    @Override
    public void onDisable() {
        this.consoleSender.sendMessage(getPrefix() + "§4Das §d§lCraftyHub §4Plugin wurde deaktiviert.");
    }

    public static CraftyHub getInstance() {
        return CraftyHub.getPlugin(CraftyHub.class);
    }

}
