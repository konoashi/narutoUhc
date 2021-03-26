package com.narutouhc.plugin.runnable;

import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.konoha.Jiraya;

public class JirayaRunnable extends BukkitRunnable
{
    private Jiraya role;
    
    public JirayaRunnable(Jiraya r)
    {
        this.role = r;
    }

    @Override
    public void run()
    {
        if(this.role.p.getGameMode() == GameMode.SURVIVAL)
        {
            boolean isNear = false;
            
            for(Entity e : this.role.p.getNearbyEntities(10, 10, 10))
            {
                if(e instanceof Player)
                {
                    Player p = (Player)e;
                    
                    GamePlayer gp = GamePlayer.gamePlayers.get(p);
                    
                    if(gp.isRole(EnumRole.NARUTO))
                    {
                        isNear = true;
                    }
                }
            }
            
            this.role.isNearNaruto = isNear;
        }
    }

}
