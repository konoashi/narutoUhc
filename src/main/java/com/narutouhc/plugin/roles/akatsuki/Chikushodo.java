package com.narutouhc.plugin.roles.akatsuki;

import org.bukkit.entity.Player;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;

public class Chikushodo extends Role
{
    private boolean ticks;

    public Chikushodo(Player player)
    {
        super(player);
        this.type = EnumRole.CHIKUSHODO;
        this.ticks = false;
        this.setDefaultCooldown(20 * 60);
        this.setCurrentCooldown(30 * 60);
        Main.getInstance().akatsukis.add(player);

        this.isPainBody = true;
        
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
            Main.getInstance().pluginRunnable.tpPlayer(this.p, 150);

            for(Player pl : Main.getInstance().akatsukis)
            {
                if(pl != this.p)
                {
                    GamePlayer gp = GamePlayer.gamePlayers.get(pl);

                    if(gp.getPower().isPainBody)
                    {
                        pl.teleport(this.p.getLocation().clone());
                        pl.sendMessage(Main.getInstance().getPrefix() + "§6CHIKUSHODO §avous a téléporté !");
                    }
                }
            }

            this.resetCurrentCooldown();
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
}
