
public class ArvoreBinaria {

    Palavra root;

    ArvoreBinaria() {
    // Cria uma árvore binária vazia
        root = null;
    }

    public boolean isEmpty(){
        // verifica se a árvore está vazia
        if (root==null)
            return true;
        else
            return false;
    }

    public void addRoot(Palavra e) throws Exception{
        // adiciona o Nó e como raiz
        if (root != null)
            throw new Exception ("Árvore já tem raiz");
        root = e;        
    }

    public Palavra root(){
        //retorna a raiz da árvore
        return root;
    }

    public boolean isInternal(Palavra e){
        // verifica se o nó e é interno ou não
        if (e.left!=null || e.right!=null)
            return true;
        else
            return false;
    }

    public boolean isLeaf(Palavra e){
        // verifica se o nó e é folha ou não
        if (e.left==null && e.right==null)
            return true;
        else
            return false;
    }

    public void addLeft(Palavra e, Palavra m) throws Exception{
        // adiciona e como filho esquerdo de m
        // e = filho
        // m  = pai
        if (m.left!=null)
            throw new Exception ("Já existe filho esquerdo");
        m.left = e;
        e.parent = m;
    }

    public Palavra left (Palavra e){
        // retorna o filho à esquerda de e
        return e.left;
    }

    public boolean hasLeft(Palavra e){
        // verifica se e tem ou naõ filho à esquerda
        if (e.left!=null)
            return true;
        else
            return false;
    }

    public void addRight(Palavra e, Palavra m) throws Exception{
        // adiciona e como filho direito de m
        // e = filho
        // m  = pai
        if (m.right!=null)
            throw new Exception ("Já existe filho direito");
        m.right = e;
        e.parent = m;
    }

    public Palavra right (Palavra e){
        // retorna o filho à direita de e
        return e.right;
    }

    public boolean hasRight(Palavra e){
        // verifica se e tem ou não filho à direita
        if (e.right!=null)
            return true;
        else
            return false;
    }

    public void remove(Palavra e){
        //remove o e com todos os descendentes
        if (e==root)
            root = null;
        else
            if (e.parent.left == e)
                e.parent.left = null;
            else
                if (e.parent.right == e)
                    e.parent.right = null;            
    }

    public void visitaPreOrdem(Palavra e){
        // exibe todos os nós na forma RED
        if (e == null)
            return;
        e.exibePalavra();
        visitaPreOrdem(e.left);
        visitaPreOrdem(e.right);
    }

    public void visitaPosOrdem(Palavra e){
        // exibe todos os nós na forma EDR
        if (e == null)
            return;        
        visitaPosOrdem(e.left);
        visitaPosOrdem(e.right);
        e.exibePalavra();
    }

    public void visitaInOrdem(Palavra e){
        // exibe todos os nós na forma ERD
        if (e == null)
            return;        
        visitaInOrdem(e.left);
        e.exibePalavra();
        visitaInOrdem(e.right);        
    }

    public Palavra encontraPalavra(Palavra root_, Palavra p){
        if(root_ == null) return null;
        if(root_.palavra.compareTo(p.palavra) == 0) {
            p.ocorrencias += 1;
            return root_;
        }

        if(root_.palavra.compareTo(p.palavra) < 0 ){
            return encontraPalavra(root_.right, p);
        }   
        else { 
            return encontraPalavra(root_.left, p);
        }
    }

    public void inserePalavra(Palavra p){
        Palavra finded = encontraPalavra(root, p);
        if(finded != null) return;

        Palavra aux = null;
        Palavra root_ = root();
        while (root_ != null) {
            aux = root_;
            if (root_.palavra.compareTo(p.palavra) > 0) { 
                root_ = root_.left;
            } else {
                root_ = root_.right;
            }
        }

        p.parent = aux;
        if (aux == null) {
            root = p;
        } else if (aux.palavra.compareTo(p.palavra) > 0) { 
            aux.left = p;
        } else {
            aux.right = p; 
        }
       
    }
}
