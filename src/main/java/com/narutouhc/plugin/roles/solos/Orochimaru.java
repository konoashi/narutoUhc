package com.narutouhc.plugin.roles.solos;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;
import org.bukkit.entity.Player;

public class Orochimaru extends Role
{

	private boolean hasGot = false;

	private Player sasuke;

	public Orochimaru(Player player, boolean b)
	{
		super(player);
		this.type = EnumRole.OROCHIMARU;
		Main.getInstance().solos.add(player);
		this.p.setMaxHealth(15 * 2);
	}

	public Player getSasuke()
	{
		if(!hasGot){
			hasGot= true;
			for(Player p : Main.getInstance().getServer().getOnlinePlayers())
			{
				GamePlayer gp = GamePlayer.gamePlayers.get(p);

				if(gp.isSasuke()){
					sasuke = p;
				}
			}

		}

		return sasuke;
	}

	public void sasukeDie() {
		this.p.setMaxHealth(8 * 2);
	}
}
