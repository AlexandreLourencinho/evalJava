package pt.alextd1.model;

import org.germain.tool.ManaBox;
import pt.alextd1.tools.KeyGen;
import pt.alextd1.tools.Transcoder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Message
{
    // déclaration des membres utilisés pour encoder et décoder des messages
    // ici le boolean qui déterminera si le message est codé ou non, et donc s'il faut le coder ou le décoder
    private final boolean encoded;


    // chemin du fichier copntenant le message décodé
    private final Path msgClearPath;


    // chemin du fichier copntenant le message encodé
    private final Path msgEncodedPath;

    // chemin de la clef de décryptage
    private final Path keyPath;


    // clef de décryptage
    private String key;

    // transcoder
    private Transcoder transCoder;


    // constructeur qui prend en param le booléan et les différents chemins
    public Message(Boolean bool, Path cheminMessageDecode, Path cheminMessageEncode, Path cheminClef)
    {
        this.encoded = bool;
        this.keyPath = cheminClef;
        this.msgClearPath = cheminMessageDecode;
        this.msgEncodedPath = cheminMessageEncode;
    }


    // fonction permettant l'écriture et le décodage
    public void editer()
    {
        // si encoded est a true, le message est donc codé, donc on le décode
        if (encoded) {
            try {
                // on déclare une nouvelle liste qui stockera toutes les lignes du fichier contenant le message codé
                List<String> lireCode = Files.readAllLines(msgEncodedPath);
                //on récupère la clef
                key = Files.readString(keyPath);
                // on instancie le transcoder avec la clef récupérée juste au dessus
                transCoder = new Transcoder(key);

                // pour chaque chaine de caractère de la liste, chaque ligne de message codé
                for (String chaine : lireCode) {

                    // écrire dans le fichier de décodage le message décodé. s'ajoute ligne par ligne grace au  APPEND.
                    Files.writeString(msgClearPath, transCoder.decode(chaine) + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                }

            }
            catch (IOException e) {
                // récupère les erreurs et affiche les différentes données pour la localiser si besoin
                System.out.println("erreur " + e.getMessage() + " \n " + e.getCause());
                System.out.println(msgClearPath);
                System.out.println(key);
                System.out.println(keyPath);
                System.out.println(msgEncodedPath);
            }


        } else {
            // sinon encodé est false : donc le message n'est pas codé et il faut l'encoder
            // déclaration d'une liste contenant toutes les lignes de message non codé
            List<String> lireDecode = null;
            try {
                lireDecode = Files.readAllLines(msgClearPath);
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            if (Files.exists(keyPath)) {
                // récupération de la clef, comme au dessus
                try {
                    key = Files.readString(keyPath);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                // instanciation du transcoder
                transCoder = new Transcoder(key);

                // pour chaque ligne de message non codé
                for (String chaine : lireDecode) {
                    //écrire la version codé dans un fichier
                    try {
                        Files.writeString(msgEncodedPath, transCoder.encode(chaine) + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                KeyGen genclef = new KeyGen();
                try {
                    Files.writeString(keyPath, ManaBox.encrypt(genclef.randomKey()), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    key = Files.readString(keyPath);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                // instanciation du transcoder
                transCoder = new Transcoder(key);

                // pour chaque ligne de message non codé
                for (String chaine : lireDecode) {
                    //écrire la version codé dans un fichier
                    try {
                        Files.writeString(msgEncodedPath, transCoder.encode(chaine) + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
