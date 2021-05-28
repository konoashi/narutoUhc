package com.narutouhc.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.Main;

public class CommandCancel implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(args.length == 1)
        {
            Player p = Bukkit.getPlayer(args[0]);

            if(p != null)
            {
                if(Main.getInstance().players.contains(p))
                {
                    GamePlayer gp = GamePlayer.gamePlayers.get(p);
                    
                    gp.getPower().setCurrentCooldown(0);
                }
            }
            else
                sender.sendMessage(Main.getInstance().getPrefix() + "§cImpossible de trouver le joueur spécifié");
        }

        return false;
    }

}
