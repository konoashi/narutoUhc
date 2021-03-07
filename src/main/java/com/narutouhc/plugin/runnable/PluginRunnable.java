package com.narutouhc.plugin.runnable;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.utils.GameStatus;
import com.narutouhc.plugin.utils.RolesUtils;

public class PluginRunnable extends BukkitRunnable
{
    public int startTimer = 16;
    public int gameTimer = 20 * 60;
    public boolean starting = false;
    public boolean started = false;
    public int ep = 1;
    
    @Override
    public void run()
    {
        if(GameStatus.isStatus(GameStatus.WAITING) && this.starting)
        {
            if(this.startTimer >= 1)
            {
                startTimer--;
                setLevel();

                if(this.shouldBcStart())
                {
                    String format = " secondes";

                    if(this.startTimer == 1)
                    {
                        format = " seconde";
                    }

                    Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§eDébut de la partie dans §6" + this.startTimer + format);

                    for(Player p : Bukkit.getOnlinePlayers())
                    {
                        p.playSound(p.getLocation(), Sound.ORB_PICKUP, 10f, 1f);
                    }
                }
            }
            else
            {
                GameStatus.setSatus(GameStatus.GAME);
                Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§6La partie commence");
                Bukkit.getWorld("world").setTime(0);

                Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§2Vous êtes invincible pour 30s");
                Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§9Début du PvP à l'épisode 2");

                for(Player p : Bukkit.getOnlinePlayers())
                {
                    p.getInventory().clear();
                }

                this.started = true;
                this.starting = false;
            }
        }
        else if(GameStatus.isStatus(GameStatus.GAME) && !starting)
        {
            if(this.ep == 1 && this.gameTimer == (20 * 60) - 30)
            {
                Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§cVous êtes devenu vulnérable aux dégats");
            }
            
            if(this.gameTimer >= 1)
            {
                this.gameTimer --;
            }
            else
            {
                this.gameTimer = 20 * 60;
                this.ep ++;
                
                if(this.ep == 2)
                {
                    RolesUtils.setRoles();
                    
                    for(Player p : Bukkit.getOnlinePlayers())
                    {
                        p.sendMessage(Main.getInstance().getPrefix() + "§9Le PvP est maintenant activé");
                        p.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 10f, 1f);
                        p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 5));
                    }
                }
            }
        }
    }

    private void setLevel()
    {
        for(Player p : Bukkit.getOnlinePlayers())
        {
            p.setLevel(startTimer);
        }
    }

    private boolean shouldBcStart()
    {
        return this.startTimer == 15 || this.startTimer == 10 || this.startTimer <= 5 && this.startTimer != 0;
    }
}
