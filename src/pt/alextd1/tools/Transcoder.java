package pt.alextd1.tools;

import org.apache.commons.lang3.StringUtils;
import org.germain.tool.ManaBox;

import java.util.HashMap;

public class Transcoder
{

    // tableau permettant le décodage
    private HashMap<String, Character> tableauDecode = new HashMap<>();
    //tableau permettant l'encodage
    private HashMap<Character, String> tableauEncode = new HashMap<>();


// constructeur du transcodeur prenant en paramètre la clef cryptée
    public Transcoder(String clef)
    {
        // initialisation des variables, ici tempchar sera uniquement une variable tampon
        char tempchar;

        // décryptage de la clef
        String clearKey = ManaBox.decrypt(clef);
        String debut = "AA";

        // pour chaque character de la clef décryptée
        for (char c : clearKey.toCharArray()) {

            // entrer clef valeur / valeur clef dans les tableaux de codage et décodage
            tableauDecode.put(debut, c);
            tableauEncode.put(c, debut);

            // if permettant l'incrémentation des char et donc de passer de AA à AB, etc...
            // + si le char position (1) est Z, il repasse à A et c'est le premier char (position 0) qui s'incrémente de un
            // permettant de passer de AZ à BA
            if (debut.charAt(1) != 'Z') {
                tempchar = debut.charAt(1);
                tempchar++;
                debut = "" + debut.charAt(0) + tempchar;
            } else {
                tempchar = debut.charAt(0);
                tempchar++;
                debut = "" + tempchar + "A";
            }
        }
    }


    // getters permettant d'avoir les tableaux, pour les tests
    public HashMap<String, Character> getTableauDecode()
    {
        return tableauDecode;
    }

    public HashMap<Character, String> getTableauEncode()
    {
        return tableauEncode;
    }

    // fonction encodage avec en paramètre la phrase a coder
    public String encode(String phrase)
    {
        // déclaration de la string qui sera retournée
        String encoded="";
        // strippage des accents
        phrase = StringUtils.stripAccents(phrase);
        // codage de chaque char de la phrase + return la string encodé
        for(char ch : phrase.toCharArray()){
            encoded+=tableauEncode.get(ch);
        }
        return encoded;
    }

    // fonction décodage avec en paramètre la chaine de caractères codés
    public String decode(String phrase)
    {
        // déclaration du string qui sera retourné
        String decoded="";
        // récupération de la taille de la phrase
        int taille = phrase.length();
// boucle for prenant 2 charactères par deux charactères pour la correspondance tableau
        for(int i=0;i<=taille-2; i=i+2){
            decoded+=tableauDecode.get(phrase.substring(i,i+2));
        }
        return decoded;
    }
}
