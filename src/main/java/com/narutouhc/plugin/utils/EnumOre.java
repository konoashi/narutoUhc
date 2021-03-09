package com.narutouhc.plugin.utils;

import org.bukkit.Material;

public enum EnumOre
{
    IRON,
    GOLD;

    public static Material getResultFromBlock(EnumOre ore)
    {
        if(ore == GOLD)
            return Material.GOLD_INGOT;
        else if(ore == IRON)
            return Material.IRON_INGOT;

        return null;
    }

    public static int getXpFromBlock(EnumOre ore)
    {
        if(ore == GOLD)
            return 5;
        else if(ore == IRON)
            return 4;

        return 0;
    }
}
