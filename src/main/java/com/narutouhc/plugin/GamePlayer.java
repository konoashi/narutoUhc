package com.narutouhc.plugin;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

import com.narutouhc.plugin.roles.EnumRole;

public class GamePlayer
{
    // Joueur
    private Player p;
    // Roles
    private EnumRole role = EnumRole.NONE;
    
    public static Map<Player, GamePlayer> gamePlayers = new HashMap<Player, GamePlayer>();
    
    public GamePlayer(Player player)
    {
        this.p = player;
        gamePlayers.put(this.p, this);
    }

    /* Conditions publiques permettant de déterminer le rôle du joueur */

    public boolean isNaruto()
    {
        return this.role == EnumRole.NARUTO;
    }

    public boolean iSakura()
    {
        return this.role == EnumRole.SAKURA;
    }

    public boolean isShikamaru()
    {
        return this.role == EnumRole.SHIKAMARU;
    }

    public boolean isChoji()
    {
        return this.role == EnumRole.CHOJI;
    }

    public boolean isMinato()
    {
        return this.role == EnumRole.MINATO;
    }

    public boolean isSasuke()
    {
        return this.role == EnumRole.SASUKE;
    }

    public boolean isOrochimaru()
    {
        return this.role == EnumRole.OROCHIMARU;
    }

    public boolean isKakuzu()
    {
        return this.role == EnumRole.KAKUZU;
    }

    public boolean isItachi()
    {
        return this.role == EnumRole.ITACHI;
    }

    public boolean isDeidara()
    {
        return this.role == EnumRole.DEIDARA;
    }

    public boolean isPain()
    {
        return this.role == EnumRole.PAIN;
    }

    /* Conditions publiques permettant de préciser le rôle du joueur */
    
    public void resetRoles()
    {
        this.role = EnumRole.NONE;
    }

    public void setRole(EnumRole role)
    {
        this.role = role;
    }
    
    public EnumRole getRole()
    {
        return this.role;
    }
}
