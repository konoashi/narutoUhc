package com.narutouhc.plugin.listeners.player;

import org.bukkit.Material;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;

public class PlayerInteractListener implements Listener
{
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e)
    {
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
        {
            if(e.getItem() != null && e.getItem().getType() == Material.EGG)
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
            else if(e.getItem() != null && e.getItem().getType() == Material.NETHER_STAR)
            {
                Player p = e.getPlayer();
                
                GamePlayer gp = GamePlayer.gamePlayers.get(p);
                
                if(gp.getRole() != EnumRole.NONE && !gp.isShikamaru() && !gp.isOrochimaru() && !gp.isKakuzu() && !gp.isDeidara() && !gp.isNinja() && !gp.isZetsu())
                {
                    gp.getPower().useAbility();
                }
                else
                    p.sendMessage(Main.getInstance().getPrefix() + "§cVous ne pouvez pas utiliser de pouvoir");
            }
        }
    }
}
