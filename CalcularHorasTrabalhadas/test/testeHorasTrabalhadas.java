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
        /*1*/assertEquals(4.00, c.calculaHoras(8.00, 12.00), 0);
        /*2*/assertEquals(5.00, c.calculaHoras(13.00, 18.00), 0);
        /*3*/assertEquals(11.50, c.calculaHoras(8.00, 18.00), 0);
        /*4*/assertEquals(5.50, c.calculaHoras(14.00, 19.00), 0);
        /*5*/assertEquals(7.00, c.calculaHoras(6.00, 12.00), 0);
        /*6*/assertEquals(9.50, c.calculaHoras(6.00, 13.00), 0);
        /*7*/assertEquals(9.00, c.calculaHoras(17.00, 23.00), 0);
        /*8*/assertEquals(17.50, c.calculaHoras(00.00, 09.00), 0);

    }
    
}
