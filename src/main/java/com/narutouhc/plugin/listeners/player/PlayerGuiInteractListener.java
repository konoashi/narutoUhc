package com.narutouhc.plugin.listeners.player;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.akatsuki.Hidan;
import com.narutouhc.plugin.roles.akatsuki.Ningendo;
import com.narutouhc.plugin.roles.konoha.Choji;
import com.narutouhc.plugin.roles.konoha.Minato;

public class PlayerGuiInteractListener implements Listener
{
    @EventHandler(priority = EventPriority.LOWEST)
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

            if(gp.isRole(EnumRole.CHOJI))
            {
                if(item.getType() == Material.SKULL_ITEM)
                {
                    SkullMeta skull = (SkullMeta)item.getItemMeta();
                    Player target = Bukkit.getPlayer(skull.getOwner());
                    ((Choji)gp.getPower()).damagePlayer(target);

                    p.closeInventory();
                }
                e.setCancelled(true);
            }
            else if(gp.isRole(EnumRole.MINATO))
            {
                if(item.getType() == Material.SKULL_ITEM)
                {
                    SkullMeta skull = (SkullMeta)item.getItemMeta();
                    Player target = Bukkit.getPlayer(skull.getOwner());

                    ((Minato)gp.getPower()).teleport(target);
                    p.closeInventory();
                }
                e.setCancelled(true);
            }
            else if(gp.isRole(EnumRole.HIDAN))
            {
                if(item.getType() == Material.SKULL_ITEM)
                {
                    SkullMeta skull = (SkullMeta)item.getItemMeta();
                    Player target = Bukkit.getPlayer(skull.getOwner());

                    ((Hidan)gp.getPower()).target = target;

                    target.sendMessage(Main.getInstance().getPrefix() + "§cVous êtes désormais la cible d'Hidan");

                    p.sendMessage(Main.getInstance().getPrefix() + "§6" + target.getDisplayName() + "§c est maintenant votre cible");

                    ((Hidan)gp.getPower()).used = true;

                    p.setMaxHealth(20);
                    p.closeInventory();
                }
                e.setCancelled(true);
            }
            else if(gp.isRole(EnumRole.NINGENDO))
            {
                if(item.getType() == Material.SKULL_ITEM)
                {
                    SkullMeta skull = (SkullMeta)item.getItemMeta();
                    Player target = Bukkit.getPlayer(skull.getOwner());

                    target.sendMessage(Main.getInstance().getPrefix() + "§cNingendo a inspecté votre rôle");
                    p.sendMessage(Main.getInstance().getPrefix() + "§a" + target.getDisplayName() + " est §6" + GamePlayer.gamePlayers.get(target).getRole().name());
                    
                    Ningendo ningendo = (Ningendo)gp.getPower();
                    
                    ningendo.times ++;
                    
                    if(ningendo.times == 1)
                    {
                        p.sendMessage(Main.getInstance().getPrefix() + "§cIl vous reste §61 §cutilisation(s) de votre pouvoir");
                    }
                    else if(ningendo.times == 2)
                    {
                        p.sendMessage(Main.getInstance().getPrefix() + "§cIl vous reste §60 §cutilisation(s) de votre pouvoir");
                    }
                    
                    p.closeInventory();
                }
                e.setCancelled(true);
            }
        }
        else if(inv.getTitle() != null && inv.getTitle().equalsIgnoreCase("Inventaire par défaut"))
        {
            if(e.getCurrentItem() != null && e.getCurrentItem().getType() == Material.BARRIER)
                e.setCancelled(true);
        }
        else
            return;
    }
}
