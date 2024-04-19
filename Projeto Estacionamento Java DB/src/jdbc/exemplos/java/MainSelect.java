package jdbc.exemplos.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Classes.Veiculo;

public class MainSelect {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        String DATABASE_URL = "jdbc:derby://localhost:1527/bdestacionamento";
        String usuario = "APP";
        String senha = "123";
        
        Connection connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
        
        String sql = "SELECT * FROM Veiculo";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            Veiculo Veiculo = new Veiculo();
            Veiculo.setNome(rs.getString("nome"));
            Veiculo.setPlaca(rs.getString("placa"));
            Veiculo.setTipo(rs.getString("tipo"));
            System.out.println(Veiculo);
        }
    }
}
