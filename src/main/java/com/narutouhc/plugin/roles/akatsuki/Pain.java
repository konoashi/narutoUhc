package com.narutouhc.plugin.roles.akatsuki;

import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;

public class Pain extends Role
{
	private final boolean ticks;

	public Pain(Player player)
	{
		super(player);
		this.type = EnumRole.PAIN;
		this.ticks = false;
		this.setDefaultCooldown(2 * 60);
		Main.getInstance().akatsukis.add(player);
		
        if(Main.getInstance().roles.containsKey(p))
        {
            Main.getInstance().roles.remove(p);
        }
        
        this.p.setMaxHealth(20 + 6);
        
        Main.getInstance().roles.put(p, this);
	}

	@Override
	public void useAbility()
	{
		if (this.isAvailable())
		{
			for (Entity e : this.p.getNearbyEntities(20, 20, 20))
			{
				if (e instanceof Player)
				{
					Player pl = (Player) e;

					pl.setVelocity(this.p.getLocation().toVector().subtract(pl.getLocation().toVector()).multiply(0.3));
				}
			}

			this.setCurrentCooldown(this.getDefaultCooldown());
			this.p.setMaxHealth(this.p.getMaxHealth() - 2);
			
			if(this.p.getHealth() > this.p.getMaxHealth())
			{
			    this.p.setHealth(this.p.getMaxHealth());
			}
			
			this.p.sendMessage(Main.getInstance().getPrefix() + "§aVous venez d'utiliser votre §6POUVOIR");

			if (ticks)
			{
				this.getPowerRunnable().runTaskTimer(Main.getInstance(), 0, 1L);
			} else
			{
				this.getPowerRunnable().runTaskTimer(Main.getInstance(), 0, 20L);
			}
		} else
		{
			int remaining = 0;
			String format = "";

			if (this.ticks)
			{
				remaining = this.getCurrentCooldown() / 20;

				if (remaining > 1)
					format = "secondes";
				else
					format = "seconde";

				if (remaining >= 60)
				{
					remaining /= 60;

					if (remaining > 1)
						format = "minutes";
					else
						format = "minute";
				}
			} else
			{
				remaining = this.getCurrentCooldown();

				if (remaining > 1)
					format = "secondes";
				else
					format = "seconde";

				if (remaining >= 60)
				{
					remaining /= 60;

					if (remaining > 1)
						format = "minutes";
					else
						format = "minute";
				}
			}

			this.p.sendMessage(Main.getInstance().getPrefix() + "§cVous devez encore attendre §6" + remaining + " §c" + format + " avant de réutiliser votre pouvoir");
		}
	}

	public List<Player> getMates()
	{
		return Main.getInstance().akatsukis;
	}
}
