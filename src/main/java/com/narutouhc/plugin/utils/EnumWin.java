package com.narutouhc.plugin.utils;

public enum EnumWin
{
    NONE, 
    AKATSUKI,
    KONOHA,
    SOLO;
    
    private static EnumWin win = NONE;
    
    public static EnumWin getWinner()
    {
        return win;
    }
    
    public static void setWinner(EnumWin w)
    {
        win = w;
    }
    
    public static boolean isWinner(EnumWin w)
    {
        return w == win;
    }
}
