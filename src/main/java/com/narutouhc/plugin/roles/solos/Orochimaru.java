package com.narutouhc.plugin.roles.solos;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;
import org.bukkit.entity.Player;

public class Orochimaru extends Role
{
    private Player sasuke;

    public Orochimaru(Player player, boolean b)
    {
        super(player);
        this.type = EnumRole.OROCHIMARU;
        Main.getInstance().solos.add(player);
        this.p.setMaxHealth(20 + 10);
    }

    public Player getSasuke()
    {
        // SI ON A PAS ENCORE GET SASUKE
        if(this.sasuke == null)
        {
            // ON GET TOUT LES JOUEURS
            for(Player pl : Main.getInstance().getServer().getOnlinePlayers())
            {
                GamePlayer gp = GamePlayer.gamePlayers.get(pl);

                if(gp.isSasuke())
                {
                    // ON SET LA VARIABLE LOCALE
                    this.sasuke = pl;
                }
            }

        }
        
        // ON RENVOIE LE RESULTAT
        return this.sasuke;
    }

    public void sasukeDie()
    {
        this.p.setMaxHealth(8 * 2);
    }
}
