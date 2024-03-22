

import Classes.ContaEstacionamento;
import Classes.CalculoDiaria;
import Classes.CalculoHorista;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alunos
 */
public class TesteEstacionamento {
    
    public TesteEstacionamento() {
    @Test
    public void calculoDiaria(){        
        Calendar inicio = Calendar.getInstance();
        inicio.set(2024, 3, 17);
        Calendar fim = Calendar.getInstance();
        fim.set(2024, 3, 18);
        
        ContaEstacionamento conta=new ContaEstacionamento(inicio.getTimeInMillis(), fim.getTimeInMillis() ,"Corolla");
        CalculoDiaria tipo = new CalculoDiaria(50);
        
        conta.setCalculo(tipo);
        assertEquals(50,conta.valorConta());        
    }
    
    @Test
    public void calculoHorista(){        
        Calendar inicio = Calendar.getInstance();
        inicio.set(2024, 3, 17);
        Calendar fim = Calendar.getInstance();
        fim.set(2024, 3, 18);
        
        ContaEstacionamento conta=new ContaEstacionamento(inicio.getTimeInMillis(), fim.getTimeInMillis() ,"Corolla");
        CalculoHorista tipo = new CalculoHorista(4);        
        conta.setCalculo(tipo);
        assertEquals(4*24,conta.valorConta());        
    }
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
}
