public class Palavra {
    String palavra;
    int ocorrencias;
    Palavra left, right, parent; 

    public Palavra(String palavra) {
        this.palavra = palavra;
        this.ocorrencias = 1;
        left = right = parent = null;
    }

    public void exibePalavra(){
        System.out.println(palavra);
    }

}