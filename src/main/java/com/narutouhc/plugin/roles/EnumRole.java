package com.narutouhc.plugin.roles;

import com.narutouhc.plugin.utils.RolesUtils;

public enum EnumRole
{
    NARUTO, 
    SAKURA,
    SHIKAMARU,
    CHOJI,
    MINATO,
    SASUKE,
    OROCHIMARU, 
    KAKUZU,
    ITACHI,
    DEIDARA,
    HIDAN,
    PAIN,
    GAI,
    ZETSU,
    CHIKUSHODO,
    NINGENDO,
    VILLAGEOIS,
    JIRAYA,
    NONE;
    
    public static String getDescription(EnumRole role)
    {
        if(role == NARUTO)
        {
            return "§e========= §6Naruto §e=========\n" +
                    "§6Effets : §cVitesse 1\n" +
                    "§6Cooldown : §c5 minutes.\n" +
                    "§6Pouvoir : §cDonne vitesse 2 & Force 1 pendant 30 secondes.\n" +
                    "§6Victoire : §cAvec Konoha\n" +
                    "§e=========================";
        }
        else if(role == SAKURA)
        {
            return "§e========= §6Sakura §e=========\n" +
                    "§6Effets : §cAucun 1\n" +
                    "§6Cooldown : §c5 minutes.\n" +
                    "§6Pouvoir : §cDonne un effet de régénération à chaque allié.\n" +
                    "§6Rayon : §c5 blocs\n" +
                    "§6Victoire : §cAvec Konoha\n" +
                    "§e=========================";
        }
        else if(role == SHIKAMARU)
        {
            return "§e========= §6Shikamaru §e=========\n" +
                    "§6Effets : §cAucun 1\n" +
                    "§6Cooldown : §c1 minute.\n" +
                    "§6Pouvoir : §cFige une cible à l'arc pendant 1.5 secondes.\n" +
                    "§6Victoire : §cAvec Konoha\n" +
                    "§e============================";
        }
        else if(role == CHOJI)
        {
            return "§e========= §6Choji §e=========\n" +
                    "§6Effets : §cAucun 1\n" +
                    "§6Nombres d'utilisations : §cUne fois dans la partie.\n" +
                    "§6Pouvoir : §cEnlève la moitié de sa vie à une cible choisie.\n" +
                    "§6Victoire : §cAvec Konoha\n" +
                    "§e========================";
        }
        else if(role == MINATO)
        {
            String narutoName = RolesUtils.getNaruto() != null ? RolesUtils.getNaruto().getDisplayName() : "§cPas dans la partie";
            
            return "§e========= §6Minato §e=========\n" +
                    "§6Effets : §cVitesse 2\n" +
                    "§6Nombres d'utilisations : §cDeux fois dans la partie.\n" +
                    "§6Pouvoir : §cPeut se téléporter à une des ses balises posées sur un joueur.\n" +
                    "§6Victoire : §cAvec Konoha\n" +
                    "§6Naruto : §c" + narutoName + "\n" +
                    "§e=========================";
        }
        else if(role == SASUKE)
        {
            String itachiName = RolesUtils.getItachi() != null ? RolesUtils.getItachi().getDisplayName() : "§cPas dans la partie";
            
            return "§e========= §6Sasuke §e=========\n" +
                    "§6Effets : §cVitesse 1 et Faiblesse 1 (si Orochimaru meurt)\n" +
                    "§6Cooldown : §c5 minutes.\n" +
                    "§6Pouvoir : §cEnvoie un éclair sur chaque ennemi.\n" +
                    "§6Rayon : §c5 blocs\n" +
                    "§6Victoire : §cAvec Orochimaru\n" +
                    "§6Itachi : §c" + itachiName + "\n" +
                    "§e=========================";
        }
        else if(role == OROCHIMARU)
        {
            String sasukeName = RolesUtils.getSasuke() != null ? RolesUtils.getSasuke().getDisplayName() : "§cPas dans la partie";
            
            return "§e========= §6Orochimaru §e=========\n" +
                    "§6Effets : §cAucun\n" +
                    "§6Pouvoir : §cVous avez 15 coeurs (8 si Sasuke meurt).\n" +
                    "§6Victoire : §cAvec Sasuke\n" +
                    "§6Sasuke: §c" + sasukeName + "\n" +
                    "§e=============================";
        }
        else if(role == KAKUZU)
        {
            return "§e========= §6Kakuzu §e=========\n" +
                    "§6Effets : §cAucun\n" +
                    "§6Pouvoir : §cVous pouvez ressuciter et avez 12 coeurs (8 après resurrection).\n" +
                    "§6Victoire : §cAvec l'Akatsuki\n" +
                    "§e=========================";
        }
        else if(role == ITACHI)
        {
            return "§e========= §6Itachi §e=========\n" +
                    "§6Effets : §cVitesse 2\n" +
                    "§6Cooldown : §c7 minutes.\n" +
                    "§6Pouvoir : - §cVous pouvez voir la vie des joueurs.\n" +
                    "          §6- §cEnflamme chaque ennemi\n" +
                    "§6Rayon : §c15 blocs\n" +
                    "§6Victoire : §cAvec l'Akatsuki\n" +
                    "§e=========================";
        }
        else if(role == DEIDARA)
        {
            return "§e========= §6Deidara §e=========\n" +
                    "§6Effets : §cAucun\n" +
                    "§6Pouvoir : - §cVous pouvez créer des §cOeufs explosifs§c.\n" +
                    "§6Victoire : §cAvec l'Akatsuki\n" +
                    "§e==========================";
        }
        else if(role == PAIN)
        {
            String itachiName = RolesUtils.getItachi() != null ? RolesUtils.getItachi().getDisplayName() : "§cPas dans la partie";
            
            return "§e========= §6Pain §e=========\n" +
                    "§6Effets : §cAucun\n" +
                    "§6Cooldown : §c2 minutes.\n" +
                    "§6Pouvoir : - §cVous pouvez attirer les joueurs vers vous mais perdez 3 coeurs définitivement à chaque utilisation.\n" +
                    "§6Rayon : §c20 blocs\n" +
                    "§6Victoire : §cAvec l'Akatsuki\n" +
                    "§6Itachi : §c" + itachiName + "\n" +
                    "§e=======================";
        }
        else if(role == ZETSU)
        {
            return "§e========= §6Zetsu §e=========\n" +
                    "§6Effets : §cAucun\n" +
                    "§6Pouvoir : - §cAucun§c.\n" +
                    "§6Victoire : §cAvec l'Akatsuki\n" +
                    "§e==========================";
        }
        else if(role == VILLAGEOIS)
        {
            return "§e========= §6Villageois §e=========\n" +
                    "§6Effets : §cAucun\n" +
                    "§6Pouvoir : - §cVous pouvez avoir Invisibilité pendant 2m.\n" +
                    "§6Cooldown: §c10 minutes.\n" +
                    "§6Victoire : §cAvec Konoha\n" +
                    "§e==========================";
        }
        else if(role == GAI)
        {
            return "§e========= §6Gai §e=========\n" +
                    "§6Effets : §cAucun\n" +
                    "§6Pouvoir : - §cVous pouvez débloquer 8 modes différent vous donnant des effets.\n" +
                    "            Néanmoins, vous mourrez après 1 minute au 8ème stade" +
                    "§6Victoire : §cAvec Konoha\n" +
                    "§e==========================";
        }
        else if(role == HIDAN)
        {
            return "§e========= §6Hidan §e=========\n" +
                    "§6Effets : §cAucun\n" +
                    "§6Pouvoir : - §cVous pouvez sélectionner un joueur dans la partie.\n" +
                    "            Si celui-ci esssaie de vous attaquer, il prendra les dégats à votre place" +
                    "§6Victoire : §cAvec l'Akatsuki\n" +
                    "§e==========================";
        }
        else if(role == CHIKUSHODO)
        {
            return "§e========= §6Chikushodo §e=========\n" +
                    "§6Effets : §cAucun\n" +
                    "§6Pouvoir : - §cVous pouvez téléporter tous les corps de pain et vous vers une localisation aléatoire.\n" +
                    "§6Victoire : §cAvec l'Akatsuki\n" +
                    "§6Cooldown: §c20 minutes.\n" +
                    "§e==========================";
        }
        else if(role == CHIKUSHODO)
        {
            return "§e========= §6Ningendo §e=========\n" +
                    "§6Effets : §cAucun\n" +
                    "§6Pouvoir : - §cVous pouvez, 2 fois dans la partie, inspecter le rôle d'un joueur.\n" +
                    "§6Victoire : §cAvec l'Akatsuki\n" +
                    "§6Cooldown: §c20 minutes.\n" +
                    "§e==========================";
        }        
        else if(role == JIRAYA)
        {
            String orochimaruName = RolesUtils.getOrochimaru() != null ? RolesUtils.getOrochimaru().getDisplayName() : "§cPas dans la partie";
            
            return "§e========= §6Jiraya §e=========\n" +
                    "§6Effets : §cVitesse 1 et Résistance 1\n" +
                    "§6Pouvoir : - §cSi vous êtes proche de Naruto, vous aurez Force 1.\n" +
                    "§6Victoire : §cAvec l'Akatsuki\n" +
                    "§6Orochimaru : §c" + orochimaruName + "\n" +
                    "§e==========================";
        } 
        
        return "";
    }
}
