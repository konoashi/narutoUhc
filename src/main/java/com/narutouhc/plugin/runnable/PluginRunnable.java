package com.narutouhc.plugin.runnable;

import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.solos.Sasuke;
import com.narutouhc.plugin.scoreboard.ScoreboardManager;
import com.narutouhc.plugin.utils.GameStatus;
import com.narutouhc.plugin.utils.RolesUtils;

public class PluginRunnable extends BukkitRunnable
{
    public int startTimer = 16;
    public int gameTimer = 20 * 60;
    public boolean starting = false;
    public boolean started = false;
    public int ep = 1;
    public int mainTimer = 0;

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

                Bukkit.broadcastMessage("\n" + Main.getInstance().getPrefix() + "§2Vous êtes invincible pour 30s");
                Bukkit.broadcastMessage(Main.getInstance().getPrefix() + "§9Début du PvP à l'épisode 2");

                for(Player p : Bukkit.getOnlinePlayers())
                {
                    p.getInventory().clear();
                    p.getActivePotionEffects().clear();
                    
                    ItemStack star = new ItemStack(Material.NETHER_STAR);
                    ItemMeta metaStar = star.getItemMeta();
                    metaStar.setDisplayName("§6Pouvoir");
                    star.setItemMeta(metaStar);
                    
                    p.getInventory().addItem(star);
                    
                    if(!ScoreboardManager.scoreboardGame.containsKey(p))
                    {
                        new ScoreboardManager(p);
                    }
                }

                this.started = true;
                this.starting = false;
            }
        }
        else if(GameStatus.isStatus(GameStatus.GAME) && !starting)
        {
            mainTimer ++;
            
            if(this.ep == 1 && this.gameTimer == (20 * 60) - 30)
            {
                Bukkit.broadcastMessage("\n" + Main.getInstance().getPrefix() + "§cVous êtes devenu vulnérable aux dégats");
            }

            if(ep >= 2)
            {
                for(Player p : Bukkit.getOnlinePlayers())
                {
                    addEffects(p);
                }
            }

            if(this.gameTimer >= 1)
            {
                this.gameTimer--;
            }
            else
            {
                this.gameTimer = 20 * 60;
                this.ep++;

                Bukkit.broadcastMessage("\n====================\n§bDébut de l'épisode §6" + this.ep + "\n§f====================");
                
                if(this.ep == 2)
                {
                    RolesUtils.setRoles();

                    for(Player p : Bukkit.getOnlinePlayers())
                    {
                        p.sendMessage("\n" + Main.getInstance().getPrefix() + "§9Le PvP est maintenant activé");
                        p.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 10f, 1f);
                        p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 5));
                    }
                }
                
                if(this.ep == 4)
                {
                    Bukkit.getWorld("world").getWorldBorder().setSize(500, 60 * 2);
                }

                if(this.ep == 7)
                {
                    Bukkit.getWorld("world").getWorldBorder().setSize(300, 60 * 2);
                }
                
                if(this.ep == 10)
                {
                    Bukkit.getWorld("world").getWorldBorder().setSize(150, 60 * 2);
                }
                
                for(Player p : Bukkit.getOnlinePlayers())
                {
                    p.playSound(p.getLocation(), Sound.ORB_PICKUP, 10f, 1f);
                }
            }
            
            for(Player p : Bukkit.getOnlinePlayers())
            {
                ScoreboardManager.scoreboardGame.get(p).update();
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

    private void addEffects(Player p)
    {
        GamePlayer gp = GamePlayer.gamePlayers.get(p);

        if(gp.isNaruto())
        {
            if(!p.hasPotionEffect(PotionEffectType.SPEED))
            {
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0, true, false));
            }
        }
        else if(gp.isMinato())
        {
            if(!p.hasPotionEffect(PotionEffectType.SPEED))
            {
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, true, false));
            }
        }
        else if(gp.isSasuke())
        {
            if(!p.hasPotionEffect(PotionEffectType.SPEED))
            {
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0, true, false));
            }

            if(((Sasuke)gp.getPower()).hasWeakness)
            {
                if(!p.hasPotionEffect(PotionEffectType.WEAKNESS))
                {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, Integer.MAX_VALUE, 0, true, false));
                }
            }
        }
        else if(gp.isItachi())
        {
            if(!p.hasPotionEffect(PotionEffectType.SPEED))
            {
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, true, false));
            }
        }
    }
    
    public String getFormattedTime()
    {
        String s = String.format("%02d:%02d:%02d",
                TimeUnit.SECONDS.toHours(this.mainTimer),
                TimeUnit.SECONDS.toMinutes(this.mainTimer) - 
                TimeUnit.HOURS.toMinutes(TimeUnit.SECONDS.toHours(this.mainTimer)),
                this.mainTimer - 
                TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(this.mainTimer)));
        
        String[] args = s.split(":");
        
        int hours = Integer.parseInt(args[0]);

        if(hours != 0)
        { 
            return s;
        }
        else
        {
            return s.substring(3);
        }
    }
}
