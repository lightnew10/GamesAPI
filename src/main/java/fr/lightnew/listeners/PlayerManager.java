package fr.lightnew.listeners;

import fr.lightnew.GamesAPI;
import fr.lightnew.api.PlayerStatistic;
import fr.lightnew.game.GameState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerManager implements Listener {

    @EventHandler
    public void preJoin(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        if (Bukkit.getOnlinePlayers().size() >= GamesAPI.getSettings().getMaxPlayers()) {
            if (GamesAPI.sendPlayerDefaultServer(player))
                player.sendMessage(ChatColor.RED + "Server full");
            else player.kickPlayer(ChatColor.RED + "Error server, please reconnect");
        }
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onJoin(PlayerJoinEvent event) {
        if (GameState.getCurrentGameState().equals(GameState.WAITING)) {
            GamesAPI.playersInGame.put(event.getPlayer().getUniqueId(), new PlayerStatistic(event.getPlayer()));
            int players = Bukkit.getOnlinePlayers().size();
            if (players >= GamesAPI.getSettings().getMinLaunch())
                GamesAPI.getGameLaunch().sendTimerPreLaunch();
            event.setJoinMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + event.getPlayer().getName() + " (" + players + "/" + GamesAPI.getSettings().getMaxPlayers() + ")");
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if (GameState.getCurrentGameState().equals(GameState.WAITING)) {
            GamesAPI.playersInGame.remove(event.getPlayer().getUniqueId());
            event.setQuitMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "-" + ChatColor.GRAY + "] " + event.getPlayer().getName() + " (" +( Bukkit.getOnlinePlayers().size()-1) + "/" + GamesAPI.getSettings().getMaxPlayers() + ")");
        }
    }
}
