package com.narutouhc.plugin.roles;

import org.bukkit.entity.Player;

public class Role
{
    public Player p;
    private long cooldown;

    public Role(Player player)
    {
        this.p = player;
    }

    public void setCooldown(long l)
    {
        this.cooldown = l;
    }
    
    public long getCooldown()
    {
        return this.cooldown;
    }
}
