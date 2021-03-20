package com.narutouhc.plugin.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.google.common.base.Strings;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.Role;
import com.narutouhc.plugin.roles.akatsuki.Deidara;
import com.narutouhc.plugin.roles.akatsuki.Itachi;
import com.narutouhc.plugin.roles.akatsuki.Kakuzu;
import com.narutouhc.plugin.roles.akatsuki.Pain;
import com.narutouhc.plugin.roles.akatsuki.Zetsu;
import com.narutouhc.plugin.roles.konoha.Choji;
import com.narutouhc.plugin.roles.konoha.Gai;
import com.narutouhc.plugin.roles.konoha.Minato;
import com.narutouhc.plugin.roles.konoha.Naruto;
import com.narutouhc.plugin.roles.konoha.Ninja;
import com.narutouhc.plugin.roles.konoha.Sakura;
import com.narutouhc.plugin.roles.konoha.Shikamaru;
import com.narutouhc.plugin.roles.solos.Orochimaru;
import com.narutouhc.plugin.roles.solos.Sasuke;

public class RolesUtils
{
    private static Player gai, zetsu, ninja, naruto, sakura, shikamaru, choji, minato, sasuke, orochimaru, kakuzu, itachi, deidara, pain;

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

    public static Player getNinja()
    {
        if(ninja == null)
        {
            for(Player p : Main.getInstance().getServer().getOnlinePlayers())
            {
                GamePlayer gp = GamePlayer.gamePlayers.get(p);
                if(gp.isNinja())
                {
                    ninja = p;
                }
            }
        }

        return ninja;
    }
    
    public static Player getZetsu()
    {
        if(zetsu == null)
        {
            for(Player p : Main.getInstance().getServer().getOnlinePlayers())
            {
                GamePlayer gp = GamePlayer.gamePlayers.get(p);
                if(gp.isZetsu())
                {
                    zetsu = p;
                }
            }
        }

        return zetsu;
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

    public static Player getGai()
    {
        if(gai == null)
        {
            for(Player p : Main.getInstance().getServer().getOnlinePlayers())
            {
                GamePlayer gp = GamePlayer.gamePlayers.get(p);
                if(gp.isGai())
                {
                    gai = p;
                }
            }
        }

        return gai;
    }
    
    public static void setRoles()
    {
        List<Player> players = new ArrayList<Player>();
        
        for(Player p : Bukkit.getOnlinePlayers())
        {
            players.add(p);
        }
        
        Collections.shuffle(players);
        
        for(Player p : players)
        {
            getRandomRole(p);
        }
    }

    private static Role getRandomRole(Player p)
    {
        Random r = new Random();

        int i = r.nextInt(14);

        Role role = null;

        GamePlayer gp = GamePlayer.gamePlayers.get(p);

        if(i == 0)
        {
            if(naruto == null)
            {
                gp.setRole(EnumRole.NARUTO);

                role = new Naruto(p);
                gp.setPower(role);

                naruto = p;

            }
            else
                return getRandomRole(p);
        }
        else if(i == 1)
        {
            if(sakura == null)
            {
                gp.setRole(EnumRole.SAKURA);

                role = new Sakura(p);
                gp.setPower(role);

                sakura = p;

            }
            else
                return getRandomRole(p);
        }
        else if(i == 2)
        {
            if(shikamaru == null)
            {
                gp.setRole(EnumRole.SHIKAMARU);

                role = new Shikamaru(p);
                gp.setPower(role);

                shikamaru = p;

            }
            else
                return getRandomRole(p);
        }
        else if(i == 3)
        {
            if(choji == null)
            {
                gp.setRole(EnumRole.CHOJI);

                role = new Choji(p);
                gp.setPower(role);

                choji = p;

            }
            else
                return getRandomRole(p);
        }
        else if(i == 4)
        {
            if(minato == null)
            {
                gp.setRole(EnumRole.MINATO);

                role = new Minato(p);
                gp.setPower(role);

                minato = p;


            }
            else
                return getRandomRole(p);
        }
        else if(i == 5)
        {
            if(sasuke == null)
            {
                gp.setRole(EnumRole.SASUKE);

                role = new Sasuke(p);
                gp.setPower(role);

                sasuke = p;

            }
            else
                return getRandomRole(p);
        }
        else if(i == 6)
        {
            if(orochimaru == null)
            {
                gp.setRole(EnumRole.OROCHIMARU);

                role = new Orochimaru(p);
                gp.setPower(role);

                orochimaru = p;


            }
            else
                return getRandomRole(p);
        }
        else if(i == 7)
        {
            if(kakuzu == null)
            {
                gp.setRole(EnumRole.KAKUZU);

                role = new Kakuzu(p);
                gp.setPower(role);

                kakuzu = p;


            }
            else
                return getRandomRole(p);
        }
        else if(i == 8)
        {
            if(itachi == null)
            {
                gp.setRole(EnumRole.ITACHI);

                role = new Itachi(p);
                gp.setPower(role);

                ((Itachi)gp.getPower()).addLifeAbility();
                
                itachi = p;


            }
            else
                return getRandomRole(p);
        }
        else if(i == 9)
        {
            if(deidara == null)
            {
                gp.setRole(EnumRole.DEIDARA);

                role = new Deidara(p);
                gp.setPower(role);

                deidara = p;

                ItemStack egg = new ItemStack(Material.EGG);
                ItemMeta meta = egg.getItemMeta();
                
                meta.setDisplayName("§cOeuf explosif");
                egg.setItemMeta(meta);
                
                p.getInventory().addItem(egg);
            }
            else
                return getRandomRole(p);
        }
        else if(i == 10)
        {
            if(pain == null)
            {
                gp.setRole(EnumRole.PAIN);

                role = new Pain(p);
                gp.setPower(role);

                pain = p;


            }
            else
                return getRandomRole(p);
        }
        else if(i == 11)
        {
            if(zetsu == null)
            {
                gp.setRole(EnumRole.ZETSU);

                role = new Zetsu(p);
                gp.setPower(role);

                zetsu = p;


            }
            else
                return getRandomRole(p);
        }        
        else if(i == 12)
        {
            if(ninja == null)
            {
                gp.setRole(EnumRole.VILLAGEOIS);

                role = new Ninja(p);
                gp.setPower(role);

                ninja = p;
            }
            else
                return getRandomRole(p);
        }  
        else if(i == 13)
        {
            if(gai == null)
            {
                gp.setRole(EnumRole.GAI);

                role = new Gai(p);
                gp.setPower(role);

                gai = p;
            }
            else
                return getRandomRole(p);
        } 
        
        String cmp = "";

        if(Main.getInstance().konohas.contains(p)){
            cmp = "§aun ninja de Konoha";
        } else if(Main.getInstance().akatsukis.contains(p)){
            cmp = "§cun membre de l'Akatsuki";
        } else {
            cmp = "§eun déserteur du vilage";
        }

        p.sendMessage("\n§9========================================");
        String roleLine = "§5Voici votre rôle : §d" + gp.getRole().name();
        String cmpLine = "§9Vous êtes " + cmp;
        String infoLine = "§e/me §9pour en savoir plus";
    
        p.sendMessage(Strings.repeat(" ", (("========================================".length() / 2) - (cmpLine.length() / 2) + 4)) + cmpLine);
        p.sendMessage(Strings.repeat(" ", (("========================================".length() / 2) - (roleLine.length() / 2) + 4)) + roleLine);
        p.sendMessage(Strings.repeat(" ", (("========================================".length() / 2) - (infoLine.length() / 2) + 4)) + infoLine);

        p.sendMessage("§9========================================");

        return role;
    }
}
