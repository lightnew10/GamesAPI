package fr.lightnew.ui;

import fr.lightnew.GamesAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.*;

import java.util.List;

public class CustomScoreBoard {

    public static void sendScoreBoardPlayer(Player player, String title, List<String> lines, long time) {
        BukkitTask task = new BukkitRunnable() {
            @Override
            public void run() {
                if (player == null)
                    cancel();
                ScoreboardManager manager = Bukkit.getScoreboardManager();
                final Scoreboard board = manager.getNewScoreboard();
                final Objective objective = board.registerNewObjective("test", "dummy");
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                objective.setDisplayName(title);

                for (int i = 0; i < lines.size(); i++) {
                    Score score = objective.getScore(lines.get(i));
                    score.setScore(i);
                }

                player.setScoreboard(board);
            }
        }.runTaskTimer(GamesAPI.getInstance(), 0, time);
    }

    public static void sendScoreBoardAllPlayers(String title, List<String> lines, long time) {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(GamesAPI.getInstance(), () -> Bukkit.getOnlinePlayers().forEach(player -> {
            ScoreboardManager manager = Bukkit.getScoreboardManager();
            final Scoreboard board = manager.getNewScoreboard();
            final Objective objective = board.registerNewObjective("test", "dummy");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            objective.setDisplayName(title);

            for (int i = 0; i < lines.size(); i++) {
                Score score = objective.getScore(lines.get(i));
                score.setScore(i);
            }

            player.setScoreboard(board);
        }),0, time);
    }

    public static void sendScoreBoardAllPlayers(String title, List<String> lines) {
        sendScoreBoardAllPlayers(title, lines, 20);
    }
    public static void sendScoreBoardPlayer(Player player, String title, List<String> lines) {
        sendScoreBoardPlayer(player, title, lines, 20);
    }
}
