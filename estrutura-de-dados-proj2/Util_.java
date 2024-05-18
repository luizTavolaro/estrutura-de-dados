import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*;
import java.util.Scanner; // Import the Scanner class to read text files

public class Util_ {
    int lines;

    public Util_(){
        lines = 0;
    }

    public String readFile(){
        String music = "";
        try{
            File myFile = new File("estrutura-de-dados-proj2/file/music.txt");
            Scanner scan = new Scanner(myFile);
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                music += data + " ";
            }
            scan.close();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return music.toUpperCase().trim();
    }

    public ArvoreBinaria fillTree(String data){
        ArvoreBinaria tree = new ArvoreBinaria();
        String[] words = data.split(" ");
        for (String w : words){
            Palavra p = new Palavra(w.trim());
            tree.inserePalavra(p);
        }
        return tree;
    }
}
