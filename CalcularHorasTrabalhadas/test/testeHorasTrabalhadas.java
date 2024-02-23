import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import HorasTrabalhadas.CalcularHorasTrabalhadas;


public class testeHorasTrabalhadas {
    CalcularHorasTrabalhadas c;
    
       
    @Test
    public void receberHorasTrabalhadasExibirCalculo(){
        c = new CalcularHorasTrabalhadas();
        assertEquals(7, c.calculaHoras(1, 22, 8, 22));
    }
    
}
