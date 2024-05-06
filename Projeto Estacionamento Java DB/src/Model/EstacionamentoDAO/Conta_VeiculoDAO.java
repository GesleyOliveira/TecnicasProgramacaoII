/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.EstacionamentoDAO;

import Model.Classes.ContaVeiculo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alunos
 */
public class Conta_VeiculoDAO {
    private Connection connection;
    
    public Conta_VeiculoDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String DATABASE_URL = "jdbc:derby://localhost:1527/bdestacionamento";
            String usuario = "APP";
            String senha = "123";
            this.connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conta_VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<ContaVeiculo> listar() {
        String sql = "SELECT * FROM CONTA_VEICULO";
        List<ContaVeiculo> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                ContaVeiculo contaveiculo = new ContaVeiculo();
                contaveiculo.setId(resultado.getInt("id"));
                contaveiculo.setPlaca_veiculo(resultado.getString("placa_veiculo"));
                contaveiculo.setData_entrada((Calendar) resultado.getObject("data_entrada"));
                contaveiculo.setData_saida((Calendar) resultado.getObject("data_saida"));
                retorno.add(contaveiculo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conta_VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public boolean inserir(ContaVeiculo conta) {
        String sql = "INSERT INTO Conta_Veiculo(id, placa_Veiculo, data_entrada, data_saida) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, conta.getId());
            stmt.setString(2, conta.getPlaca_veiculo());
            stmt.setString(3, conta.getData_entrada().toString());
            stmt.setString(4, conta.getData_saida().toString());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conta_VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(ContaVeiculo conta) {
        String sql = "UPDATE Conta_Veiculo SET placa_Veiculo=?, data_entrada=?, data_saida=? WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, conta.getPlaca_veiculo());
            stmt.setObject(2, conta.getData_entrada());
            stmt.setObject(3, conta.getData_saida());
            stmt.setInt(4, conta.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conta_VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Integer id) {
        String sql = "DELETE FROM Conta_Veiculo WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conta_VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
