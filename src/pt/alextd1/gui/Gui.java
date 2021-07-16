package pt.alextd1.gui;

import pt.alextd1.model.Message;
import pt.alextd1.tools.TdFonctions;

import java.util.Scanner;

public class Gui
{
    // fonction permettant l'affichage du menu et l'utilisation des fonctions
    public static void menu()
    {
        // déclaration des variables utilisées
        Scanner sc = new Scanner(System.in);
        TdFonctions td = new TdFonctions();
        Message mess;
        int choix;
        String clef, msgclair, msgcode,chxclef;
        boolean continuer = true;

        // boucle menu
        do {
            System.out.println("""
                    ╔═══════════════════════════╗
                    ║  Système d'encodage et de ║
                    ║    décodage de messages   ║
                    ╠═══════════════════════════╣
                    ║   1) Encoder un message   ║
                    ║   2) Décoder un message   ║
                    ║   0) Quitter le programme ║
                    ╚═══════════════════════════╝
                    """);
            choix = sc.nextInt();

            // switch pour le menu
            switch (choix) {
                case 1 -> {
                    //premier cas

                    System.out.println("Avez-vous une clef? oui/non");
                    sc.nextLine();
                    chxclef = sc.nextLine().toLowerCase();
                    if(chxclef.equals("oui")){
                        // récupération des noms de fichiers contenant la clef
                        System.out.println("Entrez le nom du fichier contenant la clef :");
                        sc.nextLine();
                        clef = sc.nextLine();
                    }else{
                        System.out.println("Entrez le nom du fichier dans lequel vous vouler créer votre clef :");
                        clef=sc.nextLine();
                    }


                    // récupération du texte a ENCODER
                    System.out.println("Entrez le nom du fichier contenant le texte à encoder :");
                    msgclair = sc.nextLine();

                    // récupération du nom de fichier contenant le résultat
                    System.out.println("Entrez le nom de fichier dans lequel vous voulez récupérer votre message codé :");
                    msgcode = sc.nextLine();

                    // création d'un nouveau Message
                    mess = new Message(false, td.StringToPaths(msgclair), td.StringToPaths(msgcode), td.StringToPaths(clef));

                    // écritures dans les fichiers
                    mess.editer();
                }
                case 2 -> {
                    //deuxième cas

                    // récupération des noms de fichiers contenant la clef
                    System.out.println("Entrez le nom du fichier contenant la clef :");
                    sc.nextLine();
                    clef = sc.nextLine();

                    // récupération du texte à DECODER
                    System.out.println("Entrez le nom du fichier contenant le texte à decoder :");
                    msgcode = sc.nextLine();

                    // récupération du nom de fichier contenant le résultat
                    System.out.println("Entrez le nom du fichier dans lequel vous voulez récupérer le message décodé :");
                    msgclair = sc.nextLine();

                    // création d'un nouveau Message, pour la fonction StringtoPaths, cf pt.alextd1.tools.Tdfonctions;
                    mess = new Message(true, td.StringToPaths(msgclair), td.StringToPaths(msgcode), td.StringToPaths(clef));

                    // écritures dans les fichiers
                    mess.editer();
                }
                case 0 -> {
                    //quitter le programme
                    System.out.println("""
                                                            
                                               ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                               ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                               ▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                               ▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒█▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                               ▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█▒▒▒██▒▒▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                               ▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒█▒▒▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                               ▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█████████▒▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                               ▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▒▒▒████████▒█▒▒▒▒▒▒█▒▒▒██▒▒▒▒▒██▒▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                               ▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒█▒█▒▒▒▒▒▒█▒▒██▒▒▒▒▒▒▒█▒▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                               ▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒█▒█▒▒▒▒▒▒█▒▒█▒▒▒▒▒▒▒▒██▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                               ▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▒██▒▒▒▒▒▒▒█▒█▒▒▒▒▒▒█▒▒█▒▒▒▒▒▒▒▒▒█▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                               ▒▒▒▒▒▒▒██████████▒▒█████████▒████████▒▒█▒▒▒▒▒▒▒▒▒█▒▒██████████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                               ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                               ▒▒▒▒▒▒▒▒████████▒▒██▒▒▒█▒███████▒▒▒█▒▒▒▒█▒▒████████▒████████▒██████▒████████▒███████▒████████▒▒▒▒
                                               ▒▒▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒███▒▒█▒█▒▒▒▒▒▒█▒▒█▒▒▒▒█▒▒█▒▒▒▒▒▒▒▒▒▒▒█▒▒▒▒▒█▒▒▒▒█▒▒▒▒█▒▒▒▒▒█▒▒▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▒▒
                                               ▒▒▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒█▒██▒█▒█▒▒▒▒▒▒█▒▒█▒▒▒▒█▒▒████████▒▒▒▒█▒▒▒▒▒█████▒▒▒▒▒█▒▒▒▒▒████▒▒▒▒████████▒▒▒▒
                                               ▒▒▒▒▒▒▒▒▒▒▒█▒▒▒▒▒▒█▒▒▒██▒█▒▒▒▒▒▒█▒▒█▒▒▒▒█▒▒▒▒▒▒▒▒▒█▒▒▒▒█▒▒▒▒▒█▒██▒▒▒▒▒▒█▒▒▒▒▒█▒▒▒▒▒▒▒▒▒▒▒▒▒▒█▒▒▒▒
                                               ▒▒▒▒▒▒▒▒████████▒▒█▒▒▒██▒███████▒▒▒██████▒▒████████▒▒▒▒█▒▒▒▒▒█▒▒▒██▒████████▒███████▒████████▒▒▒▒
                                               ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                               ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                      
                            """);
                    System.out.println("""
                                                                                ╔═══════════════════════════╗
                                                                                ║  Merci d'avoir utilisé ce ║
                                                                                ║   système de décryptage   ║
                                                                                ╠═══════════════════════════╣
                                                                                ║Copyright LouAl industries ║
                                                                                ║   tous droits réservés    ║
                                                                                ║   Le java c'est rigolo    ║
                                                                                ╚═══════════════════════════╝
                            """);
                    // le boolean passe a false pour sortir de la boucle while
                    continuer = false;
                }
                default -> System.out.println("la fonction n'est pas reconnue. Réessayez ou quittez");
            }
        } while (continuer);
    }
}
