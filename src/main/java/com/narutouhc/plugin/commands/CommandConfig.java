package com.narutouhc.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.utils.StuffUtil;

public class CommandConfig implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(args.length == 2)
        {
            if(args[0].equalsIgnoreCase("inv"))
            {
                if(args[1].equalsIgnoreCase("default"))
                {
                    Main.getInstance().getConfig().set("inv", "default");
                    StuffUtil.setDefaultItems();
                    sender.sendMessage(Main.getInstance().getPrefix() + "§aVous avez bien mis la configuration de l'inventaire à §6default");
                }
                else if(args[1].equalsIgnoreCase("uhc"))
                {
                    Main.getInstance().getConfig().set("inv", "uhc");
                    StuffUtil.setDefautltUhcStuff();
                    sender.sendMessage(Main.getInstance().getPrefix() + "§aVous avez bien mis la configuration de l'inventaire à §6uhc");
                }
                else
                    sender.sendMessage(Main.getInstance().getPrefix() + "§cVeuillez sélectionner une configuration valide");
            
                Main.getInstance().saveConfig();
            }
        }

        return false;
    }

}
