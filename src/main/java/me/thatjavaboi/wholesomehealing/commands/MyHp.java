package me.thatjavaboi.wholesomehealing.commands;

import me.thatjavaboi.wholesomehealing.Wholesome;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MyHp implements CommandExecutor {

    private Wholesome plugin;

    public MyHp(Wholesome plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            myHpMethod(player);

        }


        return true;
    }


    private void myHpMethod(Player player) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.GREEN + "Your HP is " + player.getHealth()));
    }
}

