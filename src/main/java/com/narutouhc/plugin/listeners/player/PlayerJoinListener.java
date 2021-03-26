package com.narutouhc.plugin.listeners.player;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.scoreboard.ScoreboardManager;
import com.narutouhc.plugin.utils.GameStatus;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.PermissionAttachment;

public class PlayerJoinListener implements Listener
{

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e)
    {
        Player p = e.getPlayer();

        if(!GamePlayer.gamePlayers.containsKey(p))
        {
            new GamePlayer(p);
            e.setJoinMessage(Main.getInstance().getPrefix() + p.getDisplayName() + "§e vient de se connecter");

            if(GameStatus.isStatus(GameStatus.GAME))
            {
                p.setGameMode(GameMode.SPECTATOR);
            }
        }
        else
            e.setJoinMessage(Main.getInstance().getPrefix() + p.getDisplayName() + "§e vient de se reconnecter");

        if(!ScoreboardManager.scoreboardGame.containsKey(p))
        {
            if(Main.getInstance().pluginRunnable.started)
                new ScoreboardManager(p);
        }

        if(!Main.getInstance().perms.containsKey(p))
        {
            PermissionAttachment attachment = p.addAttachment(Main.getInstance());
            attachment.setPermission("narutouhc.me", true);
            attachment.setPermission("narutouhc.info", true);
            attachment.setPermission("narutouhc.spec", true);
            Main.getInstance().perms.put(p, attachment);
        }

        if(!Main.getInstance().diamonds.containsKey(p))
        {
            Main.getInstance().diamonds.put(p, 0);
        }

        if(!GameStatus.isStatus(GameStatus.WAITING))
        {
            if(!Main.getInstance().players.contains(p))
            {
                Main.getInstance().spectating.add(p);
            }
        }

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e)
    {
        if(GameStatus.isStatus(GameStatus.GAME))
            if(e.getPlayer().getGameMode() == GameMode.SURVIVAL)
            {
                e.getPlayer().damage(20);
                
                if(Main.getInstance().konohas.contains(e.getPlayer()))
                {
                    Main.getInstance().konohas.remove(e.getPlayer());
                }
                else if(Main.getInstance().akatsukis.contains(e.getPlayer()))
                {
                    Main.getInstance().akatsukis.remove(e.getPlayer());
                }
                else if(Main.getInstance().solos.contains(e.getPlayer()))
                {
                    Main.getInstance().solos.remove(e.getPlayer());
                }
                
                e.getPlayer().setGameMode(GameMode.SPECTATOR);
                
                PlayerDeathListener.checkForWin();
            }
        e.setQuitMessage(Main.getInstance().getPrefix() + e.getPlayer().getDisplayName() + "§e vient de se déconnecter");
    }
}
