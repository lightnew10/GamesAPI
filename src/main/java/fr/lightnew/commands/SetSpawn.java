package fr.lightnew.commands;

import fr.lightnew.GamesAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetSpawn implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (player.isOp()) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("waiting")) {
                        player.sendMessage(ChatColor.YELLOW + "Vous venez de mettre le point de spawn du " + ChatColor.GOLD + args[0].toUpperCase());
                        GamesAPI.getSettings().setSpawnWaiting(player.getLocation());
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("game")) {
                        player.sendMessage(ChatColor.YELLOW + "Vous venez de mettre le point de spawn du " + ChatColor.GOLD + args[0].toUpperCase());
                        GamesAPI.getSettings().setSpawnGame(player.getLocation());
                        return true;
                    }
                    if (args[0].equalsIgnoreCase("end")) {
                        player.sendMessage(ChatColor.YELLOW + "Vous venez de mettre le point de spawn du " + ChatColor.GOLD + args[0].toUpperCase());
                        GamesAPI.getSettings().setSpawnEnd(player.getLocation());
                        return true;
                    }
                    player.sendMessage(ChatColor.YELLOW + "Mettez un bon argument");
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1)
            return Arrays.asList("waiting", "game", "end");
        return null;
    }
}
