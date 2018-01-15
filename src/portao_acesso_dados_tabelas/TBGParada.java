package portao_acesso_dados_tabelas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import modelo.Parada;

public class TBGParada {
	private static Connection connection;

	public TBGParada() {
		try {
			connection = (Connection) new Conexao().getConnection();
			System.out.println("Conexão aberta!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void incluirParada(int idUsuario, int idLogradouro , int idCarona) {

		String sql = "insert into parada" + "(idusuario, idlogradouro, idcarona)"
				+ " values (?,?,?)";

		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// seta os valores
			stmt.setInt(1, idUsuario);
			stmt.setInt(2, idLogradouro);
			stmt.setInt(3, idCarona);
			// executa
			stmt.executeUpdate();
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			int id = -1;
			if (generatedKeys.next()) {
				id = generatedKeys.getInt(1);
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Integer> LerParadasPorId(int idCarona) {

		ArrayList<Integer> lista = new ArrayList<Integer>();

		String sql = "SELECT idusuario FROM parada WHERE idcarona = ?";

		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, idCarona);
			// executa
			ResultSet rs = stmt.executeQuery();
			// armazena
			while (rs.next()) {
				int id = rs.getInt("idusuario");
				lista.add(id);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return lista;
	}

	public ArrayList<Parada> LerParadas(int idUsuario) {

		ArrayList<Parada> lista = new ArrayList<Parada>();

		String sql = "SELECT * FROM parada WHERE idUsuario = ?";

		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, idUsuario);
			// executa
			ResultSet rs = stmt.executeQuery();
			// armazena
			while (rs.next()) {
				Parada parada = new Parada(rs.getInt("idusuario"), rs.getInt("idlogradouro"), rs.getInt("idcarona"));
				lista.add(parada);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return lista;
	}

	public void cancelarParada (int idUsuario){
		
		String sql = "DELETE FROM parada WHERE idUsuario = ?";

		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, idUsuario);
			// executa
			stmt.execute();
			
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public void cancelarParadas (int idCarona){
		
		String sql = "update carona set idusuario = '0' where idcarona = ?";
		
		//prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// seta os valores
			stmt.setInt(1,idCarona);
			ResultSet rs = stmt.executeQuery();
			// armazena
			while (rs.next()) {
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
}
