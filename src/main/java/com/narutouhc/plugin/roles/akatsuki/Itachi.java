package com.narutouhc.plugin.roles.akatsuki;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;

public class Itachi extends Role
{
	private boolean ticks;

	public Itachi(Player player)
	{
		super(player);
		this.ticks = false;
		this.type = EnumRole.ITACHI;
		this.setDefaultCooldown(7 * 60);
		Main.getInstance().akatsukis.add(player);
		
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
			for(Entity e : this.p.getNearbyEntities(15, 15, 15))
			{
				if(e instanceof Player)
				{
					Player pl = (Player)e;

					if(!Main.getInstance().akatsukis.contains(pl))
					{
						// MET EN FEU LE JOUEURS PD 5s
						pl.setFireTicks(20 * 5);
					}

				}
			}

			this.setCurrentCooldown(this.getDefaultCooldown());

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
	
	public void addLifeAbility()
	{
	    Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
	    Objective o = sb.registerNewObjective("§6❤§r", "health");
	    o.setDisplaySlot(DisplaySlot.BELOW_NAME);
	    this.p.setScoreboard(sb);
	}
}
