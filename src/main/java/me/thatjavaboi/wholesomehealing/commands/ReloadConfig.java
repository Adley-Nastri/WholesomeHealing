package me.thatjavaboi.wholesomehealing.commands;

import me.thatjavaboi.wholesomehealing.Wholesome;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadConfig implements CommandExecutor {


    public static Wholesome plugin;

    ReloadConfig(Wholesome plugin) {
        ReloadConfig.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player player = (Player) commandSender;
        if (player.hasPermission("wholesomehealing.reload")) {
            reloadMethod(player);
            if (reloadMethod(player)) {
                player.sendMessage(ChatColor.AQUA + "[WholesomeHealing] Config reloaded successfully");

            }

        }

        return true;
    }


    boolean reloadMethod(CommandSender cs) {
        try {
            plugin.reloadConfig();
            cs.sendMessage(ChatColor.AQUA + "[WholesomeHealing] Config reloaded successfully");

            return true;
        } catch (Exception e) {
            cs.sendMessage(ChatColor.RED + "[WholesomeHealing] Config reload failed");
            cs.sendMessage(ChatColor.RED + "[WholesomeHealing] " + e.toString() + "");
            return false;
        }

    }


}

