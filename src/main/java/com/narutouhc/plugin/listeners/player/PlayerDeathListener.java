package com.narutouhc.plugin.listeners.player;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.akatsuki.Kakuzu;
import com.narutouhc.plugin.roles.solos.Orochimaru;
import com.narutouhc.plugin.roles.solos.Sasuke;
import com.narutouhc.plugin.utils.EnumWin;
import com.narutouhc.plugin.utils.GameStatus;
import com.narutouhc.plugin.utils.RolesUtils;

public class PlayerDeathListener implements Listener
{
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e)
    {
        Player p = e.getEntity();

        GamePlayer gp = GamePlayer.gamePlayers.get(p);

        if(GameStatus.isStatus(GameStatus.GAME))
        {
            if(!e.getDeathMessage().equalsIgnoreCase(p.getName() + " died"))
            {
                if(!gp.isKakuzu())
                {
                    if(Main.getInstance().konohas.contains(p))
                    {
                        Main.getInstance().konohas.remove(p);
                    }
                    else if(Main.getInstance().akatsukis.contains(p))
                    {
                        Main.getInstance().akatsukis.remove(p);
                    }
                    else if(Main.getInstance().solos.contains(p))
                    {
                        Main.getInstance().solos.remove(p);
                    }

                    if(gp.isOrochimaru())
                    {
                        Player sasuke = RolesUtils.getSasuke();

                        GamePlayer sasukeGp = GamePlayer.gamePlayers.get(sasuke);

                        if(sasuke != null && sasukeGp.isSasuke())
                        {
                            ((Sasuke)Main.getInstance().roles.get(sasuke)).orochimaruDie();
                        }

                    }
                    else if(gp.isSasuke())
                    {
                        Player orochimaru = RolesUtils.getOrochimaru();

                        GamePlayer orochimaruGp = GamePlayer.gamePlayers.get(orochimaru);

                        if(orochimaru != null && orochimaruGp.isOrochimaru())
                        {
                            ((Orochimaru)Main.getInstance().roles.get(orochimaru)).sasukeDie();
                        }

                    }

                    ItemStack s = null;

                    for(ItemStack stack : e.getDrops())
                    {
                        if(stack.getType() == Material.NETHER_STAR)
                        {
                            s = stack;
                        }
                    }

                    e.getDrops().remove(s);
                    e.setDeathMessage("\n");
                    Bukkit.broadcastMessage(Main.getInstance().getPrefix() + p.getDisplayName() + " §cest mort ! Il était §6" + gp.getRole().name());
                }
                else
                {
                    Kakuzu kakuzu = (Kakuzu)Main.getInstance().roles.get(p);

                    if(!kakuzu.hasRespawned)
                    {
                        kakuzu.respawnInv = p.getInventory().getContents();
                        e.getDrops().clear();
                        e.setKeepInventory(true);
                    }
                    else
                    {
                        if(Main.getInstance().akatsukis.contains(p))
                        {
                            Main.getInstance().akatsukis.remove(p);
                        }

                        e.setDeathMessage("\n");
                        Bukkit.broadcastMessage(Main.getInstance().getPrefix() + p.getDisplayName() + " §cest mort ! Il était §6" + gp.getRole().name());
                    }
                }
            }
            else
            {
                e.setDeathMessage("\n");
                Bukkit.broadcastMessage(Main.getInstance().getPrefix() + p.getDisplayName() + " §cest mort ! Il était §6" + gp.getRole().name());
            }

            checkForWin();
        }
    }

    private void checkForWin()
    {
        int sizeKonoha = 0, sizeAkatsuki = 0, sizeSolo = 0;

        sizeKonoha = Main.getInstance().konohas.size();
        sizeAkatsuki = Main.getInstance().akatsukis.size();
        sizeSolo = Main.getInstance().solos.size();

        if(Main.getInstance().pluginRunnable.ep >= 2)
        {
            if(sizeAkatsuki == 0 && sizeKonoha == 0)
            {
                GameStatus.setSatus(GameStatus.STOP);
                EnumWin.setWinner(EnumWin.SOLO);
            }
            else if(sizeAkatsuki == 0 && sizeSolo == 0)
            {
                GameStatus.setSatus(GameStatus.STOP);
                EnumWin.setWinner(EnumWin.KONOHA);
            }
            else if(sizeKonoha == 0 && sizeSolo == 0)
            {
                GameStatus.setSatus(GameStatus.STOP);
                EnumWin.setWinner(EnumWin.AKATSUKI);
            }
        }

        if(!EnumWin.isWinner(EnumWin.NONE))
        {

            List<Player> playerAlive = new ArrayList<Player>();

            String format = "";

            if(EnumWin.isWinner(EnumWin.KONOHA))
                format = "§bdu §aVillage de Konoha";
            if(EnumWin.isWinner(EnumWin.AKATSUKI))
                format = "§bde §cl'Akatsuki";
            if(EnumWin.isWinner(EnumWin.SOLO))
                format = "§bdes §6Déserteurs";

            for(Player pl : Bukkit.getOnlinePlayers())
            {
                pl.sendMessage("§f====================");
                pl.sendMessage("\n§bVictoire " + format);
                pl.sendMessage("\n§f====================");

                if(pl.getGameMode() == GameMode.SURVIVAL)
                {
                    if(Main.getInstance().akatsukis.contains(pl) || Main.getInstance().solos.contains(pl) || Main.getInstance().konohas.contains(pl))
                    {
                        pl.setGameMode(GameMode.SPECTATOR);
                        playerAlive.add(pl);
                    }
                }

                pl.playSound(pl.getLocation(), Sound.ENDERDRAGON_GROWL, 10f, 1f);
            }

            String message = "";

            for(Player p : Bukkit.getOnlinePlayers())
            {
                GamePlayer gp = GamePlayer.gamePlayers.get(p);

                if(!Main.getInstance().spectating.contains(p))
                {
                    if(playerAlive.contains(p))
                    {
                        message += "§r§5" + p.getDisplayName() + " : §d§o" + gp.getRole().name() + "\n";
                    }
                    else
                    {
                        message += "§r§5" + p.getDisplayName() + " : §d§o§m" + gp.getRole().name() + "\n";
                    }
                }

                p.teleport(new Location(p.getWorld(), 0, 150, 0));
            }

            Bukkit.broadcastMessage(message);
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e)
    {
        Player p = e.getPlayer();

        GamePlayer gp = GamePlayer.gamePlayers.get(p);

        if(!gp.isKakuzu())
        {
            p.setGameMode(GameMode.SPECTATOR);
        }
        else
        {
            Kakuzu kakuzu = (Kakuzu)Main.getInstance().roles.get(p);

            if(kakuzu.hasRespawned)
            {
                p.setGameMode(GameMode.SPECTATOR);
            }
            else
            {
                kakuzu.useAbility();
                p.getInventory().setContents(kakuzu.respawnInv);
                Main.getInstance().pluginRunnable.tpPlayer(p, 240, 370);
                p.setGameMode(GameMode.SPECTATOR);
            }
        }
    }
}
