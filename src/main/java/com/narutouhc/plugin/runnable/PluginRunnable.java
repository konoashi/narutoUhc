package com.narutouhc.plugin.runnable;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.konoha.Gai;
import com.narutouhc.plugin.roles.konoha.Jiraya;
import com.narutouhc.plugin.roles.solos.Orochimaru;
import com.narutouhc.plugin.roles.solos.Sasuke;
import com.narutouhc.plugin.scoreboard.ScoreboardManager;
import com.narutouhc.plugin.utils.GameStatus;
import com.narutouhc.plugin.utils.RolesUtils;
import com.narutouhc.plugin.utils.StuffUtil;

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
                    if(!Main.getInstance().getConfig().getBoolean("whitelist"))
                    {
                        if(!Main.getInstance().spectating.contains(p))
                        {
                            StuffUtil.setInv(p);
                            tpPlayer(p, 370);
                            Main.getInstance().players.add(p);
                        }
                    }
                    else
                    {
                        if(!Main.getInstance().spectating.contains(p) && Main.getInstance().whitelist.contains(p))
                        {
                            StuffUtil.setInv(p);
                            tpPlayer(p, 370);
                            Main.getInstance().players.add(p);
                        }
                        else
                            p.setGameMode(GameMode.SPECTATOR);
                    }

                    if(!ScoreboardManager.scoreboardGame.containsKey(p))
                    {
                        new ScoreboardManager(p);
                    }
                }

                this.started = true;
                this.starting = false;
            }
        }
        else if(GameStatus.isStatus(GameStatus.GAME) && !this.starting)
        {
            this.mainTimer++;

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
                    Bukkit.getWorld("world").getWorldBorder().setSize(500 * 2, 60 * 2);
                }

                if(this.ep == 7)
                {
                    Bukkit.getWorld("world").getWorldBorder().setSize(300 * 2, 60 * 2);
                }

                if(this.ep == 10)
                {
                    Bukkit.getWorld("world").getWorldBorder().setSize(150 * 2, 60 * 2);
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
        else if(GameStatus.isStatus(GameStatus.STOP))
        {
            Firework firework = Bukkit.getWorld("world_the_end").spawn(new Location(Bukkit.getWorld("world"), 0, 80, 0), Firework.class);
            FireworkMeta data = (FireworkMeta)firework.getFireworkMeta();
            data.addEffects(FireworkEffect.builder().withColor(Color.PURPLE).withColor(Color.WHITE).with(Type.STAR).withFlicker().build());
            data.setPower(1);
            firework.setFireworkMeta(data);
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

        if(gp.isRole(EnumRole.NARUTO))
        {
            if(!p.hasPotionEffect(PotionEffectType.SPEED))
            {
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0, false, false));
            }
        }
        else if(gp.isRole(EnumRole.MINATO))
        {
            if(!p.hasPotionEffect(PotionEffectType.SPEED))
            {
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, false, false));
            }
        }
        else if(gp.isRole(EnumRole.SASUKE))
        {
            if(!p.hasPotionEffect(PotionEffectType.SPEED))
            {
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0, false, false));
            }

            if(!((Sasuke)gp.getPower()).hasWeakness && !p.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE))
            {
                p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0, false, false));
            }
            
            if(((Sasuke)gp.getPower()).hasWeakness)
            {
                if(!p.hasPotionEffect(PotionEffectType.WEAKNESS))
                {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, Integer.MAX_VALUE, 0, false, false));
                }
            }
        }
        else if(gp.isRole(EnumRole.ITACHI))
        {
            if(!p.hasPotionEffect(PotionEffectType.SPEED))
            {
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, false, false));
            }
        }
        else if(gp.isRole(EnumRole.OROCHIMARU))
        {
            Orochimaru orochimaru = (Orochimaru)gp.getPower();
            
            if(orochimaru.isSasukeDead && !p.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE))
            {
                p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1, false, false));
            }
        }
        else if(gp.isRole(EnumRole.GAI))
        {
            Gai gai = (Gai)gp.getPower();

            if(gai.state == 1)
            {
                if(!p.hasPotionEffect(PotionEffectType.SPEED))
                {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0, false, false));
                }
            }
            if(gai.state >= 2 && gai.state < 6)
            {
                if(!p.hasPotionEffect(PotionEffectType.SPEED))
                {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, false, false));
                }
            }
            if(gai.state >= 3 && gai.state < 8)
            {
                if(!p.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE))
                {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0, false, false));
                }
            }
            if(gai.state == 4)
            {
                if(!p.hasPotionEffect(PotionEffectType.JUMP))
                {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 0, false, false));
                }
            }
            if(gai.state >= 5)
            {
                if(!p.hasPotionEffect(PotionEffectType.JUMP))
                {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 1, false, false));
                }
            }
            if(gai.state >= 6)
            {
                if(!p.hasPotionEffect(PotionEffectType.SPEED))
                {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2, false, false));
                }
            }
            if(gai.state >= 7)
            {
                if(!p.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE))
                {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 0, false, false));
                }
            }
            if(gai.state >= 8)
            {
                if(!p.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE))
                {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1, false, false));
                }
            }
        }
        else if(gp.isRole(EnumRole.JIRAYA))
        {
            if(!p.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE))
            {
                p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 0, false, false));
            }
            if(!p.hasPotionEffect(PotionEffectType.SPEED))
            {
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0, false, false));
            }
            
            Jiraya jiraya = (Jiraya)gp.getPower();
            
            if(jiraya.isNearNaruto && !p.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE))
            {
                p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 5 * 20, 0, false, false));
            }
        }
    }

    public String getFormattedTime()
    {
        String s = String.format("%02d:%02d:%02d", TimeUnit.SECONDS.toHours(this.mainTimer), TimeUnit.SECONDS.toMinutes(this.mainTimer) - TimeUnit.HOURS.toMinutes(TimeUnit.SECONDS.toHours(this.mainTimer)), this.mainTimer - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(this.mainTimer)));

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

    public void tpPlayer(Player p, int bound)
    {
        p.setGameMode(GameMode.SURVIVAL);

        Random r = new Random();

        int x = r.nextInt(bound) + 1;
        int y = 150;
        int z = r.nextInt(bound) + 1;

        if(r.nextInt(2) == 0)
        {
            x -= x * 2;
        }
        
        if(r.nextInt(2) == 1)
        {
            z -= z * 2;
        }
        
        Location loc = new Location(Main.getInstance().getServer().getWorlds().get(0), x, y, z);

        Block block = loc.getWorld().getBlockAt(loc);

        if(block.getType() != null && block.getType().equals(Material.AIR))
        {
            p.teleport(loc);
        }
        else
        {
            tpPlayer(p, bound);
        }

    }
}
