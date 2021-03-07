package com.narutouhc.plugin.listeners.player;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.roles.konoha.Shikamaru;

public class PlayerDamageListener implements Listener
{
    @EventHandler(priority = EventPriority.LOWEST)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e)
    {
        if(e.getDamager() instanceof Arrow && e.getEntity() instanceof Player)
        {
            Arrow a = (Arrow)e.getDamager();

            if(a.getShooter() instanceof Player)
            {
                Player d = (Player)a.getShooter();

                GamePlayer gp = GamePlayer.gamePlayers.get(d);

                if(gp.isShikamaru())
                {
                    ((Shikamaru)gp.getPower()).freezePlayer((Player)e.getEntity());
                }
            }
        }
    }
}
