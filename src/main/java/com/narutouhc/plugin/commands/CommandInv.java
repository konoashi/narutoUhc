package com.narutouhc.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
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

            Inventory inv = Bukkit.createInventory(null, 9 * 4, "Inventaire par défaut");

            for(ItemStack s : Main.getInstance().startInv.keySet())
            {
                if(s != null)
                    inv.setItem(Main.getInstance().startInv.get(s), s);
            }

            inv.setItem(31, new ItemStack(Material.BARRIER));
            inv.setItem(32, new ItemStack(Material.BARRIER));
            inv.setItem(33, new ItemStack(Material.BARRIER));
            inv.setItem(34, new ItemStack(Material.BARRIER));
            inv.setItem(35, new ItemStack(Material.BARRIER));

            p.openInventory(inv);

            return true;
        }

        return false;
    }

}
