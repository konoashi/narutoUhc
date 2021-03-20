package com.narutouhc.plugin.listeners.player;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.roles.konoha.Choji;
import com.narutouhc.plugin.roles.konoha.Minato;

public class PlayerGuiInteractListener implements Listener
{
    @EventHandler
    public void onGuiClick(InventoryClickEvent e)
    {
        Inventory inv = e.getClickedInventory();

        if(inv == null)
            return;

        if(inv.getTitle() != null && inv.getTitle().equalsIgnoreCase("Super pouvoir"))
        {
            Player p = (Player)e.getWhoClicked();

            GamePlayer gp = GamePlayer.gamePlayers.get(p);

            ItemStack item = e.getCurrentItem();

            if(item == null)
                return;

            if(gp.isChoji())
            {
                SkullMeta skull = (SkullMeta)item.getItemMeta();
                Player target = Bukkit.getPlayer(skull.getOwner());
                ((Choji)gp.getPower()).damagePlayer(target);

                p.closeInventory();
                e.setCancelled(true);
            }
            else if(gp.isMinato())
            {
                SkullMeta skull = (SkullMeta)item.getItemMeta();
                Player target = Bukkit.getPlayer(skull.getOwner());

                ((Minato)gp.getPower()).teleport(target);
                p.closeInventory();

                e.setCancelled(true);
            }

        }
        else if(inv.getTitle() != null && inv.getTitle().equalsIgnoreCase("Inventaire par défaut"))
        {
            if(e.getCurrentItem() != null && e.getCurrentItem().getType() == Material.BARRIER)
                e.setCancelled(true);
        }

    }
}
