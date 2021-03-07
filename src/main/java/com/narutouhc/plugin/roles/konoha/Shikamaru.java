package com.narutouhc.plugin.roles.konoha;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;

public class Shikamaru extends Role
{
    private boolean available = true;

    public Shikamaru(Player player)
    {
        super(player);
        this.type = EnumRole.SHIKAMARU;
        Main.getInstance().konohas.add(player);

        if(Main.getInstance().roles.containsKey(p))
        {
            Main.getInstance().roles.remove(p);
        }

        Main.getInstance().roles.put(p, this);
    }

    public void freezePlayer(Player target)
    {
        if(this.available)
        {
            Location initial = target.getLocation().clone();

            new BukkitRunnable()
            {
                int timer = 30;

                @Override
                public void run()
                {
                    if(this.timer >= 1)
                    {
                        target.teleport(initial);
                        this.timer--;
                    }
                    else
                        this.cancel();
                }
            }.runTaskTimer(Main.getInstance(), 0, 1l);
            
            Player pl = this.p;
            
            pl.sendMessage(Main.getInstance().getPrefix() + "§cVous avez utilisé votre pouvoir, il sera rechargé dans §61 §cminute");
            
            new BukkitRunnable()
            {
                int timer = 60;

                @Override
                public void run()
                {
                    if(this.timer >= 1)
                    {
                        this.timer --;
                    }
                    else
                    {
                        pl.sendMessage(Main.getInstance().getPrefix() + "§aVotre pouvoir est §6prêt");
                        this.cancel();
                    }
                }
            }.runTaskTimer(Main.getInstance(), 0, 20l);
            
            this.available = true;
        }
    }
}
