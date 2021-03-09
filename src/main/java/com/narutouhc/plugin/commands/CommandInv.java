package com.narutouhc.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.narutouhc.plugin.Main;

public class CommandInv implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(sender instanceof Player)
        {
            Player p = (Player)sender;

            Inventory inv = Bukkit.createInventory(null, 9 * 3, "Inventaire par défaut");

            for(ItemStack s : Main.getInstance().startInv)
            {
                if(s != null)
                    inv.addItem(s);
            }

            p.openInventory(inv);

            return true;
        }

        return false;
    }

}
