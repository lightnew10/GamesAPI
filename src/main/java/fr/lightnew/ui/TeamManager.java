package fr.lightnew.ui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;
import java.util.Map;

public class TeamManager {
    public static Map<String, Team> teams = new HashMap<>();
    public static Map<Player, Team> player_in_teams = new HashMap<>();

    public static void createTeam(String teamName, ChatColor color, String prefix) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        Team team = scoreboard.getTeam(teamName);
        if (team == null) {
            team = scoreboard.registerNewTeam(teamName);
            team.setPrefix(color + prefix + ChatColor.RESET);
        }

        teams.put(teamName, team);
    }

    public static void addPlayerToTeam(String teamName, Player player) {
        Team team = teams.get(teamName);
        if (team != null) {
            team.addEntry(player.getName());
            player_in_teams.put(player, team);
        }
    }

    public static void removePlayerToTeam(String teamName, Player player) {
        Team team = teams.get(teamName);
        if (team != null) {
            team.removeEntry(player.getName());
            player_in_teams.remove(player);
        }
    }

    public static void setPlayerPrefix(Player player, String prefix) {
        for (Team team : teams.values()) {
            if (team.hasEntry(player.getName())) {
                team.setPrefix(prefix);
                break;
            }
        }
    }
}
