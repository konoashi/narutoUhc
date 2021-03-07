package com.narutouhc.plugin.recipes;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.recipes.akatsuki.ExplosiveEgg;
import org.bukkit.Bukkit;

public class RecipesManager
{

	public void registerRecipes() {
		ExplosiveEgg explosiveEgg = new ExplosiveEgg();
		explosiveEgg.register();
		Bukkit.addRecipe(explosiveEgg.recipe);
	}
}
