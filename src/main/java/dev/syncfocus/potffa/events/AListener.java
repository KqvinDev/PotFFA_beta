package dev.syncfocus.potffa.events;

import dev.syncfocus.potffa.PotFFA;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class AListener implements Listener {

    public AListener() {
        Bukkit.getPluginManager().registerEvents(this, JavaPlugin.getPlugin(PotFFA.class));
    }
}
