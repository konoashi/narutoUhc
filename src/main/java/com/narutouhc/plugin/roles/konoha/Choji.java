package com.narutouhc.plugin.roles.konoha;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class Choji extends Role
{
    private boolean used = false;

    public Choji(Player player)
    {
        super(player);
        this.type = EnumRole.CHOJI;
        Main.getInstance().konohas.add(player);
    }

    @SuppressWarnings("unlikely-arg-type")
    @Override
    public void useAbility()
    {
        this.used = true;

        Inventory inv = Bukkit.createInventory(null, Main.getInstance().getServer().getMaxPlayers() > 9 ? 18 : 9, "Super pouvoir");

        for(Player p : Main.getInstance().getServer().getOnlinePlayers())
        {
            ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
            SkullMeta skull = (SkullMeta)item.getItemMeta();
            skull.setOwner(p.getName());
            skull.setDisplayName("§6" + p.getName());
            item.setItemMeta(skull);

            inv.setItem(Arrays.asList(Main.getInstance().getServer().getOnlinePlayers()).indexOf(p), item);
        }

    }

    public boolean isUsed()
    {
        return used;
    }
}