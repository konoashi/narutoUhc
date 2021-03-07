package com.narutouhc.plugin.utils;

import org.bukkit.entity.Player;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.Main;

public class RolesUtils
{
    private static Player naruto, sakura, shikamaru, choji, minato, sasuke, orochimaru, kakuzu, itachi, deidara, pain;

    public static Player getNaruto()
    {
        if(naruto == null)
        {
            for(Player p : Main.getInstance().getServer().getOnlinePlayers())
            {
                GamePlayer gp = GamePlayer.gamePlayers.get(p);
                if(gp.isNaruto())
                {
                    naruto = p;
                }
            }
        }

        return naruto;
    }
    
    public static Player getSakura()
    {
        if(sakura == null)
        {
            for(Player p : Main.getInstance().getServer().getOnlinePlayers())
            {
                GamePlayer gp = GamePlayer.gamePlayers.get(p);
                
                if(gp.iSakura())
                {
                    sakura = p;
                }
            }
        }

        return sakura;
    }
    
    public static Player getShikamaru()
    {
        if(shikamaru == null)
        {
            for(Player p : Main.getInstance().getServer().getOnlinePlayers())
            {
                GamePlayer gp = GamePlayer.gamePlayers.get(p);
                
                if(gp.isShikamaru())
                {
                    shikamaru = p;
                }
            }
        }

        return shikamaru;
    }
    
    public static Player getChoji()
    {
        if(choji == null)
        {
            for(Player p : Main.getInstance().getServer().getOnlinePlayers())
            {
                GamePlayer gp = GamePlayer.gamePlayers.get(p);
                
                if(gp.isChoji())
                {
                    choji = p;
                }
            }
        }

        return choji;
    }
    
    public static Player getMinato()
    {
        if(minato == null)
        {
            for(Player p : Main.getInstance().getServer().getOnlinePlayers())
            {
                GamePlayer gp = GamePlayer.gamePlayers.get(p);
                
                if(gp.isMinato())
                {
                    minato = p;
                }
            }
        }

        return minato;
    }
    
    public static Player getSasuke()
    {
        if(sasuke == null)
        {
            for(Player p : Main.getInstance().getServer().getOnlinePlayers())
            {
                GamePlayer gp = GamePlayer.gamePlayers.get(p);
                
                if(gp.isSasuke())
                {
                    sasuke = p;
                }
            }
        }

        return sasuke;
    }
    
    public static Player getOrochimaru()
    {
        if(orochimaru == null)
        {
            for(Player p : Main.getInstance().getServer().getOnlinePlayers())
            {
                GamePlayer gp = GamePlayer.gamePlayers.get(p);
                
                if(gp.isOrochimaru())
                {
                    orochimaru = p;
                }
            }
        }

        return orochimaru;
    }
    
    public static Player getKakuzu()
    {
        if(kakuzu == null)
        {
            for(Player p : Main.getInstance().getServer().getOnlinePlayers())
            {
                GamePlayer gp = GamePlayer.gamePlayers.get(p);
                
                if(gp.isKakuzu())
                {
                    kakuzu = p;
                }
            }
        }

        return kakuzu;
    }
    
    public static Player getItachi()
    {
        if(itachi == null)
        {
            for(Player p : Main.getInstance().getServer().getOnlinePlayers())
            {
                GamePlayer gp = GamePlayer.gamePlayers.get(p);
                
                if(gp.isItachi())
                {
                    itachi = p;
                }
            }
        }

        return itachi;
    }
    
    public static Player getDeidara()
    {
        if(deidara == null)
        {
            for(Player p : Main.getInstance().getServer().getOnlinePlayers())
            {
                GamePlayer gp = GamePlayer.gamePlayers.get(p);
                
                if(gp.isDeidara())
                {
                    deidara = p;
                }
            }
        }

        return deidara;
    }
    
    public static Player getPain()
    {
        if(pain == null)
        {
            for(Player p : Main.getInstance().getServer().getOnlinePlayers())
            {
                GamePlayer gp = GamePlayer.gamePlayers.get(p);
                
                if(gp.isPain())
                {
                    pain = p;
                }
            }
        }

        return pain;
    }
}
