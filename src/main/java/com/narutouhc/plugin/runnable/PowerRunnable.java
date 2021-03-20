package com.narutouhc.plugin.runnable;

import org.bukkit.scheduler.BukkitRunnable;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.Role;

public class PowerRunnable extends BukkitRunnable
{
    private Role role;
    public boolean start = false;

    public PowerRunnable(Role r)
    {
        this.role = r;
    }

    @Override
    public void run()
    {
        if(this.start)
        {
            if(this.role.getCurrentCooldown() >= 1)
            {
                this.role.shrinkCooldown(1);
            }
            else
            {
                this.role.p.sendMessage(Main.getInstance().getPrefix() + "§aVotre pouvoir est désormais rechargé");
                this.start = false;
            }
        }
    }

}
