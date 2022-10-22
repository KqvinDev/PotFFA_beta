package dev.syncfocus.potffa.events;

import dev.syncfocus.potffa.PotFFA;
import dev.syncfocus.potffa.leaderboard.LeaderboardManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveListener extends AListener {

    private final LeaderboardManager leaderboardManager;

    public PlayerLeaveListener() {
        super();
        this.leaderboardManager = PotFFA.getLeaderboardManager();
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        leaderboardManager.removeGlobalLeaderboardViewer(event.getPlayer());

    }
    }
