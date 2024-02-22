
class Pilha {
    
    Object[] pilha;
    boolean cheia;
    int topo = 0;

    Pilha(int tamanhoPilha) {
        pilha = new Object[tamanhoPilha];
    }

    void empilha(Object elemento) {
        pilha[topo] = elemento;
        topo ++;
    }

    boolean vazia() {
        if(topo == 0){
            return true;
        } else {
            return false;
        }
    }

    Object verificaTopo() {
        return pilha[topo-1];
    }

    Object desempilha() {
        topo--;
        return pilha[topo];
    }

    boolean cheia() {
        if(topo==10){
            return true;
        } else {
            return false;
        }
    }
}
