package pt.alextd1.tools;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TdFonctions
{
    // petite fonction pour passer d'une chaine de caractère a un Path en se basant sur ce que rentre l'utilisateur comme information
    public Path StringToPaths(String fichier)
    {
        String dir = System.getProperty("user.dir");
        //        System.out.println(path);
        return Paths.get(dir,"fichiers/"+fichier+".txt");
    }
}
