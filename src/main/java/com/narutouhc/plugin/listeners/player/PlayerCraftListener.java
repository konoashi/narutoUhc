package com.narutouhc.plugin.listeners.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.recipes.akatsuki.ExplosiveEgg;

public class PlayerCraftListener implements Listener
{
    @EventHandler
    public void onPlayerCraft(CraftItemEvent e)
    {
        if(e.getRecipe() == ExplosiveEgg.recipe)
        {
            Player p = (Player)e.getWhoClicked();
            
            GamePlayer gp = GamePlayer.gamePlayers.get(p);
            
            if(!gp.isDeidara())
            {
                e.setCancelled(true);
            }
        }
    }
}
