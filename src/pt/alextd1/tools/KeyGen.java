package pt.alextd1.tools;

import org.germain.tool.ManaBox;

import javax.crypto.KeyGenerator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static pt.alextd1.tools.Constantes.ALPHABET;


public class KeyGen
{
    private String prenom;
    private String generatedKey;
    private String generatedCryptedKey = null;

    public String getGeneratedCryptedKey() {
        return generatedCryptedKey;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getGeneratedKey() {
        return generatedKey;
    }

    public KeyGen(String prenom, String generatedCryptedKey) {
        this.prenom = prenom;
        this.generatedCryptedKey = generatedCryptedKey;
        this.generatedKey = ManaBox.decrypt(this.generatedCryptedKey);
    }

    public KeyGen(String prenom) {
        this.prenom = prenom;
        this.generatedKey = randomKey();
        this.generatedCryptedKey = ManaBox.encrypt(this.generatedKey);
    }

    public KeyGen()
    {

    }

    public String randomKey() {

        List<Character> charList = Arrays.asList(ALPHABET);

        Collections.shuffle(charList);

        StringBuilder chaineCode = new StringBuilder();
        for( Character car : charList){ chaineCode.append(car); }

        return String.valueOf(chaineCode);
    }

    public void writeKey(){

    }
}