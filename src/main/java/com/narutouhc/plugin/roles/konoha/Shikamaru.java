package com.narutouhc.plugin.roles.konoha;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;

public class Shikamaru extends Role
{
    public Shikamaru(Player player)
    {
        super(player);
        this.type = EnumRole.SHIKAMARU;
        Main.getInstance().konohas.add(player);
    }

    public void freezePlayer(Player target)
    {
        Location initial = target.getLocation().clone();
        
        new BukkitRunnable()
        {   
            int timer = 30;
            
            @Override
            public void run()
            {
                if(this.timer >= 1)
                {
                    target.teleport(initial);
                }
                else
                    this.cancel();
            }
        }.runTaskTimer(Main.getInstance(), 0, 1l);
    }
}
