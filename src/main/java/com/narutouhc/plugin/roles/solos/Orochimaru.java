package com.narutouhc.plugin.roles.solos;

import org.bukkit.entity.Player;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;

public class Orochimaru extends Role
{
    public Orochimaru(Player player)
    {
        super(player);
        this.type = EnumRole.OROCHIMARU;
        Main.getInstance().solos.add(player);
        this.p.setMaxHealth(20 + 10);
        
        if(Main.getInstance().roles.containsKey(p))
        {
            Main.getInstance().roles.remove(p);
        }
        
        Main.getInstance().roles.put(p, this);
    }

    public void sasukeDie()
    {
        this.p.setMaxHealth(8 * 2);
    }
}
