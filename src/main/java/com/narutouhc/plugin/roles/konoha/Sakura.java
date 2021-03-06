package com.narutouhc.plugin.roles.konoha;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;

public class Sakura extends Role
{
    private boolean ticks;

    public Sakura(Player player)
    {
        super(player);
        this.type = EnumRole.SAKURA;
        this.ticks = false;
        this.setDefaultCooldown(5 * 60);
        Main.getInstance().konohas.add(player);
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
                    
                    if(Main.getInstance().konohas.contains(pl))
                    {
                        pl.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20 * 30, 0, true, false));
                    }
                }
            }

            this.setCurrentCooldown(this.getDefaultCooldown());
            this.p.sendMessage(Main.getInstance().getPrefix() + "§aVous venez d'utiliser votre §6POUVOIR");

            if(ticks)
            {
                this.getPowerRunnable().runTaskTimer(Main.getInstance(), 0, 1L);
            }
            else
            {
                this.getPowerRunnable().runTaskTimer(Main.getInstance(), 0, 20L);
            }
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
}
