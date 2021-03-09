package com.narutouhc.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.utils.RolesUtils;

public class CommandEpisode implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(args.length == 1)
        {
            if(Main.getInstance().pluginRunnable.started)
            {
                int ep = Integer.parseInt(args[0]);

                Bukkit.broadcastMessage("\n====================\n§bDébut de l'épisode §6" + ep + "\n§f====================");

                Main.getInstance().pluginRunnable.gameTimer = 20 * 60;
                Main.getInstance().pluginRunnable.mainTimer = (ep - 1) * 20 * 60;

                if(Main.getInstance().pluginRunnable.ep < 2 && ep >= 2)
                {
                    RolesUtils.setRoles();
                    for(Player p : Bukkit.getOnlinePlayers())
                    {
                        p.sendMessage("\n" + Main.getInstance().getPrefix() + "§9Le PvP est maintenant activé");
                        p.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 10f, 1f);
                        p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 5));
                    }

                    Bukkit.broadcastMessage("\n" + Main.getInstance().getPrefix() + "§cVous êtes devenu vulnérable aux dégats");

                }

                if(ep == 4)
                {
                    Bukkit.getWorld("world").getWorldBorder().setSize(500, 60 * 2);
                }

                if(ep == 7)
                {
                    Bukkit.getWorld("world").getWorldBorder().setSize(300, 60 * 2);
                }

                if(ep == 10)
                {
                    Bukkit.getWorld("world").getWorldBorder().setSize(150, 60 * 2);
                }

                for(Player p : Bukkit.getOnlinePlayers())
                {
                    p.playSound(p.getLocation(), Sound.ORB_PICKUP, 10f, 1f);
                }

                Main.getInstance().pluginRunnable.ep = ep;
            }
        }

        return false;
    }
}
