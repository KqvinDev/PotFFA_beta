package dev.syncfocus.potffa.utilities;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import scoreboard.PlayerScoreboard;
import scoreboard.adapter.ScoreAdapter;

public class ScoreboardUtil implements ScoreAdapter {
    @Override
    public String getTitle() {
        return CC.format("&c&lPOT&f&lFFA");
    }

    @Override
    public void updateLines(PlayerScoreboard scoreboard) {
        Player player = scoreboard.getPlayer();

        String kills = PlaceholderAPI.setPlaceholders(player, "%slipcorpvpstats_kills%");
        String deaths = PlaceholderAPI.setPlaceholders(player, "%slipcorpvpstats_deaths%");
        String ratio = PlaceholderAPI.setPlaceholders(player, "%slipcorpvpstats_ratio%");
        String streak = PlaceholderAPI.setPlaceholders(player, "%slipcorpvpstats_streak%");
        String maxstreak = PlaceholderAPI.setPlaceholders(player, "%slipcorpvpstats_streak%");

        scoreboard.addLine("");
        scoreboard.addLine("&cKills: &7" + kills);
        scoreboard.addLine("&cDeaths: &7" + deaths);
        scoreboard.addLine("&cK/D: &7" + ratio);
        scoreboard.addLine("");
        scoreboard.addLine("&cCurrent Killstreak: &7" + streak);
        scoreboard.addLine("&cBest Killstreak: &7" + maxstreak);
        scoreboard.addLine("");
        scoreboard.addLine("&7play.op-ffa.net");

    }
}
