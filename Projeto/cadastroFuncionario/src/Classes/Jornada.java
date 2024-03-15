package Classes;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Jornada {
    
   private List<Periodo> lista ;
   Calendar inicioJornada;
   Calendar fimJornada;
   
   public Jornada(Calendar inicioJornada, Calendar fimJornada){
       lista = new ArrayList<>();
       this.inicioJornada = inicioJornada;
       this.fimJornada = fimJornada;
   }
   
   
    
}
