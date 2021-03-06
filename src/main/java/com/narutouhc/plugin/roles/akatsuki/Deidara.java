package com.narutouhc.plugin.roles.akatsuki;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;
import org.bukkit.entity.Player;

public class Deidara extends Role
{
    public Deidara(Player p){
		super(p);
		this.type = EnumRole.DEIDARA;
		Main.getInstance().akatsukis.add(p);
		
        if(Main.getInstance().roles.containsKey(p))
        {
            Main.getInstance().roles.remove(p);
        }
        
        Main.getInstance().roles.put(p, this);
	}
}
