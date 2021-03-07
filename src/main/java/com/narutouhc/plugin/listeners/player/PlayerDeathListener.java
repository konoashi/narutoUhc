package com.narutouhc.plugin.listeners.player;

import com.narutouhc.plugin.roles.Role;
import com.narutouhc.plugin.roles.solos.Orochimaru;
import com.narutouhc.plugin.roles.solos.Sasuke;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.akatsuki.Kakuzu;

public class PlayerDeathListener implements Listener
{
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e)
    {
        Player p = e.getEntity();

        GamePlayer gp = GamePlayer.gamePlayers.get(p);

        if(!gp.isKakuzu())
        {
            if(Main.getInstance().konohas.contains(p))
            {
                Main.getInstance().konohas.remove(p);
            }
            else if(Main.getInstance().akatsukis.contains(p))
            {
                Main.getInstance().akatsukis.remove(p);
            }
            else if(Main.getInstance().solos.contains(p))
            {
                Main.getInstance().solos.remove(p);
            }

            if(gp.isOrochimaru())
            {
                Player sasukePl = Main.getInstance().solos.get(0);

                GamePlayer sasukeGP = GamePlayer.gamePlayers.get(sasukePl);

                if(sasukeGP.isSasuke())
                {
                    ((Orochimaru) Main.getInstance().roles.get(sasukePl)).sasukeDie();
                }

            } else if(gp.isSasuke())
            {
                Player orochimaruPl = Main.getInstance().solos.get(0);

                GamePlayer orochimaruGP = GamePlayer.gamePlayers.get(orochimaruPl);

                if(orochimaruGP.isOrochimaru())
                {
                    ((Orochimaru) Main.getInstance().roles.get(orochimaruPl)).sasukeDie();
                }

            }
            
        }
        else
        {
            Kakuzu kakuzu = (Kakuzu)Main.getInstance().roles.get(p);
            
            if(!kakuzu.hasRespawned)
            {
                kakuzu.respawnInv = p.getInventory().getContents();
                e.getDrops().clear();
            }
        }

        e.setDeathMessage(Main.getInstance().getPrefix() + p.getDisplayName() + " §cest mort ! Il était §6" + gp.getRole().name());
    }
    
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e)
    {
        Player p = e.getPlayer();
        
        GamePlayer gp = GamePlayer.gamePlayers.get(p);
        
        if(!gp.isKakuzu())
        {
            p.setGameMode(GameMode.SPECTATOR);
        }
        else
        {
            Kakuzu kakuzu = (Kakuzu)Main.getInstance().roles.get(p);

            if(kakuzu.hasRespawned)
            {
                p.setGameMode(GameMode.SPECTATOR);
            }
            else
            {
                kakuzu.useAbility();
                p.getInventory().setContents(kakuzu.respawnInv);
            }
        }
    }
}
