package Classes_Jogo;


//package Classes_Jogo;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;



public class Baralho {
    /* Classe composta por 52 cartas distintas formadas por 4 naipes e 13 numeros*/
    
    private List<Cartas> baralho=new ArrayList<>();
    
    public String nome;
   
    public Baralho(){
                             
        for (Naipes naipe: Naipes.values())
        {
            for(NumerosCartas numero: NumerosCartas.values())
            {
                baralho.add(new Cartas(naipe,numero,numero.getValor())) ;
            }
        }
        Collections.shuffle(baralho);
    }
    
   
    
    public List<Cartas> getBaralho() {
        return baralho;
    }     

    public String getNome() {
        return nome;
    }
    public int getQuantidadeCartas(){
        return baralho.size();
    }
    public Cartas getCarta(){
        return baralho.remove(0);
    }
    
    
    
}
