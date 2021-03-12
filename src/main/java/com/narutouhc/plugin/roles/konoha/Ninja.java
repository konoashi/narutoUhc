package com.narutouhc.plugin.roles.konoha;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;
import org.bukkit.entity.Player;

public class Ninja extends Role
{
    public Ninja(Player p)
    {
        super(p);
        this.type = EnumRole.VILLAGEOIS;
        Main.getInstance().konohas.add(p);

        if(Main.getInstance().roles.containsKey(p))
        {
            Main.getInstance().roles.remove(p);
        }

        Main.getInstance().roles.put(p, this);
    }
}
