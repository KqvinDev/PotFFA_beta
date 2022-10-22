package dev.syncfocus.potffa.events;

import dev.syncfocus.potffa.PotFFA;
import dev.syncfocus.potffa.leaderboard.LeaderboardManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener extends AListener {

    private final LeaderboardManager leaderboardManager;

    public PlayerJoinListener() {
        super();
        this.leaderboardManager = PotFFA.getLeaderboardManager();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        leaderboardManager.addGlobalLeaderboardViewer(event.getPlayer());
    }
}
