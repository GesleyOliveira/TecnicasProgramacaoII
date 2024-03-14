/*import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;*/
import org.junit.Test;
import static org.junit.Assert.*;
//import HorasTrabalhadas.CalcularHorasTrabalhadas;
import HorasTrabalhadas.CalcularHorasTrabalhadas2;


public class testeHorasTrabalhadas {
    CalcularHorasTrabalhadas2 HT;
    
       

    
    @Test
    public void receberHorasTrabalhadasExibirCalculo2(){
        HT = new CalcularHorasTrabalhadas2(); 
        /*1*/assertEquals(4.0f, HT.calcularHT(8.0f, 12.0f), 0);
        /*2*/assertEquals(5.0f, HT.calcularHT(13.0f, 18.0f), 0);
        /*3*/assertEquals(11.5f, HT.calcularHT(8.0f, 18.0f), 0);
        /*4*/assertEquals(5.5f, HT.calcularHT(14.0f, 19.0f), 0);
        /*5*/assertEquals(7.0f, HT.calcularHT(6.0f, 12.0f), 0);
        /*6*/assertEquals(9.5f, HT.calcularHT(6.0f, 13.0f), 0);
        /*7*/assertEquals(9.0f, HT.calcularHT(17.0f, 23.0f), 0);
        /*8*/assertEquals(17.5f, HT.calcularHT(0.0f, 09.0f), 0);
    }
    
}
