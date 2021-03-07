package com.narutouhc.plugin.recipes;

import org.bukkit.Bukkit;

import com.narutouhc.plugin.recipes.akatsuki.ExplosiveEgg;

public class RecipesManager
{

	public void registerRecipes() {
		ExplosiveEgg.register();
		Bukkit.addRecipe(ExplosiveEgg.recipe);
	}
}
