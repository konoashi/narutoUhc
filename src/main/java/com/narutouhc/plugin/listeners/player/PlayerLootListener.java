package com.narutouhc.plugin.listeners.player;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import com.narutouhc.plugin.Main;

public class PlayerLootListener implements Listener
{
    @EventHandler(priority = EventPriority.LOWEST)
    public void onItemLoot(PlayerDropItemEvent e)
    {
        if(e.getItemDrop().getItemStack().getType() == Material.NETHER_STAR)
        {
            e.getPlayer().sendMessage(Main.getInstance().getPrefix() + "§cVous ne pouvez pas jeter cet item");
            e.setCancelled(true);
        }
        else
            return;
    }
}
