import java.io.File;  
import java.util.Scanner;

public class Util_ {
    public int rows = 0;
    public int totalWords = 0;
    public ArvoreBinaria ordenadaPelaOcorrencia = new ArvoreBinaria();

    public Util_(){
    }

    public String readFile(){
        String music = "";
        try{
            File myFile = new File("estrutura-de-dados-proj2/file/music.txt");
            Scanner scan = new Scanner(myFile);
            while (scan.hasNextLine()) {
                rows += 1;
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
        totalWords = words.length;
        for (String w : words){
            Palavra p = new Palavra(w.trim());
            tree.inserePalavra(p);
        }
        return tree;
    }

    public void showTotalRows (){
        System.out.println("Total de Linhas no texto: " + rows);
    }

    public void showTotalWords (){
        System.out.println("Total de palavras no texto: " + totalWords );
    }

    public void showDistinctWords(ArvoreBinaria tree){
        tree.contaNodes(tree.root);
        int aux = tree.totalNodes;
        tree.totalNodes = 0;
        System.out.println("Total de palavras distintas no texto: " + aux );
    }

    public void showBiggestNode(ArvoreBinaria tree){
        tree.maiorPalavra(tree.root);
        System.out.println("Palavra mais longa no texto: "  + tree.maiorNode.palavra);
    }

    public void searchWord(ArvoreBinaria tree){
        System.out.println("Insira a palavra a ser buscada: " );
        Scanner scan_ = new Scanner(System.in);
        String word = scan_.nextLine().toUpperCase();
        Palavra word_ = tree.encontraPalavra(tree.root, new Palavra(word));
        if(word_ == null){
            System.out.println("Palavra não encontrada");
        }
        else{
            System.out.println(word_.palavra + " encontrda, e teve: " + word_.ocorrencias + " ocorrência(s) na árvore");
        }
    }

    public void ordemAlfabeitca(ArvoreBinaria tree){
        tree.visitaInOrdem(tree.root);
    }

    public void percorreArvoreParaInserirOrdenada(Palavra e){

        if (e == null)
            return;        
            
        Palavra p = new Palavra(e.palavra, e.ocorrencias);
        ordenadaPelaOcorrencia.inserePalavraPelaOcorrencia(p);

        percorreArvoreParaInserirOrdenada(e.left);
        percorreArvoreParaInserirOrdenada(e.right);   

    }

    public void menu(){
        System.out.println("Opção 1) Carregar Texto" );
        System.out.println("Opção 2) Stats" );
        System.out.println("Opção 3) Buscar Palavra" );
        System.out.println("Opção 4) Exibir Arvore" );
        System.out.println("Opção 5) Custom" );
        System.out.println("Opção 6) End" );
    }

}
