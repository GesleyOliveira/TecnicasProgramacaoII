package HorasTrabalhadas;
import java.util.Calendar;
//import java.text.DateFormat;
//import java.util.Date;

public class CalcularHorasTrabalhadas2 {

    public float calcularHT(float inicio, float fim){
        float horasTrabalhadas = 0;
        //Date data = new Date();
        Calendar calendario = Calendar.getInstance();
        Calendar calendario2 = Calendar.getInstance();
        
        calendario.set(2024, 03, 07, 8, 20);
        calendario2.set(2024, 03, 07, 5, 20);
        
        System.out.println("Hora:" + (calendario.getTimeInMillis() - calendario2.getTimeInMillis())/1000/60/60);
        
        //private long calcularDiaHoraTrabalhada()
        
        
        //Adicional da Hora do almoço
        // Se a jornada trabalhada ultrapassar 6 horas, adicione 1.5h
        if(fim - inicio > 6){
            horasTrabalhadas += 1.5;
        }
        
        //Para o intervalo entre as 08h e 18h
        horasTrabalhadas += calculaIntervalo(inicio, fim, 0.00f, 6.00f) * 2.0f;
        horasTrabalhadas += calculaIntervalo(inicio, fim, 6.00f, 8.00f) * 1.5f;
        horasTrabalhadas += calculaIntervalo(inicio, fim, 8.00f, 18.00f) * 1.0f;
        horasTrabalhadas += calculaIntervalo(inicio, fim, 18.00f, 22.00f) * 1.5f;
        horasTrabalhadas += calculaIntervalo(inicio, fim, 22.00f, 24.00f) * 2.0f;
 
        return horasTrabalhadas;
    }
        
    private float calculaIntervalo(float inicioPeriodo, float fimPeriodo, float inicioIntervalo, float fimIntervalo){
        //O método deve calcular a quantidade de horas entre incio e sim dentro da jornada
            
        if(inicioPeriodo < fimIntervalo && fimPeriodo > inicioIntervalo){
            //Periodo está contido dentro do intervalo
            if(inicioPeriodo < inicioIntervalo){
                inicioPeriodo = inicioIntervalo;
            } if (fimPeriodo > fimIntervalo){
                fimPeriodo = fimIntervalo;
            }
            return (fimPeriodo - inicioPeriodo > 0)? fimPeriodo - inicioPeriodo:0;
        } else {
        //Não está dentro do intervalo
                
        return 0;
        }
        
        public float calculaHora(Calendar )
            
    }
}
    
