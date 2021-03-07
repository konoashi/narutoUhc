package com.narutouhc.plugin.roles.akatsuki;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;

public class Kakuzu extends Role
{
    public boolean hasRespawned = false;
    public ItemStack[] respawnInv;
    
    public Kakuzu(Player player)
    {
        super(player);
        this.type = EnumRole.KAKUZU;
        this.p.setMaxHealth(20 + 4);
        this.p.setHealth(20 + 4);
        Main.getInstance().akatsukis.add(player);
        
        if(Main.getInstance().roles.containsKey(p))
        {
            Main.getInstance().roles.remove(p);
        }
        
        Main.getInstance().roles.put(p, this);
    }

    @Override
    public void useAbility()
    {
        this.hasRespawned = true;
        this.p.setMaxHealth(20 - 4);
        this.p.sendMessage(Main.getInstance().getPrefix() + "§aVous venez de §cRessuciter !");
    }
}
