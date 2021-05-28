package com.narutouhc.plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;

import com.narutouhc.plugin.commands.CommandAllow;
import com.narutouhc.plugin.commands.CommandBlacklist;
import com.narutouhc.plugin.commands.CommandCancel;
import com.narutouhc.plugin.commands.CommandConfig;
import com.narutouhc.plugin.commands.CommandEpisode;
import com.narutouhc.plugin.commands.CommandFs;
import com.narutouhc.plugin.commands.CommandGetRole;
import com.narutouhc.plugin.commands.CommandInfo;
import com.narutouhc.plugin.commands.CommandInv;
import com.narutouhc.plugin.commands.CommandMe;
import com.narutouhc.plugin.commands.CommandSetRole;
import com.narutouhc.plugin.commands.CommandSpec;
import com.narutouhc.plugin.commands.CommandStart;
import com.narutouhc.plugin.commands.ConstrucTabComplete;
import com.narutouhc.plugin.listeners.ListenerManager;
import com.narutouhc.plugin.recipes.RecipesManager;
import com.narutouhc.plugin.roles.Role;
import com.narutouhc.plugin.runnable.PluginRunnable;
import com.narutouhc.plugin.utils.GameStatus;
import com.narutouhc.plugin.utils.StuffUtil;

public class Main extends JavaPlugin
{
    // Instance du plugin
    private static Main instance;
    public PluginRunnable pluginRunnable;
    public Map<ItemStack, Integer> startInv = new HashMap<ItemStack, Integer>();

    public List<Player> spectating = new ArrayList<Player>();
    public List<Player> players = new ArrayList<Player>();

    public Map<Player, Integer> diamonds = new HashMap<Player, Integer>();

    public HashMap<Player, PermissionAttachment> perms = new HashMap<Player, PermissionAttachment>();
    public List<Player> whitelist = new ArrayList<Player>();

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
        Bukkit.getWorld("world").setGameRuleValue("naturalRegeneration", "false");
        setWorldBorder();
        StuffUtil.setDefaultItems();
        setDefaultConfig();

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
        addCommand("me", new CommandMe());
        addCommand("ep", new CommandEpisode());
        addCommand("fs", new CommandFs());
        addCommand("inv", new CommandInv());
        addCommand("info", new CommandInfo());
        addCommand("config", new CommandConfig());
        addCommand("spec", new CommandSpec());
        addCommand("allow", new CommandAllow());
        addCommand("blacklist", new CommandBlacklist());
        addCommand("getrole", new CommandGetRole());
        addCommand("cancel", new CommandCancel());
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

            if(!this.diamonds.containsKey(p))
            {
                this.diamonds.put(p, 0);
            }

            if(!this.perms.containsKey(p))
            {
                PermissionAttachment attachment = p.addAttachment(Main.getInstance());
                attachment.setPermission("narutouhc.me", true);
                attachment.setPermission("narutouhc.info", true);
                attachment.setPermission("narutouhc.spec", true);
                this.perms.put(p, attachment);
            }

            p.setMaxHealth(20);
            p.setHealth(20);
        }
    }

    private void setDefaultConfig()
    {
        saveDefaultConfig();

        if(getConfig().getString("inv").equalsIgnoreCase("uhc"))
        {
            StuffUtil.setDefautltUhcStuff();
        }
        else
            StuffUtil.setDefaultItems();
    }

    private void setWorldBorder()
    {
        Bukkit.getWorld("world").getWorldBorder().setCenter(0, 0);;
        Bukkit.getWorld("world").getWorldBorder().setSize(750 * 2);
    }

    // Prefixe des messages du plugin
    public String getPrefix()
    {
        return "§f[§6NarutoUhc§f] ";
    }
}
