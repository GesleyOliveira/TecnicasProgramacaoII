
package Model.DAO;

import Model.Estacionamento.Conta_Veiculo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class PersistenciaDados {
    
    private List<Conta_Veiculo> listaVeiculos;
    
    String caminhoPadrao= "C:\\Users\\Alunos\\Desktop\\estacionamento";
    int countBackup=0;
    public PersistenciaDados() {
    }
    
    public boolean criarNovoRegistro(Conta_Veiculo elemento){
        //Realiza o acesso ao BD e cria um novo registro do BD retornando True;
        //Senão for possivel registrar do BD retorna False.
        return false;
    }
    public boolean salvarBackupLocal(List<Conta_Veiculo> listaRegistros)throws Exception{
        //Cria um novo arquivo de backup da lista de registros de ContaEstacionamento       
        gravarBackup(caminhoPadrao + "backup"+ countBackup+".dat", listaRegistros);
        return false;
    }
    private void gravarBackup(String caminho, Object objeto) throws FileNotFoundException, IOException{        
        FileOutputStream outFile = new FileOutputStream(caminho);
        ObjectOutputStream s = new ObjectOutputStream(outFile);
        s.writeObject(objeto);
        s.close();
    }
    private Object lerBackup(String caminho) throws FileNotFoundException, IOException, ClassNotFoundException{        
        FileInputStream inFile = new FileInputStream(caminho);
        ObjectInputStream s = new ObjectInputStream(inFile);
        Object objeto = s.readObject();
        s.close();
        return objeto;
    }
    
    public List carregarBackup(){
        try{
        listaVeiculos = (List)lerBackup(caminhoPadrao + "backup"+ countBackup+".dat");
        }catch(Exception e){
        }
        return listaVeiculos;
    }
}
