package com.narutouhc.plugin.roles.konoha;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.narutouhc.plugin.roles.Role;

public class Minato extends Role
{
    private List<Player> balises;

    public Minato(Player p)
    {
        super(p);
        this.p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 30, 2, true, false));
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
}