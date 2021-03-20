package com.narutouhc.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.narutouhc.plugin.Main;

public class CommandAllow implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(args.length == 1)
        {
            Player p = Bukkit.getPlayer(args[0]);

            if(Main.getInstance().getConfig().getBoolean("whitelist"))
            {
                if(p != null)
                {
                    Main.getInstance().whitelist.add(p);
                    
                    sender.sendMessage(Main.getInstance().getPrefix() + "§a" + p.getName() + " a bien été rajouté dans la §6whitelist");
                }
                else sender.sendMessage(Main.getInstance().getPrefix() + "§cImpossible de trouver le joueur spécifié");
            }
            else sender.sendMessage(Main.getInstance().getPrefix() + "§cLa partie n'est pas en §6Whitelist");
        }

        return false;
    }

}
