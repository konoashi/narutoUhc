package com.narutouhc.plugin.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.narutouhc.plugin.GamePlayer;
import com.narutouhc.plugin.Main;
import com.narutouhc.plugin.roles.EnumRole;
import com.narutouhc.plugin.roles.akatsuki.Deidara;
import com.narutouhc.plugin.roles.akatsuki.Itachi;
import com.narutouhc.plugin.roles.akatsuki.Kakuzu;
import com.narutouhc.plugin.roles.akatsuki.Pain;
import com.narutouhc.plugin.roles.akatsuki.Zetsu;
import com.narutouhc.plugin.roles.konoha.Choji;
import com.narutouhc.plugin.roles.konoha.Minato;
import com.narutouhc.plugin.roles.konoha.Naruto;
import com.narutouhc.plugin.roles.konoha.Ninja;
import com.narutouhc.plugin.roles.konoha.Sakura;
import com.narutouhc.plugin.roles.konoha.Shikamaru;
import com.narutouhc.plugin.roles.solos.Orochimaru;
import com.narutouhc.plugin.roles.solos.Sasuke;

public class CommandSetRole implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(args.length == 1 && sender instanceof Player)
        {
            Player p = (Player)sender;
            GamePlayer gp = GamePlayer.gamePlayers.get(p);

            List<String> allowed = Arrays.asList("naruto", "sakura", "shikamaru", "choji", "minato", "sasuke", "orochimaru", "kakuzu", "itachi", "deidara", "pain", "zetsu");

            if(allowed.contains(args[0]))
            {
                if(args[0].equalsIgnoreCase("naruto"))
                {
                    gp.setRole(EnumRole.NARUTO);
                    gp.setPower(new Naruto(p));
                }
                else if(args[0].equalsIgnoreCase("sakura"))
                {
                    gp.setRole(EnumRole.SAKURA);
                    gp.setPower(new Sakura(p));
                }
                else if(args[0].equalsIgnoreCase("shikamaru"))
                {
                    gp.setRole(EnumRole.SHIKAMARU);
                    gp.setPower(new Shikamaru(p));
                }
                else if(args[0].equalsIgnoreCase("choji"))
                {
                    gp.setRole(EnumRole.CHOJI);
                    gp.setPower(new Choji(p));
                }
                else if(args[0].equalsIgnoreCase("minato"))
                {
                    gp.setRole(EnumRole.MINATO);
                    gp.setPower(new Minato(p));
                }
                else if(args[0].equalsIgnoreCase("sasuke"))
                {
                    gp.setRole(EnumRole.SASUKE);
                    gp.setPower(new Sasuke(p));
                }
                else if(args[0].equalsIgnoreCase("orochimaru"))
                {
                    gp.setRole(EnumRole.OROCHIMARU);
                    gp.setPower(new Orochimaru(p));
                }
                else if(args[0].equalsIgnoreCase("kakuzu"))
                {
                    gp.setRole(EnumRole.KAKUZU);
                    gp.setPower(new Kakuzu(p));
                }
                else if(args[0].equalsIgnoreCase("itachi"))
                {
                    gp.setRole(EnumRole.ITACHI);
                    gp.setPower(new Itachi(p));
                    ((Itachi)gp.getPower()).addLifeAbility();   
                }
                else if(args[0].equalsIgnoreCase("deidara"))
                {
                    gp.setRole(EnumRole.DEIDARA);
                    gp.setPower(new Deidara(p));
                }
                else if(args[0].equalsIgnoreCase("pain"))
                {
                    gp.setRole(EnumRole.PAIN);
                    gp.setPower(new Pain(p));
                }
                else if(args[0].equalsIgnoreCase("pain"))
                {
                    gp.setRole(EnumRole.PAIN);
                    gp.setPower(new Pain(p));
                }
                else if(args[0].equalsIgnoreCase("ninja"))
                {
                    gp.setRole(EnumRole.VILLAGEOIS);
                    gp.setPower(new Ninja(p));
                }
                else if(args[0].equalsIgnoreCase("zetsu"))
                {
                    gp.setRole(EnumRole.ZETSU);
                    gp.setPower(new Zetsu(p));
                }
                
                sender.sendMessage(Main.getInstance().getPrefix() + "§aVous venez de mettre votre rôle à §6" + args[0].toUpperCase());
            }
            else
            {
                sender.sendMessage(Main.getInstance().getPrefix() + "§cVous devez entrer un rôle valide");
            }
        }
        return false;
    }

}
