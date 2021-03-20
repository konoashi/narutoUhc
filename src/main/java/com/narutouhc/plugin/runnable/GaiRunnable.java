package com.narutouhc.plugin.runnable;

import org.bukkit.scheduler.BukkitRunnable;

import com.narutouhc.plugin.roles.Role;

public class GaiRunnable extends BukkitRunnable
{
    private Role role;
    private int timer = 60;
    
    public GaiRunnable(Role r)
    {
        this.role = r;
    }

    @Override
    public void run()
    {
        if(this.timer >= 1)
        {
            this.timer --;
        }
        else
        {
            this.role.p.setHealth(0);
            this.cancel();
        }
    }

}
