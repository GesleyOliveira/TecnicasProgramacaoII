package Classes;


public class ContaEstacionamento {
    
    private CalculoValor calculo;
    
    private String veiculo;
    private long inicio, fim;

    public ContaEstacionamento(long inicio, long fim, String veiculo) {
        this.inicio = inicio;
        this.fim = fim;
        this.veiculo = veiculo;
    }
    
    public double valorConta(){
        return calculo.calcular(fim - inicio, veiculo); 
    }
    
    public void setCalculo(CalculoValor calculo){
        this.calculo = calculo;
    }
}
