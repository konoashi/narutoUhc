package com.narutouhc.plugin.listeners.player;

import org.bukkit.Material;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.narutouhc.plugin.GamePlayer;

public class PlayerInteractListener implements Listener
{
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e)
    {
        if(e.getItem().getType() == Material.EGG)
        {
            if(e.getItem().hasItemMeta() && e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cOeuf explosif"))
            {
                Player p = e.getPlayer();
                GamePlayer gp = GamePlayer.gamePlayers.get(p);
                
                if(gp.isDeidara())
                {
                    e.setCancelled(true);
                    e.getItem().setAmount(e.getItem().getAmount() - 1);
                    
                    p.launchProjectile(Egg.class).setCustomName("§cOeuf explosif");
                }
            }
        }
    }
}
