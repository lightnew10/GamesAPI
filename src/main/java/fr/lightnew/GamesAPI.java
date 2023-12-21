package fr.lightnew;

import fr.lightnew.api.GameLaunch;
import fr.lightnew.api.GameSettings;
import fr.lightnew.api.PlayerStatistic;
import fr.lightnew.commands.SetSpawn;
import fr.lightnew.game.GameState;
import fr.lightnew.listeners.PlayerManager;
import fr.lightnew.tools.ConsoleLog;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.HashMap;
import java.util.UUID;

public final class GamesAPI extends JavaPlugin {

    private static GamesAPI instance;
    private static GameSettings settings;
    private static GameLaunch gameLaunch;
    public static HashMap<UUID, PlayerStatistic> playersInGame;

    @Override
    public void onEnable() {
        ConsoleLog.info("Plugin try enable...");

        //Set preset
        instance = this;
        playersInGame = new HashMap<>();
        gameLaunch = new GameLaunch();
        GameState.setGameState(GameState.WAITING);
        //set default settings
        settings = new GameSettings(false, 5, 10, "lobby", 20);
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        //Listeners
        Bukkit.getPluginManager().registerEvents(new PlayerManager(), this);

        //Commands
        getCommand("setspawn").setExecutor(new SetSpawn());

        ConsoleLog.success("Plugin Enable");
    }

    @Override
    public void onDisable() {
        ConsoleLog.success("Plugin Disable");
    }

    public static GamesAPI getInstance() {
        return instance;
    }

    public static GameSettings getSettings() {
        return settings;
    }

    public static GameLaunch getGameLaunch() {
        return gameLaunch;
    }

    public static Boolean sendPlayerDefaultServer(Player player) {
        try {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(b);
            out.writeUTF("Connect");
            out.writeUTF(getSettings().getDefaultServer());
            player.sendPluginMessage(GamesAPI.getInstance(), "BungeeCord", b.toByteArray());
            b.close();
            out.close();
            return true;
        } catch (Exception e) {
            ConsoleLog.error("Error when trying to connect to " + getSettings().getDefaultServer());
            return false;
        }
    }

}
