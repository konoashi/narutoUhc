package com.narutouhc.plugin.listeners.player;

import com.narutouhc.plugin.roles.konoha.Minato;
import com.narutouhc.plugin.utils.RolesUtils;
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
        if(e.getEntity() instanceof Player){
            if(e.getDamager() instanceof Arrow)
            {
                Arrow a = (Arrow)e.getDamager();

                if(a.getShooter() instanceof Player)
                {
                    Player d = (Player)a.getShooter();

                    GamePlayer gp = GamePlayer.gamePlayers.get(d);

                    if(gp.isShikamaru() && (Player)e.getEntity() != d)
                    {
                        ((Shikamaru)gp.getPower()).freezePlayer((Player)e.getEntity());
                    }
                }
            } else if(e.getDamager() instanceof Player)
            {
                Player player = (Player)e.getDamager();
                Player damaged = (Player)e.getEntity();

                GamePlayer gp = GamePlayer.gamePlayers.get(player);

                if(gp.isMinato()){
                    Minato minato = (Minato) gp.getPower();
                    if(minato.getTargets().size() < 2){
                        minato.getTargets().add(damaged);
                        player.sendMessage();
                    }
                }

            }
        }
    }
}
