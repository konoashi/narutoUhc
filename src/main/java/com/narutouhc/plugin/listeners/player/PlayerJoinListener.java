package com.narutouhc.plugin.listeners.player;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.scoreboard.ScoreboardManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener
{

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e)
    {
        Player p = e.getPlayer();

        if(GamePlayer.gamePlayers.get(p) == null)
        {
            new GamePlayer(p);
            e.setJoinMessage(Main.getInstance().getPrefix() + p.getDisplayName() + "§e vient de se connecter");
        }
        else
            e.setJoinMessage(Main.getInstance().getPrefix() + p.getDisplayName() + "§e vient de se reconnecter");

        if(!ScoreboardManager.scoreboardGame.containsKey(p))
        {
            if(Main.getInstance().pluginRunnable.started)
                new ScoreboardManager(p);
        }
    }

}
