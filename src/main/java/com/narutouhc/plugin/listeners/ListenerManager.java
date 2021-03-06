package com.narutouhc.plugin.listeners;

import com.narutouhc.plugin.listeners.player.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class ListenerManager
{

    public Plugin plugin;
    public PluginManager pm;

    public ListenerManager(Plugin p)
    {
        this.plugin = p;
        this.pm = Bukkit.getPluginManager();
    }

    public void registerListeners()
    {
        pm.registerEvents(new PlayerJoinListener(), this.plugin);
    }

}
