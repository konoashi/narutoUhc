package com.narutouhc.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.utils.GameStatus;

public class CommandSpec implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(GameStatus.isStatus(GameStatus.WAITING))
        {
            if(!Main.getInstance().getConfig().getBoolean("whitelist"))
            {
                if(args.length == 0)
                {
                    if(sender instanceof Player)
                    {
                        Player p = (Player)sender;
                        if(Main.getInstance().spectating.contains(p))
                        {
                            Main.getInstance().spectating.remove(p);
                            sender.sendMessage(Main.getInstance().getPrefix() + "§aVous n'êtes plus spectateur de la partie");
                            p.setGameMode(GameMode.SURVIVAL);
                        }
                        else
                        {
                            Main.getInstance().spectating.add(p);
                            sender.sendMessage(Main.getInstance().getPrefix() + "§aVous êtes devenu spectateur de la partie");
                            p.setGameMode(GameMode.SPECTATOR);
                        }
                        return true;
                    }
                }
                else if(args.length == 1)
                {
                    Player p = Bukkit.getPlayer(args[0]);

                    if(p != null)
                    {
                        if(Main.getInstance().spectating.contains(p))
                        {
                            Main.getInstance().spectating.remove(p);
                            p.sendMessage(Main.getInstance().getPrefix() + "§aVous n'êtes plus spectateur de la partie");
                            sender.sendMessage(Main.getInstance().getPrefix() + "§a" + args[0] + "n'est plus spectateur de la partie");
                            p.setGameMode(GameMode.SURVIVAL);
                        }
                        else
                        {
                            Main.getInstance().spectating.add(p);
                            p.sendMessage(Main.getInstance().getPrefix() + "§aVous êtes devenu spectateur de la partie");
                            sender.sendMessage(Main.getInstance().getPrefix() + "§a" + args[0] + " est devenu spectateur de la partie");
                            p.setGameMode(GameMode.SPECTATOR);
                        }

                        return true;
                    }
                    else
                    {
                        sender.sendMessage(Main.getInstance().getPrefix() + "§cImpossible de trouver le joueur spécifié");
                    }
                }
            }
            else
                sender.sendMessage(Main.getInstance().getPrefix() + "§cLa partie est en whitelist");
        }
        else
            sender.sendMessage(Main.getInstance().getPrefix() + "§cLa partie est déjà en cours");
        return false;

    }

}
