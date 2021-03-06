package com.narutouhc.plugin.roles.konoha;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;

public class Naruto extends Role
{
    private boolean ticks;

    public Naruto(Player player)
    {
        super(player);
        this.type = EnumRole.NARUTO;
        this.ticks = false;
        this.setDefaultCooldown(5 * 60);
        Main.getInstance().konohas.add(player);
    }

    @Override
    public void useAbility()
    {
        if(this.isAvailable())
        {
            this.p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 30, 1, true, false));
            this.p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20 * 30, 0, true, false));
            this.setCurrentCooldown(this.getDefaultCooldown());
            this.p.sendMessage(Main.getInstance().getPrefix() + "§aVous venez d'utiliser votre §6POUVOIR");

            if(ticks)
            {
                this.getPowerRunnable().runTaskTimer(Main.getInstance(), 0, 1l);
            }
            else
            {
                this.getPowerRunnable().runTaskTimer(Main.getInstance(), 0, 20l);
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
