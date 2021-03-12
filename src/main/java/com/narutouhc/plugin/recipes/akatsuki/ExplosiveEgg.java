package com.narutouhc.plugin.recipes.akatsuki;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class ExplosiveEgg
{
    private static ItemStack egg = new ItemStack(Material.EGG);

    private static ItemMeta meta = egg.getItemMeta();

    public static ShapedRecipe recipe;

    public static void register()
    {
        meta.setDisplayName("§cOeuf explosif");
        egg.setItemMeta(meta);
        recipe = new ShapedRecipe(egg);

        recipe.shape(" # ", "#$#", " # ");

        recipe.setIngredient('$', Material.EGG);
        recipe.setIngredient('#', Material.SULPHUR);
    }

}
