package com.narutouhc.plugin.roles.konoha;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;

public class Minato extends Role
{
    private Map<Player, Boolean> balises = new HashMap<Player, Boolean>();

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

    public void teleport(Player pl)
    {
        if(this.balises.containsKey(pl))
        {
            if(!this.balises.get(pl))
            {
                Location pLoc = pl.getLocation().clone();

                Location before = this.p.getLocation().clone();

                this.p.teleport(pLoc);

                this.p.getWorld().strikeLightning(before);

                this.balises.replace(pl, true);
            }
        }
    }

    @Override
    public void useAbility()
    {
        Inventory inv = Bukkit.createInventory(null, 9, "Super pouvoir");

        for(Player pl : balises.keySet())
        {
            if(!this.balises.get(pl))
            {
                ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
                SkullMeta skull = (SkullMeta)item.getItemMeta();
                skull.setOwner(pl.getName());
                skull.setDisplayName("§6" + pl.getName());
                item.setItemMeta(skull);

                inv.addItem(item);
            } 
        }

        this.p.openInventory(inv);
    }

    public Map<Player, Boolean> getTargets()
    {
        return this.balises;
    }
}
