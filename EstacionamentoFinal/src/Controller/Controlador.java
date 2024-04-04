
package Controller;

import Model.DAO.*;
import Model.Estacionamento.*;
import View.TelaPrincipal.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Controlador {
    
    private List<ContaVeiculo> listaVeiculos;
    //private List<VeiculoEstacionado> listaVeiculos;
    private Thread t0,t1;
    private PersistenciaDados DAO;
    
    public Controlador(){
        listaVeiculos=new ArrayList<ContaVeiculo>();  
        DAO=new PersistenciaDados();
    }
    
    public void addContaVeiculo(String nome, String placa, TipoVeiculoEnum tipo)throws Exception{
        listaVeiculos.add(new ContaVeiculo(Calendar.getInstance().getTimeInMillis(), new Veiculo(nome, placa, tipo)));
    }
    
    public String[][] listaVeiculosCadastrados() throws Exception{
        
        String[][] aux=new String[listaVeiculos.size()][6];
        ContaVeiculo conta;
        Date dataAux;
        for(int i=0;i<listaVeiculos.size();i++){
            conta=(ContaVeiculo) listaVeiculos.get(i);
            aux[i][0]=conta.getVeiculo().getNome();
            aux[i][1]=conta.getVeiculo().getPlaca();
            aux[i][2]=conta.getVeiculo().getTipo().toString();
            dataAux=new Date(conta.getInicio());
            aux[i][3]= dataAux.toString();
            dataAux=new Date(conta.getFim());
            aux[i][4]= dataAux.toString();
            aux[i][5]=conta.getStatus().toString();
        }
        return aux;
        
    }
    
    public void finalizarConta(String placaVeiculo,MetricaCalculoEnum metrica) throws Exception{
        //Finaliza a conta, utilizando a metrica de calculo recebida como paramentro.
        // Se a metrica for AUTOMATICO, o sistema deverá verificar a opção mais barata e utiliza-la
        
        // Altera o status para fechado e salva o registro.
        //Se valor da conta for zero retorna um erro.
        
        //Se não for possivel registra no BD, salve um backup local da listaVeiculos;
        //Utilize o objeto DAO
    }
    
    /*public String calculaPermanencia(String placa){
        long retornoPermanencia = 0;
        for(int i=0;i<listaVeiculos.size();i++){
            if(placa.equals(listaVeiculos.get(i).getVeiculo().getPlaca())){
                retornoPermanencia = (Calendar.getInstance().getTimeInMillis() - listaVeiculos.get(i).getInicio()) / 60000;
            }
        }
        return retornoPermanencia + " minutos";
    }*/
   // Método para calcular a permanência do veículo e retornar o valor do estacionamento
    public String calculaPermanencia(String placa, String metricaSelecionada) {
        long retornoPermanencia = 0;
        for (int i = 0; i < listaVeiculos.size(); i++) {
            if (placa.equals(listaVeiculos.get(i).getVeiculo().getPlaca())) {
                long tempoPermanenciaMinutos = (Calendar.getInstance().getTimeInMillis() - listaVeiculos.get(i).getInicio()) / 60000;
                // Calcula o valor do estacionamento com base na métrica selecionada
                double valorEstacionamento = calcularValorEstacionamento(tempoPermanenciaMinutos, metricaSelecionada);
                return valorEstacionamento + " reais"; // Ajuste conforme necessário
            }
        }
        return "Veículo não encontrado"; // Se o veículo não estiver na lista
    }
    
    private double calcularValorEstacionamento(long tempoPermanenciaMinutos, String metricaSelecionada) {
        // Implemente a lógica para calcular o valor do estacionamento com base na métrica selecionada
        double valor = 0.0;
        // Aqui você deve implementar o cálculo do valor do estacionamento de acordo com a métrica selecionada
        // Exemplo:
        // if (metricaSelecionada.equals("Métrica1")) {
        //     valor = ...; // Cálculo para a métrica 1
        // } else if (metricaSelecionada.equals("Métrica2")) {
        //     valor = ...; // Cálculo para a métrica 2
        // } e assim por diante...
        return valor;
    }
}

    
    /*
            
    public String calculaValor(long ){
        
      
        
    }
    
   */
    

