package com.narutouhc.plugin.roles.konoha;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Choji extends Role
{
    private boolean used = false;

    public Choji(Player player)
    {
        super(player);
        this.type = EnumRole.CHOJI;
        Main.getInstance().konohas.add(player);

        if(Main.getInstance().roles.containsKey(p))
        {
            Main.getInstance().roles.remove(p);
        }

        Main.getInstance().roles.put(p, this);
    }

    public void openGui()
    {
        Inventory inv = Bukkit.createInventory(null, Main.getInstance().getServer().getMaxPlayers() > 9 ? 18 : 9, "Super pouvoir");

        for(Player p : Main.getInstance().getServer().getOnlinePlayers())
        {
            if(p.getGameMode() == GameMode.SURVIVAL)
            {
                ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
                SkullMeta skull = (SkullMeta)item.getItemMeta();
                skull.setOwner(p.getName());
                skull.setDisplayName("§6" + p.getName());
                item.setItemMeta(skull);

                inv.addItem(item);
            }
        }

        this.p.openInventory(inv);
    }

    @Override
    public void useAbility()
    {
        if(!this.isUsed())
        {
            this.openGui();
        }
        else
        {
            this.p.sendMessage(Main.getInstance().getPrefix() + "§cVous avez déjà utilisé votre pouvoir");
        }
    }

    public void damagePlayer(Player pl)
    {

        pl.damage(pl.getMaxHealth() / 2);

        pl.sendMessage(Main.getInstance().getPrefix() + "§cChôji vient d'abattre sa rage sur vous !");

        this.used = true;

        this.p.sendMessage(Main.getInstance().getPrefix() + "§cVous venez d'utiliser votre pouvoir sur §6" + pl.getDisplayName());
    }

    public boolean isUsed()
    {
        return this.used;
    }
}