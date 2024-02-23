package HorasTrabalhadas;

public class CalcularHorasTrabalhadas{
    int horaTotal = 0;

    public int calculaHoras(int horaInicio, int diaInicio, int horaFim, int diaFim) {
        horaTotal = horaFim - horaInicio;
        return horaTotal;
    }
    
}
