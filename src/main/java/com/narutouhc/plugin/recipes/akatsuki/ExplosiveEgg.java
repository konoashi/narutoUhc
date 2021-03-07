package com.narutouhc.plugin.recipes.akatsuki;

import com.narutouhc.plugin.Main;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class ExplosiveEgg
{

	private ItemStack egg = new ItemStack(Material.EGG);

	private ItemMeta meta = egg.getItemMeta();

	public ShapedRecipe recipe;

	public void register() {
		meta.setDisplayName("§cOeuf explosif");
		egg.setItemMeta(meta);
		recipe = new ShapedRecipe(egg);

		recipe.shape(
				" # ",
				"#$#",
				" # "
		);

		recipe.setIngredient('$', Material.EGG);
		recipe.setIngredient('#', Material.SULPHUR);
	}

}
