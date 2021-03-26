package com.narutouhc.plugin.roles.akatsuki;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;

public class Hidan extends Role
{
    public Player target = null;
    public boolean used = false;

    public Hidan(Player player)
    {
        super(player);
        this.type = EnumRole.HIDAN;
        Main.getInstance().akatsukis.add(player);

        if(Main.getInstance().roles.containsKey(p))
        {
            Main.getInstance().roles.remove(p);
        }

        this.p.setMaxHealth(20 + 4);

        Main.getInstance().roles.put(p, this);
    }

    @Override
    public void useAbility()
    {
        if(!this.used)
        {
            Inventory inv = Bukkit.createInventory(null, Main.getInstance().getServer().getMaxPlayers() > 9 ? 18 : Main.getInstance().getServer().getMaxPlayers() > 18 ? 27 : 9 , "Super pouvoir");

            for(Player p : Main.getInstance().getServer().getOnlinePlayers())
            {
                if(p.getGameMode() == GameMode.SURVIVAL)
                {
                    ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
                    SkullMeta skull = (SkullMeta)item.getItemMeta();
                    skull.setOwner(p.getName());
                    skull.setDisplayName("§6" + p.getName());
                    item.setItemMeta(skull);

                    inv.addItem(item);
                }
            }

            this.p.openInventory(inv);
        }
        else
        {
            this.p.sendMessage(Main.getInstance().getPrefix() + "§cVous avez déjà choisi votre §6cible");
        }
    }
}
