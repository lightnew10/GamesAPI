package fr.lightnew.teams;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamManager {

    public static List<TeamManager> listTeams = new ArrayList<>();

    private String name;
    private String prefix;
    private List<Player> playerInTeam;
    private ChatColor color;

    public TeamManager(String name, String prefix, ChatColor color) {
        this.name = name;
        this.prefix = prefix;
        this.playerInTeam = new ArrayList<>();
        this.color = color;
        listTeams.add(this);
    }

    public String getPrefix() {
        return prefix;
    }

    public String getName() {
        return name;
    }

    public ChatColor getColor() {
        return color;
    }

    public List<Player> getPlayerInTeam() {
        return playerInTeam;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
        playerInTeam.forEach(player -> ChangeNameTag.changePrefix(player, this.prefix, ChangeTeamAction.UPDATE));
    }

    public void setColor(ChatColor color) {
        this.color = color;
        playerInTeam.forEach(player -> ChangeNameTag.changeColorName(player, this.color, ChangeTeamAction.UPDATE));
    }

    public void addPlayer(Player player) {
        ChangeNameTag.changePrefixNameAndColor(player, this.color, this.prefix, ChangeTeamAction.CREATE);
        this.playerInTeam.add(player);
    }

    public void removePlayer(Player player) {
        this.playerInTeam.remove(player);
        ChangeNameTag.changePrefix(player, this.prefix, ChangeTeamAction.DESTROY);
    }
}
