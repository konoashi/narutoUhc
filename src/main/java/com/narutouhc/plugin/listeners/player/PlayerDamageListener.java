package com.narutouhc.plugin.listeners.player;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.akatsuki.Hidan;
import com.narutouhc.plugin.roles.konoha.Minato;
import com.narutouhc.plugin.roles.konoha.Shikamaru;
import com.narutouhc.plugin.utils.RolesUtils;

public class PlayerDamageListener implements Listener
{
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e)
    {
        if(e.getEntity() instanceof Player)
        {
            if(Main.getInstance().pluginRunnable.ep >= 2)
            {
                if(e.getDamager() instanceof Arrow)
                {
                    Arrow a = (Arrow)e.getDamager();

                    if(a.getShooter() instanceof Player)
                    {
                        Player d = (Player)a.getShooter();

                        GamePlayer gp = GamePlayer.gamePlayers.get(d);

                        if(RolesUtils.getHidan() != null)
                        {
                            Player hidanTarget = ((Hidan)GamePlayer.gamePlayers.get(RolesUtils.getHidan()).getPower()).target;

                            if(((Player)e.getEntity()) == RolesUtils.getHidan() && hidanTarget == d)
                            {
                                d.damage(e.getDamage() / 2);
                                e.setCancelled(true);
                            }
                        }

                        if(gp.isRole(EnumRole.SHIKAMARU) && (Player)e.getEntity() != d && ((Shikamaru)gp.getPower()).isAvailable())
                        {
                            ((Shikamaru)gp.getPower()).freezePlayer((Player)e.getEntity());
                        }
                    }
                }
                else if(e.getDamager() instanceof Player)
                {
                    Player player = (Player)e.getDamager();
                    Player damaged = (Player)e.getEntity();

                    GamePlayer gp = GamePlayer.gamePlayers.get(player);

                    if(RolesUtils.getHidan() != null)
                    {
                        Player hidanTarget = ((Hidan)GamePlayer.gamePlayers.get(RolesUtils.getHidan()).getPower()).target;

                        if(((Player)e.getEntity()) == RolesUtils.getHidan() && hidanTarget == player)
                        {
                            player.damage(e.getDamage() / 2);
                            e.setCancelled(true);
                        }
                    }
                    
                    if(gp.isRole(EnumRole.MINATO))
                    {
                        Minato minato = (Minato)gp.getPower();
                        if(!minato.getTargets().containsKey(damaged))
                        {
                            if(minato.getTargets().size() < 2)
                            {
                                minato.getTargets().put(damaged, false);
                                player.sendMessage(Main.getInstance().getPrefix() + "§eVous avez mis une balise sur §6" + damaged.getDisplayName());
                            }
                        }
                    }

                }
            }
            else
            {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e)
    {
        if(e.getEntity() instanceof Player)
        {
            if(Main.getInstance().pluginRunnable.ep == 1 && Main.getInstance().pluginRunnable.gameTimer > (20 * 60) - 30)
            {
                e.setCancelled(true);
            }
        }
    }
}
