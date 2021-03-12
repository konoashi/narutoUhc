package com.narutouhc.plugin.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.narutouhc.plugin.Main;

public class StuffUtil
{
    public static void setDefautltUhcStuff()
    {
        Main.getInstance().startInv.clear();

        ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta metaHelmet = helmet.getItemMeta();
        metaHelmet.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        helmet.setItemMeta(metaHelmet);
        Main.getInstance().startInv.put(helmet, 27);

        ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta metaChestplate = chestplate.getItemMeta();
        metaChestplate.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        chestplate.setItemMeta(metaChestplate);
        Main.getInstance().startInv.put(chestplate, 28);

        ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta metaLeggings = leggings.getItemMeta();
        metaLeggings.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
        leggings.setItemMeta(metaLeggings);
        Main.getInstance().startInv.put(leggings, 29);

        ItemStack boots = new ItemStack(Material.IRON_BOOTS);
        ItemMeta metaBoots = boots.getItemMeta();
        metaBoots.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
        boots.setItemMeta(metaBoots);
        Main.getInstance().startInv.put(boots, 30);

        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta metaSword = sword.getItemMeta();
        metaSword.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
        sword.setItemMeta(metaSword);
        Main.getInstance().startInv.put(sword, 0);

        ItemStack gapples = new ItemStack(Material.GOLDEN_APPLE, 14);
        gapples.getItemMeta().setDisplayName("§6§oGolden Apple");
        Main.getInstance().startInv.put(gapples, 1);

        ItemStack water = new ItemStack(Material.WATER_BUCKET);
        Main.getInstance().startInv.put(water, 2);

        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta metaBow = bow.getItemMeta();
        metaBow.addEnchant(Enchantment.ARROW_DAMAGE, 3, true);
        bow.setItemMeta(metaBow);
        Main.getInstance().startInv.put(bow, 3);

        ItemStack blocks1 = new ItemStack(Material.COBBLESTONE, 64);
        ItemStack blocks2 = new ItemStack(Material.LEAVES, 64);
        ItemStack blocks3 = new ItemStack(Material.LOG, 64);
        Main.getInstance().startInv.put(blocks1, 4);
        Main.getInstance().startInv.put(blocks2, 5);
        Main.getInstance().startInv.put(blocks3, 6);

        ItemStack arrows = new ItemStack(Material.ARROW, 64);
        Main.getInstance().startInv.put(arrows, 9);

        ItemStack steaks = new ItemStack(Material.COOKED_BEEF, 64);
        Main.getInstance().startInv.put(steaks, 7);

        ItemStack star = new ItemStack(Material.NETHER_STAR);
        ItemMeta metaStar = star.getItemMeta();
        metaStar.setDisplayName("§6Pouvoir");
        star.setItemMeta(metaStar);
        Main.getInstance().startInv.put(star, 8);
    }
    
    public static void setDefaultItems()
    {
        Main.getInstance().startInv.clear();
        
        ItemStack star = new ItemStack(Material.NETHER_STAR);
        ItemMeta metaStar = star.getItemMeta();
        metaStar.setDisplayName("§6Pouvoir");
        star.setItemMeta(metaStar);

        Main.getInstance().startInv.put(star, 8);
    }
    
    public static void setInv(Player p)
    {
        p.getInventory().clear();
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "effect " + p.getName() + " clear");
        
        for(ItemStack s : Main.getInstance().startInv.keySet())
        {
            int index = Main.getInstance().startInv.get(s);

            if(index == 27)
            {
                p.getInventory().setHelmet(s);
            }
            else if(index == 28)
            {
                p.getInventory().setChestplate(s);
            }
            else if(index == 29)
            {
                p.getInventory().setLeggings(s);
            }
            else if(index == 30)
            {
                p.getInventory().setBoots(s);
            }
            else
            {
                p.getInventory().setItem(index, s);
            }
        }
    }
}
