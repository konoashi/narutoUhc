package com.narutouhc.plugin.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class ConstrucTabComplete implements TabCompleter
{

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args)
    {
        if(sender instanceof Player)
        {
            if(command.getName().equalsIgnoreCase("role"))
            {
                List<String> list = new ArrayList<String>();
                
                if(args.length == 1)
                {
                    list = Arrays.asList("naruto", "sakura", "shikamaru", "choji", "minato", "sasuke", "orochimaru", "kakuzu", "itachi", "deidara", "pain");
                }
                
                return list;
            }
        }
        
        return null;
    }

}
