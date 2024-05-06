
package Controller;

import Model.DAO.*;
import Model.Estacionamento.*;
import Model.EstacionamentoDAO.VeiculoDAO;
import View.TelaPrincipal.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Controlador {
    
    private List<Conta_Veiculo> listaVeiculos;
    //private List<VeiculoEstacionado> listaVeiculos;
    private Thread t0,t1;
    private PersistenciaDados DAO;
    
    public Controlador(){
        listaVeiculos=new ArrayList<Conta_Veiculo>();  
        DAO=new PersistenciaDados();
    }
    
    public void addContaVeiculo(String nome, String placa, TipoVeiculoEnum tipo)throws Exception{
        listaVeiculos.add(new Conta_Veiculo(Calendar.getInstance().getTimeInMillis() - (1000 * 60 * 60 * 2), new Veiculo(nome, placa, tipo)));
    }
    
    public String[][] listaVeiculosCadastrados() throws Exception{
        
        String[][] aux=new String[listaVeiculos.size()][6];
        Conta_Veiculo conta;
        Date dataAux;
        for(int i=0;i<listaVeiculos.size();i++){
            conta=(Conta_Veiculo) listaVeiculos.get(i);
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
    
    public void finalizarConta(String placaVeiculo) throws Exception{
        //Finaliza a conta, utilizando a metrica de calculo recebida como parametro.
        // Se a metrica for AUTOMATICO, o sistema deverá verificar a opção mais barata e utiliza-la
        
        //Altera o status para fechado e salva o registro.
        //Se valor da conta for zero retorna um erro.
        
        //Se não for possivel registra no BD, salve um backup local da listaVeiculos;
        //Utilize o objeto DAO
        int aux =  0;
        for(int i=0; i < listaVeiculos.size(); i++){
            if (listaVeiculos.get(i).getVeiculo().getPlaca() == placaVeiculo){
                aux = i;
            }         
        }
        
        listaVeiculos.get(aux).setStatus(StatusConta.FECHADO);
        listaVeiculos.get(aux).setFim(Calendar.getInstance().getTimeInMillis());
        
        
    }

    public String calculaPermanencia(String placa) {
        long retornoPermanencia = 0;
        String valor = "";
        for (int i = 0; i < listaVeiculos.size(); i++) {
            if (placa.equals(listaVeiculos.get(i).getVeiculo().getPlaca())) {
                double tempoPermanenciaMinutos = (Calendar.getInstance().getTimeInMillis() - listaVeiculos.get(i).getInicio()) / 60000;
                return Double.toString(tempoPermanenciaMinutos); 
            }
        }
        return "Veículo não encontrado"; 
    }
    
      public List carregarPlacas(){
        List<String> placas = new ArrayList<String>();
       for(int i = 0; i < listaVeiculos.size(); i++){
       placas.add(listaVeiculos.get(i).getVeiculo().getPlaca());
       }
        return placas;
    }
    
    public String calcularValor(MetricaCalculoEnum metrica, String placa) {

        String mensagem = "";
        int aux =  0;
        for(int i=0; i < listaVeiculos.size(); i++){
            if (listaVeiculos.get(i).getVeiculo().getPlaca() == placa){
                aux = i;
            }         
        }
        long periodo = Calendar.getInstance().getTimeInMillis() - listaVeiculos.get(aux).getInicio();

        if (metrica == MetricaCalculoEnum.UM_QUARTO_HORA) {
            Calculo15Minutos calculo = new Calculo15Minutos();
            mensagem += calculo.calcular(periodo, listaVeiculos.get(aux).getVeiculo());
        } else if (metrica == MetricaCalculoEnum.HORA) {
            CalculoHorista calculo = new CalculoHorista();
            mensagem += calculo.calcular(periodo, listaVeiculos.get(aux).getVeiculo());
        } else if (metrica == MetricaCalculoEnum.DIARIA) {
            CalculoDiaria calculo = new CalculoDiaria();
            mensagem += calculo.calcular(periodo, listaVeiculos.get(aux).getVeiculo());
        } else {
            double hora = periodo / 3600000;
            if(hora<1){
                return calcularValor(MetricaCalculoEnum.UM_QUARTO_HORA, placa);
            } else if (hora>1 && hora < 12){
                return calcularValor(MetricaCalculoEnum.HORA, placa);
            } else {
                return calcularValor(MetricaCalculoEnum.DIARIA, placa);
            }
        }
        
        return mensagem;
        }  
    
    public void salvar(){
        
        VeiculoDAO veiculo = new VeiculoDAO();
        veiculo.inserir(listaVeiculos.get(0).getVeiculo());
        
        /*     *****  Para usar em salvar Offline  *****
        PersistenciaDados salvar = new PersistenciaDados();
        try{
        salvar.salvarBackupLocal(listaVeiculos);
        }catch(Exception e){
        }*/
    }
    public void carregar(){
    PersistenciaDados carregar = new PersistenciaDados();
    try{
        listaVeiculos = carregar.carregarBackup();
        }catch(Exception e){
        }
    }
        
}



    
    /*
            
    public String calculaValor(long ){
        
      
        
    }
    
   */
    

