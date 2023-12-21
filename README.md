# Games API

## What is this ? 
`I created this API for easy create a game.`

Minecraft version : `1.20`

[![](https://jitpack.io/v/lightnew10/GamesAPI.svg)](https://jitpack.io/#lightnew10/GamesAPI)


## How to start ?

## Maven
_I know is wtf version_
```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.lightnew10</groupId>
    <artifactId>GamesAPI</artifactId>
    <version>e10a36f4d8</version>
</dependency>
```
### Settings :

```java
import fr.lightnew.GamesAPI;
import fr.lightnew.api.GameSettings;

public void onEnable() {
    //You have a default settings game. If you want to modify this just use 
    GameSettings settings = GamesAPI.getSettings();
    //Example with max player but you have more settings
    settings.setMaxPlayers(5);    
    //This API ave a personal statistic player for your data's
    //Enable this function like that
    settings.setEnableStatisticsPlayer(true);
    //And more...
}
```

### Game State :

```java
import fr.lightnew.game.GameState;
import fr.lightnew.listeners.GameStateChangeEvent;
import org.bukkit.event.EventHandler;

public void onEnable() {
    //Here is game state, you have event and change state

    //With this you change a state of game ! 
    //And if you want a EVENT is enabled for you !
    GameState.setGameState(GameState.GAME);
}

@EventHandler
public void onChange(GameStateChangeEvent event) {
    //You have Old State and new State
    event.getNewState(); // -> return GameState
    event.getOldState(); // -> return GameState
}
```

### Spawn's :

```java
import fr.lightnew.GamesAPI;
import fr.lightnew.game.GameState;
import fr.lightnew.listeners.GameStateChangeEvent;

public void onEnable() {
    //Default spawn, with command in game "/setspawn <waiting/game/end>
    //You can get this information with GameAPI.getSettings();
    GamesAPI.getSettings().getSpawnGame();
    GamesAPI.getSettings().getSpawnEnd();
    GamesAPI.getSettings().getSpawnWaiting();
}
```

### Interface :

```java
import fr.lightnew.GamesAPI;
import fr.lightnew.game.GameState;
import fr.lightnew.listeners.GameStateChangeEvent;
import fr.lightnew.ui.CustomScoreBoard;

import java.util.Arrays;

public void onEnable() {
    //for the moment we have a score board
    //If you want to modify a time updated a scoreboard add long an end to this method
    CustomScoreBoard.sendScoreBoardPlayer(player, "title", Arrays.asList("A ligne", "second ligne", "..."));
    //For all players
    //Same for update time
    CustomScoreBoard.sendScoreBoardAllPlayers("title", Arrays.asList("A ligne", "second ligne"));
}
```

### Team's :

```java
import fr.lightnew.ui.TeamManager;
import org.bukkit.ChatColor;

public void onEnable() {
    //Create a team
    //If you want to create a team, use TeamManager
    TeamManager.createTeam("TeamName", ChatColor.YELLOW, "[YELLOW] ");
    //Add player in a team
    TeamManager.addPlayerToTeam("TeamName", player);
    //remove player in a team
    TeamManager.removePlayerToTeam("TeamName", player);
    //Modify a prefix for a player
    TeamManager.setPlayerPrefix(player, "[New Prefix] ");
    //And you have a list a team with player's in team
    TeamManager.teams; // -> Map<String, Team> | String = Name team
    TeamManager.player_in_teams; // -> Map<Player, Team>
}
```

## Finished for now
I hope to add new content for easing create mini-game

If you have a proposition, contact me in discord. (Lightnew)
