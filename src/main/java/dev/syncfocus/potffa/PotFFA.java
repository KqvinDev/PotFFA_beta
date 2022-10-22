package dev.syncfocus.potffa;

import dev.syncfocus.potffa.commands.ReloadCMD;
import dev.syncfocus.potffa.configuration.Config;
import dev.syncfocus.potffa.events.*;
import dev.syncfocus.potffa.leaderboard.LeaderboardManager;
import dev.syncfocus.potffa.utilities.ScoreboardUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import scoreboard.ScoreboardManager;

public final class PotFFA extends JavaPlugin {

    private static PotFFA instance;
    private ScoreboardManager scoreboardManager;
    private boolean hologramsEnabled;
    private static LeaderboardManager leaderboardManager;
    @Override
    public void onEnable() {
        if (!Bukkit.getPluginManager().isPluginEnabled("HolographicDisplays")) {
            getLogger().severe("*** HolographicDisplays is not installed or not enabled. ***");
            getLogger().severe("*** This plugin will be disabled. ***");
            this.setEnabled(false);
            this.hologramsEnabled = false;
            return;
        }

        this.hologramsEnabled = true;

        leaderboardManager = new LeaderboardManager();
        leaderboardManager.startUpdateTask();

        instance = this;
        System.out.println("Loading PotFFA...");
        System.out.println("Registering events...");
        this.registerListeners();
        System.out.println("Registering commands...");
        this.registerCommands();

        System.out.println("Loading config...");
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        System.out.println("Loading Scoreboards...");
        this.scoreboardManager = new ScoreboardManager(this, new ScoreboardUtil());

        this.scoreboardManager.setUpdateInterval(100L);

        Config.config();
        Config.get().options().header("replace-item - Item replaced in your item slot when you soup (BOWL or AIR)\nthrow-speed - When you throw a potion to heal, what speed do you want it? (0 - 4)");
        Config.get().addDefault("replace-item", "BOWL");
        Config.get().addDefault("throw-speed", "1.0");
        Config.get().options().copyDefaults(true);
        Config.save();

        System.out.println("Loaded the config!");

        System.out.println("Registering commands...");
        System.out.println("Registered commands!");
    }

    private void registerListeners(){
        this.getServer().getPluginManager().registerEvents(new PotEvents(), this);
        this.getServer().getPluginManager().registerEvents(new SoupEvents(), this);
        this.getServer().getPluginManager().registerEvents(new PotEvents(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerLeaveListener(), this);


    }

    private void registerCommands(){
        this.getCommand("reloadconfig").setExecutor(new ReloadCMD());

    }

    @Override
    public void onDisable() {
        instance = null;

        this.scoreboardManager.disable();

        if (hologramsEnabled) {
            leaderboardManager.stopUpdateTask();
        }
    }

    public static PotFFA getInstance() {
        return instance;
    }

    public static LeaderboardManager getLeaderboardManager() {
        return leaderboardManager;
    }
}
