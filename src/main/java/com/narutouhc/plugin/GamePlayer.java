package com.narutouhc.plugin;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;

public class GamePlayer
{
    // Joueur
    private Player p;
    // Roles
    private EnumRole role = EnumRole.NONE;
    private Role power;
    public static Map<Player, GamePlayer> gamePlayers = new HashMap<Player, GamePlayer>();

    public GamePlayer(Player player)
    {
        this.p = player;
        gamePlayers.put(this.p, this);
    }

    /* Conditions publiques permettant de déterminer le rôle du joueur */

    public boolean isRole(EnumRole roleIn)
    {
        return this.role == roleIn;
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

    public void setPower(Role r)
    {
        this.power = r;
    }

    public EnumRole getRole()
    {
        return this.role;
    }

    public Role getPower()
    {
        return this.power;
    }
}
