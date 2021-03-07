package com.narutouhc.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.narutouhc.plugin.Main;

public class CommandStart implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(!Main.getInstance().pluginRunnable.started && !Main.getInstance().pluginRunnable.starting)
        {
            Main.getInstance().pluginRunnable.starting = true;
            sender.sendMessage(Main.getInstance().getPrefix() + "§aVous venez de lancer la partie");
        }
        
        return true;
    }
}
