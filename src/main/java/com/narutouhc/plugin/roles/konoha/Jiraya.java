package com.narutouhc.plugin.roles.konoha;

import org.bukkit.entity.Player;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;
import com.narutouhc.plugin.runnable.JirayaRunnable;

public class Jiraya extends Role
{
    public boolean isNearNaruto = false;
    private JirayaRunnable jirayaRunnable;
    
    public Jiraya(Player player)
    {
        super(player);
        this.type = EnumRole.JIRAYA;
        Main.getInstance().konohas.add(player);

        if(Main.getInstance().roles.containsKey(p))
        {
            Main.getInstance().roles.remove(p);
        }
        this.jirayaRunnable = new JirayaRunnable(this);
        
        this.jirayaRunnable.runTaskTimer(Main.getInstance(), 0, 20);
        
        Main.getInstance().roles.put(p, this);
    }
}
