package HorasTrabalhadas;

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
