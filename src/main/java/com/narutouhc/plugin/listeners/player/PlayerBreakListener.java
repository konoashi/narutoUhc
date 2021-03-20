package com.narutouhc.plugin.listeners.player;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.utils.EnumOre;
import com.narutouhc.plugin.utils.GameStatus;

public class PlayerBreakListener implements Listener
{
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e)
    {
        if(GameStatus.isStatus(GameStatus.GAME))
        {
            if(e.getBlock().getType() == Material.GOLD_ORE || e.getBlock().getType() == Material.IRON_ORE)
            {
                e.setCancelled(true);
                EnumOre ore = null;

                if(e.getBlock().getType() == Material.GOLD_ORE)
                    ore = EnumOre.GOLD;
                else
                    ore = EnumOre.IRON;

                Location loc = e.getBlock().getLocation().clone();

                e.getBlock().setType(Material.AIR);

                e.setExpToDrop(EnumOre.getXpFromBlock(ore));
                loc.getWorld().dropItemNaturally(loc, new ItemStack(EnumOre.getResultFromBlock(ore)));
            }
            else if(e.getBlock().getType() == Material.GRAVEL)
            {
                e.setCancelled(true);

                Location loc = e.getBlock().getLocation().clone();
                e.getBlock().setType(Material.AIR);

                loc.getWorld().dropItemNaturally(loc, new ItemStack(Material.ARROW));
            }
            else if(e.getBlock().getType() == Material.DIAMOND_ORE)
            {
                if(Main.getInstance().diamonds.get(e.getPlayer()) < Main.getInstance().getConfig().getInt("diamondlimit"))
                {
                    if(Main.getInstance().diamonds.get(e.getPlayer()) == Main.getInstance().getConfig().getInt("diamondlimit") - 1)
                    {
                        e.getPlayer().sendMessage(Main.getInstance().getPrefix() + "§c/§e!§c\\ Vous venez de dépasser votre §blimite de diamants");
                    }
                    Main.getInstance().diamonds.replace(e.getPlayer(), Main.getInstance().diamonds.get(e.getPlayer()) + 1);
                }
                else
                {
                    e.setCancelled(true);

                    Location loc = e.getBlock().getLocation().clone();

                    e.getBlock().setType(Material.AIR);

                    loc.getWorld().dropItemNaturally(loc, new ItemStack(EnumOre.getResultFromBlock(EnumOre.GOLD)));
                }
            }
        }
        else if(!e.getPlayer().isOp())
            e.setCancelled(true);
    }
}
