package com.narutouhc.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.Main;

public class CommandGetRole implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(args.length == 1)
        {
            Player p = Bukkit.getPlayer(args[0]);

            if(p != null)
            {
                Main.getInstance().whitelist.add(p);

                sender.sendMessage(Main.getInstance().getPrefix() + "§a" + p.getName() + " a le rôle §6" + GamePlayer.gamePlayers.get(p).getRole().name());
            }
            else
                sender.sendMessage(Main.getInstance().getPrefix() + "§cImpossible de trouver le joueur spécifié");

        }

        return false;
    }

}
