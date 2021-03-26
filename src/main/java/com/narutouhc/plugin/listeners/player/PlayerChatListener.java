package com.narutouhc.plugin.listeners.player;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.narutouhc.plugin.Main;

public class PlayerChatListener implements Listener
{
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e)
    {
        Player p = e.getPlayer();

        e.setCancelled(true);

        if(Main.getInstance().players.contains(p))
        {
            for(Entity ent : p.getNearbyEntities(20, 20, 20))
            {
                if(ent instanceof Player)
                {
                    Player pl = (Player)ent;

                    pl.sendMessage("§a" + p.getDisplayName() + " » §r" + e.getMessage());
                }
            }
        }

        p.sendMessage("§a" + p.getDisplayName() + " » §r" + e.getMessage());
    }
}
