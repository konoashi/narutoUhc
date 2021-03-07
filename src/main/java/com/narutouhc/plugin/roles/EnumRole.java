package com.narutouhc.plugin.roles;

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
    PAIN,
    NONE;
    
    public static String getDescription(EnumRole role)
    {
        if(role == NARUTO)
        {
            return "Vous avez §bVitesse 1§2.\nVous pouvez utiliser votre pouvoir toutes les 5 minutes.\nIl vous permet d'avoir §bVitesse 2 §2et §cForce 1§2 pour 30 secondes.\nVous devez gagner avec §aKonoha";
        }
        else if(role == SAKURA)
        {
            return "Vous pouvez utiliser votre pouvoir toutes les 5 minutes.\nIl vous permet de donner un effet de §cRégénération 1 §2à tous vos alliés pour 30 secondes.\nIl est effectif dans un rayon de 5 blocs.\\nVous devez gagner avec §aKonoha";
        }
        else if(role == SHIKAMARU)
        {
            return "Vous pouvez utiliser votre chaque minute.\nIl vous permet de bloquer un joueur pendant 1.5 secondes.\nUtilisez-le en tirant une flèche sur votre cible.\nVous devez gagner avec §aKonoha";
        }
        else if(role == CHOJI)
        {
            return "Vous pouvez utiliser votre une fois dans la partie.\nIl vous permet de retirer la moitié de la vie d'un joueur.\nVous devez gagner avec §aKonoha";
        }
        else if(role == MINATO)
        {
            return "Vous avez §bVitesse 2§2.\nVous pouvez utiliser votre deux fois dans la partie.\nIl vous permet vous téléporter à vos balises marquées sur des joueurs.\nVous devez gagner avec §aKonoha";
        }
        else if(role == SASUKE)
        {
            return "Vous avez §bVitesse 1§2.\nVous pouvez utiliser votre pouvoir toutes les 5 minutes.\nIl vous permet d'envoyer un éclair sur vos ennemis dans un rayon de 5 blocs.\nVous devez gagner avec §eOrochimaru";
        }
        else if(role == OROCHIMARU)
        {
            return "Vous possédez 15 coeurs. Si Sasuke meurt, vous n'en aurez que 8.\nVous devez gagner avec §eSasuke";
        }
        else if(role == KAKUZU)
        {
            return "Vous possédez 12 coeurs. Vous pouvez ressuciter une fois mais vout tomberez à 8 coeurs maximum.\nVous devez gagner avec §cl'Akatsuki";
        }
        else if(role == ITACHI)
        {
            return "Vous avez §bVitesse 1§2.\nVous pouvez voir la vie des gens.\nVous pouvez utiliser votre pouvoir toutes les 2 minutes.\nIl vous permet de mettre en feu vos ennemis dans un rayon de 15 blocs.\nVous devez gagner avec §cl'Akatsuki";
        }
        else if(role == DEIDARA)
        {
            return "Vous pouvez créer des §coeufs explosifs§2.\nVous devez gagner avec §cl'Akatsuki";
        }
        else if(role == PAIN)
        {
            return "Vous pouvez utiliser votre pouvoir toutes les 7 minutes.\nIl vous permet d'attirer vers vous tous les joueurs dans un rayon de 20 blocs.\nVous devez gagner avec §cl'Akatsuki";
        }
        
        return null;
    }
}
