package Model.EstacionamentoDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Classes.Veiculo;

public class VeiculoDAO {
    
    private Connection connection;
    
    public VeiculoDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String DATABASE_URL = "jdbc:derby://localhost:1527/bdestacionamento";
            String usuario = "APP";
            String senha = "123";
            this.connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Veiculo> listar() {
        String sql = "SELECT * FROM Veiculo";
        List<Veiculo> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Veiculo Veiculo = new Veiculo();
                Veiculo.setNome(resultado.getString("nome"));
                Veiculo.setPlaca(resultado.getString("placa"));
                Veiculo.setTipo(resultado.getString("tipo"));
                retorno.add(Veiculo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public boolean inserir(Veiculo veiculo) {
        String sql = "INSERT INTO Veiculo(nome, placa, tipo) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, veiculo.getNome());
            stmt.setString(2, veiculo.getPlaca());
            stmt.setString(3, veiculo.getTipo());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Veiculo Veiculo) {
        String sql = "UPDATE Veiculo SET nome=?, placa=?, tipo=? WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, Veiculo.getNome());
            stmt.setString(2, Veiculo.getPlaca());
            stmt.setString(3, Veiculo.getTipo());
            stmt.setInt(4, Veiculo.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Integer id) {
        String sql = "DELETE FROM Veiculo WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
