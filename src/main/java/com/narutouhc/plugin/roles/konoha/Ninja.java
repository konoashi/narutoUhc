package com.narutouhc.plugin.roles.konoha;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Ninja extends Role
{
    public Ninja(Player p)
    {
        super(p);
        this.type = EnumRole.VILLAGEOIS;
        Main.getInstance().konohas.add(p);

        this.setDefaultCooldown(10 * 60);

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
            this.resetCurrentCooldown();

            this.p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 20 * 2 * 60, 0, false, false));

            this.p.sendMessage(Main.getInstance().getPrefix() + "§aVous venez d'utiliser votre §6POUVOIR");

            this.powerRunnable.start = true;
        }
        else
        {
            int remaining = 0;
            String format = "";

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

            this.p.sendMessage(Main.getInstance().getPrefix() + "§cVous devez encore attendre §6" + remaining + " §c" + format + " avant de réutiliser votre pouvoir");
        }
    }
}
