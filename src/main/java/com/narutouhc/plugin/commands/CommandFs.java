package com.narutouhc.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.narutouhc.plugin.Main;

public class CommandFs implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(!Main.getInstance().pluginRunnable.started && !Main.getInstance().pluginRunnable.starting)
        {
            Main.getInstance().pluginRunnable.starting = true;
            Main.getInstance().pluginRunnable.startTimer = 6;
            sender.sendMessage(Main.getInstance().getPrefix() + "§aVous venez de lancer la partie");
        }       
        else if(!Main.getInstance().pluginRunnable.started && Main.getInstance().pluginRunnable.starting)
        {
            Main.getInstance().pluginRunnable.startTimer = 6;
            sender.sendMessage(Main.getInstance().getPrefix() + "§aVous venez d'accélerer le démarrage de la partie");
        }
        
        return true;
    }
}
