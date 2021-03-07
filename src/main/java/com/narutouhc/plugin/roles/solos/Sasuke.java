package com.narutouhc.plugin.roles.solos;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Sasuke extends Role
{
    private boolean ticks;

    private Player orochimaru;

    public Sasuke(Player player, boolean b)
    {
        super(player);
        this.type = EnumRole.SASUKE;
        Main.getInstance().solos.add(player);
        this.setDefaultCooldown(2 * 60);
        this.ticks = false;
        this.p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 30, 1, true, false));
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

    public Player getOrochimaru()
    {
        // SI ON A PAS ENCORE GET OROCHIMARU
        if(this.orochimaru == null)
        {
            // GET TOUT LES JOUEURS
            for(Player pl : Main.getInstance().getServer().getOnlinePlayers())
            {
                GamePlayer gp = GamePlayer.gamePlayers.get(pl);

                if(gp.isOrochimaru())
                {
                    // SET LA VARIABLE LOCALE
                    this.orochimaru = pl;
                }
            }

        }

        // ENVOIS LE RESULTAT
        return this.orochimaru;
    }

    public void orochimaruDie()
    {
        this.p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20 * 30, 1, true, false));
    }
}
