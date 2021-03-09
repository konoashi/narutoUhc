package com.narutouhc.plugin.listeners;

import com.narutouhc.plugin.listeners.player.*;
import com.narutouhc.plugin.listeners.throwable.ThrowableHitListener;

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
        pm.registerEvents(new PlayerDeathListener(), this.plugin);
        pm.registerEvents(new PlayerCraftListener(), this.plugin);
        pm.registerEvents(new PlayerInteractListener(), this.plugin);
        pm.registerEvents(new ThrowableHitListener(), this.plugin);
        pm.registerEvents(new ThrowableHitListener(), this.plugin);
        pm.registerEvents(new PlayerDamageListener(), this.plugin);
        pm.registerEvents(new PlayerGuiInteractListener(), this.plugin);
        pm.registerEvents(new PlayerLootListener(), this.plugin);
        pm.registerEvents(new PlayerGuiExitListener(), this.plugin);
        pm.registerEvents(new PlayerBreakListener(), this.plugin);
        pm.registerEvents(new PlayerChatListener(), this.plugin);
 }
}
