package fr.lightnew.api;

import fr.lightnew.GamesAPI;
import fr.lightnew.game.GameState;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class GameLaunch {

    private Boolean preTimerLaunched;

    public GameLaunch() {
        preTimerLaunched = false;
    }

    public Boolean getPreTimerLaunched() {
        return preTimerLaunched;
    }

    public void setPreTimerLaunched(boolean preTimerLaunched) {
        this.preTimerLaunched = preTimerLaunched;
    }

    public void sendTimerPreLaunch() {
        if (preTimerLaunched)
            return;
        else
            setPreTimerLaunched(true);
        BukkitTask task = new BukkitRunnable() {
            int i = GamesAPI.getSettings().getTimerPreLaunch();
            @Override
            public void run() {
                if (Bukkit.getOnlinePlayers().size() < GamesAPI.getSettings().getMinLaunch()) {
                    Bukkit.broadcastMessage(GamesAPI.getSettings().getDefaultMessageCancelTimer());
                    setPreTimerLaunched(false);
                    cancel();
                }

                if (i == 0) {
                    GameState.setGameState(GameState.GAME);
                    cancel();
                }

                if (i <= 5)
                    Bukkit.broadcastMessage(GamesAPI.getSettings().getDefaultMessagePreLaunchGame());
            }
        }.runTaskTimer(GamesAPI.getInstance(), 0, 20);
    }
}
