package com.narutouhc.plugin.utils;

public enum GameStatus
{
    WAITING,
    GAME,
    STOP;

    private static GameStatus currentStatus;

    public static boolean isStatus(GameStatus s)
    {
        return currentStatus == s;
    }

    public static GameStatus getStatus()
    {
        return currentStatus;
    }

    public static void setSatus(GameStatus status)
    {
        GameStatus.currentStatus = status;
    }
    
    public static String getName()
    {
        if(currentStatus == WAITING)
        {
            return "Attente";
        }
        else if(currentStatus == GAME)
        {
            return "Jeu";
        }
        else
            return "Fin de partie";
    }
}
