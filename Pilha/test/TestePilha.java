import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestePilha {
    
    public static Pilha p;
    public static int tamanhoPilha = 10;
    
    //Método para inicializar a pilha
    @BeforeClass
    public void inicializaPilha(){
        p = new Pilha(tamanhoPilha);
    }
    
    //Método para empilhar um elemento na Pilha
    //A pilha irá trabalhar com Object
  
    
    @Test
    public void empilharUmObjeto(){
        assertTrue(p.vazia());
        p.empilha("Elemento 1");
        assertFalse(p.vazia());
        
    }
    
    @Test
    public void empilharDoisObjetoDesempilhaUmObjeto(){
        assertTrue(p.vazia());
        p.empilha("Elemento 1");
        p.empilha("Elemento 2");
        Object retorno = p.desempilha();
        assertEquals("Elemento 1", p.verificaTopo());
        assertFalse(p.vazia());
        
    }
    
    @Test
    public void empilharDezElemento(){
        assertTrue(p.vazia());
        for(int i=0; i<10; i++){
            p.empilha("Elemento " + i);
        }
        assertFalse(p.vazia());
        assertTrue(p.cheia());
    }

}
