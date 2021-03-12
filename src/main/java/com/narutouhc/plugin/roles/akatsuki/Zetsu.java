package com.narutouhc.plugin.roles.akatsuki;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;
import org.bukkit.entity.Player;

public class Zetsu extends Role
{
    public Zetsu(Player p)
    {
        super(p);
        this.type = EnumRole.ZETSU;
        Main.getInstance().akatsukis.add(p);

        if(Main.getInstance().roles.containsKey(p))
        {
            Main.getInstance().roles.remove(p);
        }

        Main.getInstance().roles.put(p, this);
    }
}
