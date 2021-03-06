package com.narutouhc.plugin.roles.solos;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;

public class Sasuke extends Role
{
    private boolean ticks;
    public boolean hasWeakness = false;
    
    public Sasuke(Player player)
    {
        super(player);
        this.type = EnumRole.SASUKE;
        Main.getInstance().solos.add(player);
        this.setDefaultCooldown(5 * 60);
        this.ticks = false;
        
        if(Main.getInstance().roles.containsKey(p))
        {
            Main.getInstance().roles.remove(p);
        }
        
        Main.getInstance().roles.put(p, this);
        
        this.powerRunnable.runTaskTimer(Main.getInstance(), 0, 20);
    }

    @Override
    public void useAbility()
    {
        if(this.isAvailable())
        {
            for(Entity e : this.p.getNearbyEntities(5, 5, 5))
            {
                if(e instanceof Player)
                {
                    Player pl = (Player)e;

                    if(!Main.getInstance().solos.contains(pl))
                    {
                        this.p.getWorld().strikeLightning(pl.getLocation());
                    }
                }
            }

            this.setCurrentCooldown(this.getDefaultCooldown());
            this.p.sendMessage(Main.getInstance().getPrefix() + "§aVous venez d'utiliser votre §6POUVOIR");

            this.getPowerRunnable().start = true;
        }
        else
        {
            int remaining = 0;
            String format = "";

            if(this.ticks)
            {
                remaining = this.getCurrentCooldown() / 20;

                if(remaining > 1)
                    format = "secondes";
                else
                    format = "seconde";

                if(remaining >= 60)
                {
                    remaining /= 60;

                    if(remaining > 1)
                        format = "minutes";
                    else
                        format = "minute";
                }
            }
            else
            {
                remaining = this.getCurrentCooldown();

                if(remaining > 1)
                    format = "secondes";
                else
                    format = "seconde";

                if(remaining >= 60)
                {
                    remaining /= 60;

                    if(remaining > 1)
                        format = "minutes";
                    else
                        format = "minute";
                }
            }

            this.p.sendMessage(Main.getInstance().getPrefix() + "§cVous devez encore attendre §6" + remaining + " §c" + format + " avant de réutiliser votre pouvoir");
        }
    }

    public void orochimaruDie()
    {
        this.hasWeakness = true;
        this.p.sendMessage(Main.getInstance().getPrefix() + "§eOrochimaru §cest mort ! Vous aurez maintenant §dFaiblesse 1 §c!");
    }
}
