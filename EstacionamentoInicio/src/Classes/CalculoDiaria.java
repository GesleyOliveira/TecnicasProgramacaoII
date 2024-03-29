package Classes;


public class CalculoDiaria implements CalculoValor {
    
    private final double valorDiaria;
    
    public CalculoDiaria(double valorDiaria){
        this.valorDiaria = valorDiaria;
    }
    
    public double calcular(float periodo, Veiculo HORA){
        return valorDiaria * Math.ceil(periodo / HORA);
    }
}
