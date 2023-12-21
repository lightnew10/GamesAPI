package fr.lightnew.api;

import org.bukkit.ChatColor;
import org.bukkit.Location;

public class GameSettings {

    private Boolean enableStatisticsPlayer;
    private Location spawnWaiting;
    private Location spawnGame;
    private Location spawnEnd;
    private int minLaunch;
    private int maxPlayers;
    private String defaultServer;
    private int timerPreLaunch;
    private String defaultMessagePreLaunchGame;
    private String defaultMessageCancelTimer;


   public GameSettings(boolean enableStatisticsPlayer, int minLaunch, int maxPlayers, String defaultServerReturn, int timerPreLaunch) {
       this.enableStatisticsPlayer = enableStatisticsPlayer;
       this.minLaunch = minLaunch;
       this.maxPlayers = maxPlayers;
       defaultServer = defaultServerReturn;
       this.timerPreLaunch = timerPreLaunch;
       defaultMessagePreLaunchGame = ChatColor.YELLOW + "La partie ce lance dans ";
       defaultMessageCancelTimer = "Annulation du lancement de la partie.";
   }

    public Boolean getEnableStatisticsPlayer() {
        return enableStatisticsPlayer;
    }

    public void setEnableStatisticsPlayer(Boolean enableStatisticsPlayer) {
        this.enableStatisticsPlayer = enableStatisticsPlayer;
    }

    public Location getSpawnEnd() {
        return spawnEnd;
    }

    public Location getSpawnGame() {
        return spawnGame;
    }

    public Location getSpawnWaiting() {
        return spawnWaiting;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getMinLaunch() {
        return minLaunch;
    }

    public String getDefaultServer() {
        return defaultServer;
    }

    public int getTimerPreLaunch() {
        return timerPreLaunch;
    }

    public String getDefaultMessagePreLaunchGame() {
        return defaultMessagePreLaunchGame;
    }

    public String getDefaultMessageCancelTimer() {
        return defaultMessageCancelTimer;
    }

    public void setSpawnEnd(Location spawnEnd) {
        this.spawnEnd = spawnEnd;
    }

    public void setSpawnGame(Location spawnGame) {
        this.spawnGame = spawnGame;
    }

    public void setSpawnWaiting(Location spawnWaiting) {
        this.spawnWaiting = spawnWaiting;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void setMinLaunch(int minLaunch) {
        this.minLaunch = minLaunch;
    }

    public void setDefaultServer(String defaultServer) {
        this.defaultServer = defaultServer;
    }

    public void setTimerPreLaunch(int timerPreLaunch) {
        this.timerPreLaunch = timerPreLaunch;
    }

    public void setDefaultMessagePreLaunchGame(String defaultMessagePreLaunchGame) {
        this.defaultMessagePreLaunchGame = defaultMessagePreLaunchGame;
    }

    public void setDefaultMessageCancelTimer(String defaultMessageCancelTimer) {
        this.defaultMessageCancelTimer = defaultMessageCancelTimer;
    }
}
