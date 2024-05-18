import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Util_ util = new Util_();
        boolean continue_ = true;
        ArvoreBinaria tree = new ArvoreBinaria();
        while(continue_){
            util.menu();
            Scanner scan_ = new Scanner(System.in);
            int num = Integer.parseInt(scan_.nextLine());
            switch(num){
                case 1:
                   String music = util.readFile();
                   tree = util.fillTree(music);
                   break;
                case 2:
                    util.showTotalRows();
                    util.showTotalWords();
                    util.showDistinctWords(tree);
                    util.showBiggestNode(tree);
                    break;
                case 3:
                    util.searchWord(tree); 
                    break;
                case 4:
                    util.ordemAlfabeitca(tree);
                    break;
                case 5:
                    util.percorreArvoreParaInserirOrdenada(tree.root);
                    util.ordenadaPelaOcorrencia.visitaInOrdem(util.ordenadaPelaOcorrencia.root);
                    break;
                case 6:
                    continue_ = false;
                    break;
            }
        }
    }
}
