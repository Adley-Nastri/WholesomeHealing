package me.thatjavaboi.wholesomehealing.commands;

import me.thatjavaboi.wholesomehealing.Wholesome;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WholesomeCommand implements CommandExecutor, TabExecutor {

    public static Wholesome plugin;


    public WholesomeCommand(Wholesome plugin) {
        WholesomeCommand.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {


        if (strings.length == 1) {
            if (strings[0].equalsIgnoreCase("reload")) {
                if (commandSender.hasPermission("wholesomehealing.reload")) {
                    ReloadConfig rc = new ReloadConfig(plugin);
                    rc.reloadMethod(commandSender);
                } else if (!commandSender.hasPermission("wholesomehealing.reload")) {

                    commandSender.sendMessage("You do not have permission to reload wholesomehealing config");
                }


            }

            if (strings[0].equalsIgnoreCase("update")) {
                if (commandSender.hasPermission("wholesomehealing.update")) {

                    File file = new File(String.valueOf(plugin.getServer().getUpdateFolderFile()));
                    if (file.exists()) {
                        plugin.Update();
                    }
                    if (!file.exists()) {
                        File updatefolder = new File(String.valueOf(plugin.getServer().getUpdateFolderFile().getParentFile() + "\\update"));
                        updatefolder.mkdir();
                        plugin.Update();
                    }
                    commandSender.sendMessage(ChatColor.AQUA + "[WholesomeHealing] Updating plugin");
                    commandSender.sendMessage(ChatColor.AQUA + "[WholesomeHealing] Please reload the server for successful installation");

                }

            }


            if (strings[0].equalsIgnoreCase("info")) {
                assert plugin.getDescription().getDescription() != null;

                commandSender.sendMessage("\n" + ChatColor.AQUA +
                        "╔══════════════════════════╗" + "\n" +
                        "  Wholesome Healing Bandages" + "\n" +
                        "  " + plugin.getDescription().getDescription() + "\n" +
                        "  Version " + plugin.getDescription().getVersion() + "\n" +
                        "  Written By " + plugin.getDescription().getAuthors().toString().replace("[", "").replace("]", "") + "\n" +
                        "╚══════════════════════════╝" + "\n ");
                //commandSender.sendMessage("\n"+ ChatColor.AQUA + plugin.getDescription().getDescription() + "\nVersion " + plugin.getDescription().getVersion() + "\nWritten By " + plugin.getDescription().getAuthors().toString().replace("[", "").replace("]", "")+"\n ");

            }


        }

        if (strings.length == 2) {
            if (strings[0].equalsIgnoreCase("update")) {
                if (commandSender.hasPermission("wholesomehealing.update.check")) {

                    if (strings[1].equalsIgnoreCase("check")) {
                        if (plugin.UpdateCheck()) {
                            commandSender.sendMessage(ChatColor.AQUA + "[WholesomeHealing] Update is available");
                        }
                        if (!plugin.UpdateCheck()) {
                            commandSender.sendMessage(ChatColor.AQUA + "[WholesomeHealing] Update is not yet available");
                        }

                    }


                }

            }

        }


        return strings.length != 0;
    }


    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {


        if (strings.length == 1) {

            List<String> commands = new ArrayList<>();
            List<String> other = new ArrayList<>();
            commands.add("reload");
            commands.add("update");
            commands.add("info");

            for (String str : commands) {
                if (str.startsWith(strings[0].toLowerCase())) {
                    other.add(str);

                }

            }

            return other;

        }


        if (strings.length == 2) {
            if (strings[0].equalsIgnoreCase("update")) {

                List<String> upd_comm = new ArrayList<>();
                List<String> temp = new ArrayList<>();

                upd_comm.add("check");

                for (String str : upd_comm) {
                    if (str.startsWith(strings[1].toLowerCase())) {
                        temp.add(str);

                    }

                }

                return temp;
            }

        }


        return null;


    }

}



