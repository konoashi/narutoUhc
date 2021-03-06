package com.narutouhc.plugin;

import com.narutouhc.plugin.listeners.ListenerManager;
import com.narutouhc.plugin.roles.Role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    // Instance du plugin
    private static Main instance;

    // Teams
    public List<Player> konohas = new ArrayList<Player>(), akatsukis = new ArrayList<Player>(), solos = new ArrayList<Player>();

    // Roles
    public Map<Player, Role> roles = new HashMap<Player, Role>(); 

    // Appelé quand le plugin se charge
    @Override
    public void onLoad()
    {
        instance = this;
        Bukkit.getServer().getConsoleSender().sendMessage(getPrefix() + "§aChargement du plugin en cours");
    }

    // Appelé quand le plugin est activé
    @Override
    public void onEnable()
    {
        new ListenerManager(this).registerListeners();

        Bukkit.getServer().getConsoleSender().sendMessage(getPrefix() + "§aPlugin activé avec succès");
    }

    // Appelé quand le plugin est désactivé
    @Override
    public void onDisable()
    {
        Bukkit.getServer().getConsoleSender().sendMessage(getPrefix() + "§aPlugin désactivé avec succès");
    }

    // Fonction publique pour récupérer l'instance du plugin
    public static Main getInstance()
    {
        return instance;
    }

    // Prefixe des messages du plugin
    public String getPrefix()
    {
        return "§f[§6NarutoUhc§f] ";
    }
}
