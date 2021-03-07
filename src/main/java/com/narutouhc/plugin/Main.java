package com.narutouhc.plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.narutouhc.plugin.commands.CommandSetRole;
import com.narutouhc.plugin.commands.CommandStart;
import com.narutouhc.plugin.commands.ConstrucTabComplete;
import com.narutouhc.plugin.listeners.ListenerManager;
import com.narutouhc.plugin.recipes.RecipesManager;
import com.narutouhc.plugin.roles.Role;
import com.narutouhc.plugin.runnable.PluginRunnable;
import com.narutouhc.plugin.utils.GameStatus;

public class Main extends JavaPlugin
{
    // Instance du plugin
    private static Main instance;
    public PluginRunnable pluginRunnable;

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
        new RecipesManager().registerRecipes();
        setCommands();
        setGamePlayer();
        GameStatus.setSatus(GameStatus.WAITING);
        this.pluginRunnable = new PluginRunnable();
        this.pluginRunnable.runTaskTimer(this, 0, 20);

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

    public void setCommands()
    {
        addCommand("role", new CommandSetRole());
        addCommand("start", new CommandStart());
   }

    private void addCommand(String name, CommandExecutor e)
    {
        getCommand(name).setExecutor(e);
        getCommand(name).setTabCompleter(new ConstrucTabComplete());
    }

    private void setGamePlayer()
    {
        for(Player p : Bukkit.getOnlinePlayers())
        {
            if(GamePlayer.gamePlayers.get(p) == null)
            {
                new GamePlayer(p);
            }

            p.setMaxHealth(20);
            p.setHealth(20);
        }
    }

    // Prefixe des messages du plugin
    public String getPrefix()
    {
        return "§f[§6NarutoUhc§f] ";
    }
}
