package HorasTrabalhadas;

public class CalcularHorasTrabalhadas {

    public float calcularHT(float inicio, float fim){
        float horasTrabalhadas = 0;
        
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
            
    }
}

/*package HorasTrabalhadas;

public class CalcularHorasTrabalhadas{
    double horaTotal = 0;
    double horaExtra = 0;
    double depoisDasDez = 0;
    double aux = 0;

    public double calculaHoras(double horaInicio, double horaFim) {
        horaTotal = horaFim - horaInicio;
        if(horaTotal > 6){
            horaTotal += 1.5;
        } if (horaFim > 18 && horaFim < 22){
            horaExtra = horaFim - 18;
            horaTotal = horaTotal - horaExtra;
            horaTotal += horaExtra * 1.5;
        } if (horaFim > 18 && horaFim > 22 && horaInicio < 18){
            horaTotal = 18 - horaInicio;
            depoisDasDez = (horaFim - 22) * 2;
            horaTotal += depoisDasDez + 6;
        } if (horaInicio < 8){
            horaExtra = (8 - horaInicio) * 0.5;
            horaTotal += horaExtra;  
        } if (horaFim < 8 && horaFim > 6){
            aux = 8 - horaFim;
            horaTotal = horaTotal - aux;
            horaExtra = aux * 2;
            horaTotal = horaTotal + horaExtra;
        } if (horaFim < 8 && horaInicio > 0){
            horaTotal = horaTotal * 2;
        }
        
        return horaTotal;
    }
    
}
*/