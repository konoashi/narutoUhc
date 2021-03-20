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
            else if(args[0].equalsIgnoreCase("diamondlimit"))
            {
                if(args[1].equalsIgnoreCase("false"))
                {
                    Main.getInstance().getConfig().set("diamondlimit", 1500);
                    sender.sendMessage(Main.getInstance().getPrefix() + "§aVous avez bien désactivé la limite de diamants");
                }
                else if(args[1].equalsIgnoreCase("default"))
                {
                    Main.getInstance().getConfig().set("diamondlimit", 17);
                    sender.sendMessage(Main.getInstance().getPrefix() + "§aVous avez bien mis la limite de diamants à §617");
                }
                else
                {
                    try
                    {
                        Main.getInstance().getConfig().set("diamondlimit", Integer.parseInt(args[1]));
                        sender.sendMessage(Main.getInstance().getPrefix() + "§aVous avez bien mis la limite de diamants à §6" + args[1]);
                    }
                    catch(NumberFormatException e)
                    {
                        sender.sendMessage(Main.getInstance().getPrefix() + "§cVeuillez sélectionner un nombre valide");
                    }
                }
                Main.getInstance().saveConfig();
            }
            else if(args[0].equalsIgnoreCase("whitelist"))
            {
                if(args[1].equalsIgnoreCase("true"))
                {
                    Main.getInstance().getConfig().set("whitelist", true);
                    sender.sendMessage(Main.getInstance().getPrefix() + "§aVous venez d'activer la §6whitelist §ade la partie");
                }
                else if(args[1].contentEquals("false"))
                {
                    Main.getInstance().getConfig().set("whitelist", false);
                    sender.sendMessage(Main.getInstance().getPrefix() + "§aVous venez de désactiver la §6whitelist §ade la partie"); 
                }
                else
                    sender.sendMessage(Main.getInstance().getPrefix() + "§cVeuillez sélectionner une option valide");
                
                Main.getInstance().saveConfig();
            }
        }

        return false;
    }

}
