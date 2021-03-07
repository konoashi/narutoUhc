package com.narutouhc.plugin.roles.konoha;

import java.util.List;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
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
        this.type = EnumRole.MINATO;
        this.p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 30, 2, true, false));
        Main.getInstance().konohas.add(p);
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