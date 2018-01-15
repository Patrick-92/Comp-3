package portao_acesso_dados_tabelas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection getConnection() throws ClassNotFoundException {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/aacomp3", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
