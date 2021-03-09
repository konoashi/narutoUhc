package com.narutouhc.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandInfo implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(args.length == 0)
            return false;
        else
        {
            String str = "";
            
            for(String s : args)
            {
                str += s + " ";
            }
            
            Bukkit.broadcastMessage("§a[§6Info§a] » §r" + str);
            return true;
        }
    }

}
