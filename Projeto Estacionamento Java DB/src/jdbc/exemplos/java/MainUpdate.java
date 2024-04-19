package jdbc.exemplos.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Model.Classes.Veiculo;

public class MainUpdate {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        String DATABASE_URL = "jdbc:derby://localhost:1527/bdestacionamento";
        String usuario = "APP";
        String senha = "123";
        
        Connection connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
        
        String sql = "UPDATE Veiculo SET nome=?, tipo=? WHERE placa=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        
        Veiculo Veiculo = new Veiculo("Gesley3", "EEA5489", "Passeio");
        
        ps.setString(1, Veiculo.getNome());
        ps.setString(2, Veiculo.getPlaca());
        ps.setString(3, Veiculo.getTipo());
        ps.execute();
    }
}
