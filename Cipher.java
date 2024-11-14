import java.util.Scanner;

public abstract class Cipher {
    public abstract char encrypt(char c);

    public abstract char decrypt(char c);

    public String encrypt(String s){
        Scanner scr = new Scanner(s);
        scr.useDelimiter("");
        StringBuilder sb = new StringBuilder("");
        while (scr.hasNext()){
            sb.append(encrypt(scr.next()));
        }
        return sb.toString();
    }

    public String decrypt(String s){
        Scanner scr = new Scanner(s);
        scr.useDelimiter("");
        StringBuilder sb = new StringBuilder("");
        while (scr.hasNext()){
            sb.append(decrypt(scr.next()));
        }
        return sb.toString();
    }

    public Cipher newCopy(){
        return newCopy();
    }

}
