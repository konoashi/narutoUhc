package com.narutouhc.plugin.listeners.player;

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
            
            e.setDeathMessage(Main.getInstance().getPrefix() + p.getDisplayName() + " §cest mort.\nIl était §5" + gp.getRole().name());
        }
        else
        {
            Kakuzu kakuzu = (Kakuzu)Main.getInstance().roles.get(p);
            
            if(kakuzu.hasRespawned)
            {
                e.setDeathMessage(Main.getInstance().getPrefix() + p.getDisplayName() + " §cest mort.\nIl était §5" + gp.getRole().name());
            }
            else
            {
                kakuzu.respawnInv = p.getInventory().getContents();
                e.getDrops().clear();
            }
        }
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
                p.getInventory().setContents(kakuzu.respawnInv);
            }
        }
    }
}