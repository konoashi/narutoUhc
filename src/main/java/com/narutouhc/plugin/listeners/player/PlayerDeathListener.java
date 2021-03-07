package com.narutouhc.plugin.listeners.player;

import com.narutouhc.plugin.utils.RolesUtils;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.akatsuki.Kakuzu;
import com.narutouhc.plugin.roles.solos.Orochimaru;
import com.narutouhc.plugin.roles.solos.Sasuke;

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
                Player sasuke = RolesUtils.getSasuke();

                GamePlayer sasukeGp = GamePlayer.gamePlayers.get(sasuke);

                if(sasuke != null && sasukeGp.isSasuke())
                {
                    ((Sasuke)Main.getInstance().roles.get(sasuke)).orochimaruDie();
                }

            }
            else if(gp.isSasuke())
            {
                Player orochimaru = RolesUtils.getOrochimaru();

                GamePlayer orochimaruGp = GamePlayer.gamePlayers.get(orochimaru);

                if(orochimaru != null && orochimaruGp.isOrochimaru())
                {
                    ((Orochimaru)Main.getInstance().roles.get(orochimaru)).sasukeDie();
                }

            }

            ItemStack s = null;

            for(ItemStack stack : e.getDrops())
            {
                if(stack.getType() == Material.NETHER_STAR)
                {
                    s = stack;
                }
            }
            
            e.getDrops().remove(s);
            e.setDeathMessage(Main.getInstance().getPrefix() + p.getDisplayName() + " §cest mort ! Il était §6" + gp.getRole().name());

        }
        else
        {
            Kakuzu kakuzu = (Kakuzu)Main.getInstance().roles.get(p);

            if(!kakuzu.hasRespawned)
            {
                kakuzu.respawnInv = p.getInventory().getContents();
                e.getDrops().clear();
            }
            else
            {
                e.setDeathMessage(Main.getInstance().getPrefix() + p.getDisplayName() + " §cest mort ! Il était §6" + gp.getRole().name());
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
                kakuzu.useAbility();
                p.getInventory().setContents(kakuzu.respawnInv);
            }
        }
    }
}
