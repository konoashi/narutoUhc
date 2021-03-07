package com.narutouhc.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.roles.EnumRole;

public class CommandMe implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(sender instanceof Player)
        {
            Player p = (Player) sender;
            
            GamePlayer gp = GamePlayer.gamePlayers.get(p);
            
            p.sendMessage("§2Vous êtes §e" + gp.getRole().name() + "§2\n" + EnumRole.getDescription(gp.getRole()));
            return true;
        }
        
        return false;
    }
}
