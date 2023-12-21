package fr.lightnew.game;

import fr.lightnew.listeners.GameStateChangeEvent;
import org.bukkit.Bukkit;

public enum GameState {
    WAITING,
    GAME,
    END;

    private static GameState currentState;

    public static void setGameState(GameState state){
        GameState oldState = currentState;
        currentState = state;
        Bukkit.getServer().getPluginManager().callEvent(new GameStateChangeEvent(oldState, currentState));
    }

    public static GameState getCurrentGameState(){
        return currentState;
    }
}
