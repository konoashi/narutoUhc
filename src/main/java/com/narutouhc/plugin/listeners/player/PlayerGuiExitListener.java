package com.narutouhc.plugin.listeners.player;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import com.narutouhc.plugin.Main;

public class PlayerGuiExitListener implements Listener
{
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e)
    {
        if(e.getInventory().getName().equalsIgnoreCase("Inventaire par défaut"))
        {
            boolean hasItem = false;

            for(ItemStack s : e.getInventory())
            {
                if(s != null && s.getType() == Material.NETHER_STAR)
                    hasItem = true;
            }

            if(!hasItem)
            {
                e.getPlayer().sendMessage(Main.getInstance().getPrefix() + "§cVous devez au moins mettre la §6NETHER_STAR");
            }
            else
            {
                Main.getInstance().startInv.clear();
                
                for(ItemStack s : e.getInventory())
                {
                    Main.getInstance().startInv.put(s, Arrays.asList(e.getInventory().getContents()).indexOf(s));
                }
                
                e.getPlayer().sendMessage(Main.getInstance().getPrefix() + "§aVous avez bien actualisé l'inventaire par défaut");
            }            
        }
    }
}
