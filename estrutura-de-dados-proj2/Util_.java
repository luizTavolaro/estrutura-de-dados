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
            File myFile = new File("file/music.txt");
            Scanner scan = new Scanner(myFile);
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                music += " " + data;
            }
            scan.close();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return music.toUpperCase();
    }

    public void fillTree(String data){
        ArvoreBinaria tree = new ArvoreBinaria();
        String[] words = data.split(" ");
        for (String w : words){
            Palavra p = new Palavra(w);
            // System.out.println(p.palavra);
            try{
                if(tree.isEmpty()) {
                    tree.addRoot(p);
                }
            }
            catch(Exception ex){System.out.println("Não Funcionou");}
        }
        System.out.println(tree.root.palavra);
    }
}
