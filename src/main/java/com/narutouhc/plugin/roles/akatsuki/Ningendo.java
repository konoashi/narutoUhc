package com.narutouhc.plugin.roles.akatsuki;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;

public class Ningendo extends Role
{
    public int times = 0;

    public Ningendo(Player player)
    {
        super(player);
        this.type = EnumRole.NINGENDO;
        Main.getInstance().akatsukis.add(player);

        this.setDefaultCooldown(20 * 60);

        this.isPainBody = true;

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
        if(this.times < 2)
        {
            if(this.isAvailable())
            {
                Inventory inv = Bukkit.createInventory(null, Main.getInstance().getServer().getMaxPlayers() > 9 ? 18 : Main.getInstance().getServer().getMaxPlayers() > 18 ? 27 : 9, "Super pouvoir");

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
            else
            {
                int remaining = 0;
                String format = "";

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

                this.p.sendMessage(Main.getInstance().getPrefix() + "§cVous devez encore attendre §6" + remaining + " §c" + format + " avant de réutiliser votre pouvoir");
            }
        }
        else
        {
            this.p.sendMessage(Main.getInstance().getPrefix() + "§cVous avez déjà utilisé votre pouvoir");
        }
    }
}
