package com.narutouhc.plugin.listeners.throwable;

import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import com.narutouhc.plugin.GamePlayer;

public class ThrowableHitListener implements Listener
{
	@EventHandler
	public void onEntityHit(ProjectileHitEvent e)
	{
		if(e.getEntity() instanceof Egg)
		{
			Egg egg = (Egg)e.getEntity();

			if(egg.getShooter() instanceof Player)
			{
				Player p = (Player)egg.getShooter();

				GamePlayer gp = GamePlayer.gamePlayers.get(p);

				if(gp.isDeidara())
				{
					if(egg.getCustomName().equalsIgnoreCase("§cOeuf explosif"))
					{
						egg.getWorld().createExplosion(egg.getLocation(), 1);
					}
				}
			}
		}
	}
}