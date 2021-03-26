package com.narutouhc.plugin.roles;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;

import com.narutouhc.plugin.runnable.PowerRunnable;

public class Role
{
    public Player p;
    private int defaultCooldown = 20 * 60 * 5;
    private int currentCooldown = 0;
    public boolean isPainBody = false;
    
    protected PowerRunnable powerRunnable;

    public EnumRole type = EnumRole.NONE;

    public Role(Player player)
    {
        this.p = player;

        if(p.getScoreboard() != null)
        {
            this.p.getScoreboard().clearSlot(DisplaySlot.BELOW_NAME);
        }

        this.powerRunnable = new PowerRunnable(this);
    }

    public void setDefaultCooldown(int i)
    {
        this.defaultCooldown = i;
    }

    public int getDefaultCooldown()
    {
        return this.defaultCooldown;
    }

    public void setCurrentCooldown(int i)
    {
        this.currentCooldown = i;
    }

    public int getCurrentCooldown()
    {
        return this.currentCooldown;
    }

    public void resetCurrentCooldown()
    {
        this.currentCooldown = this.defaultCooldown;
    }

    public void useAbility()
    {}

    public void addCooldown(int i)
    {
        this.currentCooldown += i;
    }

    public void shrinkCooldown(int i)
    {
        this.currentCooldown -= i;
    }

    public boolean isAvailable()
    {
        return this.currentCooldown == 0;
    }

    public PowerRunnable getPowerRunnable()
    {
        return this.powerRunnable;
    }
}
