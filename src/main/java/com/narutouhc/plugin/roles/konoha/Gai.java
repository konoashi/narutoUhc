package com.narutouhc.plugin.roles.konoha;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;
import com.narutouhc.plugin.runnable.GaiRunnable;

public class Gai extends Role
{
    public int state = 0;
    private boolean ticks = false;
    private GaiRunnable gaiRunnable;

    public Gai(Player player)
    {
        super(player);
        this.type = EnumRole.GAI;
        Main.getInstance().konohas.add(player);

        if(Main.getInstance().roles.containsKey(p))
        {
            Main.getInstance().roles.remove(p);
        }

        this.gaiRunnable = new GaiRunnable(this);

        this.setDefaultCooldown(20);
        Main.getInstance().roles.put(p, this);
        
        this.powerRunnable.runTaskTimer(Main.getInstance(), 0, 20);
    }

    @Override
    public void useAbility()
    {
        if(this.isAvailable())
        {
            if(this.state < 8)
            {
                this.state++;

                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "effect " + this.p.getName() + " clear");

                if(this.state == 1)
                {
                    this.setMaxHealth(18);
                }
                else if(this.state == 2)
                {
                    this.setMaxHealth(17);
                }
                else if(this.state == 3)
                {
                    this.setMaxHealth(16);
                }
                else if(this.state == 4)
                {
                    this.setMaxHealth(15);
                }
                else if(this.state == 5)
                {
                    this.setMaxHealth(14);
                }
                else if(this.state == 6)
                {
                    this.setMaxHealth(12);
                }
                else if(this.state == 7)
                {
                    this.setMaxHealth(10);
                }
                else if(this.state == 8)
                {
                    this.setMaxHealth(8);
                    this.gaiRunnable.runTaskTimer(Main.getInstance(), 0, 20);
                }

                this.p.sendMessage(Main.getInstance().getPrefix() + "§cVous avez ouvert la §6" + this.state + "ème §cporte");

                if(this.state == 8)
                {
                    this.p.sendMessage(Main.getInstance().getPrefix() + "§cVous mourrez dans §61 minute");
                }

                this.resetCurrentCooldown();

                this.getPowerRunnable().start = true;
            }
            else
            {
                this.p.sendMessage(Main.getInstance().getPrefix() + "§cVous avez déjà utilisé vos verrous psychiques");
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

    private void setMaxHealth(int health)
    {
        this.p.setMaxHealth(health);

        if(this.p.getHealth() > this.p.getMaxHealth())
        {
            this.p.setHealth(health);
        }
    }
}