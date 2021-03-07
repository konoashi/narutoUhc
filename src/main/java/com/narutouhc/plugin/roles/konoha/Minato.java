package com.narutouhc.plugin.roles.konoha;

import java.util.List;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.narutouhc.plugin.roles.Role;

public class Minato extends Role
{
    private List<Player> balises;

    public Minato(Player p)
    {
        super(p);
        this.type = EnumRole.MINATO;
        this.p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 30, 2, true, false));
        Main.getInstance().konohas.add(p);
        
        if(Main.getInstance().roles.containsKey(p))
        {
            Main.getInstance().roles.remove(p);
        }
        
        Main.getInstance().roles.put(p, this);
    }

    public void teleport(Player p)
    {
        if(this.balises.contains(p))
        {
            Location pLoc = p.getLocation();
            this.p.teleport(pLoc);
            this.balises.remove(p);
        }
    }

    @Override
    public void useAbility()
    {
        Inventory inv = Bukkit.createInventory(null, 9, "Se téléporter");

        for(Player p : balises)
        {
            ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
            SkullMeta skull = (SkullMeta)item.getItemMeta();
            skull.setOwner(p.getName());
            skull.setDisplayName("§6" + p.getName());
            item.setItemMeta(skull);

            inv.addItem(item);
        }

        this.p.openInventory(inv);
    }
}