package me.thatjavaboi.wholesomehealing.commands;

import me.thatjavaboi.wholesomehealing.Wholesome;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;


public class GiveBandage implements CommandExecutor {

    private Wholesome plugin;

    public GiveBandage(Wholesome plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (args.length == 0) {
                bandageMethod(player, 1);
                player.sendMessage("Given 1 bandage");
            } else if (args.length == 1) {
                if (args[0].matches("[0-9]+") && args[0].length() <= 3) {
                    int amt = Integer.parseInt(args[0]);
                    if (amt > 0) {
                        bandageMethod(player, amt);
                        String plural = amt == 1 ? "" : "s";
                        player.sendMessage("Given " + amt + " bandage" + plural);
                    }

                }

            } else if (args.length == 2) {
                if (player.hasPermission("wholesomehealing.give.others")) {
                    if (Bukkit.getServer().getPlayerExact(args[1]) != null) {

                        if (args[0].matches("[0-9]+") && args[0].length() <= 3) {
                            int amt = Integer.parseInt(args[0]);
                            if (amt > 0) {
                                Player target = Bukkit.getPlayer(args[1]);
                                bandageMethod(target, amt);
                                String plural = amt == 1 ? "" : "s";
                                player.sendMessage("Given " + amt + " bandage" + plural + " to " + target.getDisplayName());
                                target.sendMessage("You have been given " + amt + " bandage"+ plural + " by " + player.getDisplayName() + "");

                            }

                        }

                    }

                    





                }


            }


        }
        if (commandSender instanceof ConsoleCommandSender) {
            ConsoleCommandSender ccs = (ConsoleCommandSender) commandSender;
            if (args.length == 2) {
                if (Bukkit.getServer().getPlayerExact(args[1]) != null) {

                    if (args[0].matches("[0-9]+") && args[0].length() <= 3) {
                        int amt = Integer.parseInt(args[0]);
                        if (amt > 0) {
                            Player target = Bukkit.getPlayer(args[1]);
                            bandageMethod(target, amt);

                            String plural = amt == 1 ? "" : "s";
                            ccs.sendMessage("Given " + amt + " bandage" + plural + " to " + target.getDisplayName());
                            target.sendMessage("You have been given " + amt + " bandage"+ plural +"");

                        }

                    }
                } else {
                    ccs.sendMessage("Could not find that Player");
                }


            }

        }


        return true;
    }

    private void bandageMethod(Player player, int amount) {
        Wholesome.ITEM_BANDAGE.setAmount(amount);
        player.getInventory().addItem(Wholesome.ITEM_BANDAGE.clone());
    }
}