package com.narutouhc.plugin;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

public class GamePlayer
{
    // Joueur
    private Player p;
    // Roles
    private boolean naruto = false, sakura = false, shikamaru = false, choji = false, minato = false, sasuke = false, orochimaru = false, kakuzu = false, itachi = false, deidara = false, pain;

    public static Map<Player, GamePlayer> gamePlayers = new HashMap<Player, GamePlayer>();

    public GamePlayer(Player player)
    {
        this.p = player;
        gamePlayers.put(this.p, this);
    }

    /* Conditions publiques permettant de déterminer le rôle du joueur */

    public boolean isNaruto()
    {
        return this.naruto;
    }

    public boolean iSakura()
    {
        return this.sakura;
    }

    public boolean isShikamaru()
    {
        return this.shikamaru;
    }

    public boolean isChoji()
    {
        return this.choji;
    }

    public boolean isMinato()
    {
        return this.minato;
    }

    public boolean isSasuke()
    {
        return this.sasuke;
    }

    public boolean isOrochimaru()
    {
        return this.orochimaru;
    }

    public boolean isKakuzu()
    {
        return this.kakuzu;
    }

    public boolean isItachi()
    {
        return this.itachi;
    }

    public boolean isDeidara()
    {
        return this.deidara;
    }

    public boolean isPain()
    {
        return this.pain;
    }

    /* Conditions publiques permettant de préciser le rôle du joueur */
    
    public void resetRoles()
    {
        this.naruto = false;
        this.sakura = false;
        this.shikamaru = false;
        this.choji = false;
        this.minato = false;
        this.sasuke = false;
        this.orochimaru = false;
        this.kakuzu = false;
        this.itachi = false;
        this.deidara = false;
        this.pain = false;
    }

    public void setNaruto()
    {
        this.resetRoles();
        this.naruto = true;
    }

    public void setSakura()
    {
        this.resetRoles();
        this.sakura = true;
    }

    public void setShikamaru()
    {
        this.resetRoles();
        this.shikamaru = true;
    }

    public void setChoji()
    {
        this.resetRoles();
        this.choji = true;
    }
    
    public void setMinato()
    {
        this.resetRoles();
        this.minato = true;
    }
    
    public void setSasuke()
    {
        this.resetRoles();
        this.choji = true;
    }
    
    public void setOrochimaru()
    {
        this.resetRoles();
        this.orochimaru = true;
    }
    
    public void setKakuzu()
    {
        this.resetRoles();
        this.kakuzu = true;
    }
    
    public void setItachi()
    {
        this.resetRoles();
        this.choji = true;
    }
    
    public void setDeidara()
    {
        this.resetRoles();
        this.deidara = true;
    }
    
    public void setSpain()
    {
        this.resetRoles();
        this.pain = true;
    }
}
