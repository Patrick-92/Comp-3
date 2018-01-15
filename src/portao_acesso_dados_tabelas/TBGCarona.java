package portao_acesso_dados_tabelas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import modelo.Carona;

public class TBGCarona {
	private static Connection connection;

	public TBGCarona() {
		try {
			connection = (Connection) new Conexao().getConnection();
			System.out.println("Conexão aberta!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Carona incluirCarona(int idVeiculo, String data, String hora, int idLogradouroOrigem, int idLogradouroDestino,
			int idMotorista, int idGrupo) {

		Carona carona = new Carona();
		
		String sql = "insert into carona" + "(idveiculo, data, idlogradouroorigem, idlogradourodestino, idmotorista, hora, idgrupo)"
				+ " values (?,?,?,?,?,?,?)";

		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// seta os valores
			stmt.setInt(1, idVeiculo);
			stmt.setString(2, data);
			stmt.setInt(3, idLogradouroOrigem);
			stmt.setInt(4, idLogradouroDestino);
			stmt.setInt(5, idMotorista);
			stmt.setString(6, hora);
			stmt.setInt(7, idGrupo);
			// executa
			stmt.executeUpdate();
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				carona.setId(generatedKeys.getInt(1));
			}
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return carona;
	}

	public ArrayList<Carona> LerCaronas(int idMotorista, int idGrupo) {

		ArrayList<Carona> lista = new ArrayList<Carona>();

		String sql = "SELECT * FROM carona WHERE idmotorista = ? and  idmotorista <> '0' and idgrupo = ?";

		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, idMotorista);
			stmt.setInt(2, idGrupo);
			// executa
			ResultSet rs = stmt.executeQuery();
			// armazena
			while (rs.next()) {
				Carona carona = new Carona(rs.getString("data"), rs.getString("hora"), rs.getInt("idmotorista"),
						rs.getInt("idlogradouroorigem"), rs.getInt("idlogradourodestino"));
				carona.setId(rs.getInt("id"));
				lista.add(carona);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return lista;
	}
	
	public static void alterarCarona (int idVeiculo, int idLogradouroOrigem, int idLogradouroDestino, int idCarona){
		
		String sql = "update carona set idveiculo = ?, idlogradouroorigem= ?, idlogradourodestino=? where id = ?";
		
		//prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// seta os valores
			stmt.setInt(1,idVeiculo);
			stmt.setInt(2,idLogradouroOrigem);
			stmt.setInt(3,idLogradouroDestino);
			stmt.setInt(4,idCarona);

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}

	public Carona lerCarona(int idCarona) {

		Carona carona = new Carona();

		String sql = "SELECT * FROM carona WHERE id = ?";

		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, idCarona);
			// executa
			ResultSet rs = stmt.executeQuery();
			// armazena
			while (rs.next()) {
				Carona caronaTemp = new Carona(rs.getString("data"), rs.getString("hora"), rs.getInt("idmotorista"),
						rs.getInt("idlogradouroorigem"), rs.getInt("idlogradourodestino"));
				carona.setId(rs.getInt("id"));
				carona = caronaTemp;
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return carona;
	}

	public ArrayList<Carona> lerTodasCaronas() {

		ArrayList<Carona> caronas = new ArrayList<Carona>();

		String sql = "SELECT * FROM carona ";

		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// executa
			ResultSet rs = stmt.executeQuery();
			// armazena
			while (rs.next()) {
				Carona caronaTemp = new Carona(rs.getString("data"), rs.getString("hora"), rs.getInt("idmotorista"),
						rs.getInt("idlogradouroorigem"), rs.getInt("idlogradourodestino"));
				caronaTemp.setId(rs.getInt("id"));
				caronas.add(caronaTemp);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return caronas;
	}

	public void cancelarCarona (int idCarona){
		
		String sql = "update carona set idmotorista = '0' where id = ?";
		
		//prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// seta os valores
			stmt.setInt(1,idCarona);

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
	
	public ArrayList<Carona> LerCaronas(int idMotorista) {

		ArrayList<Carona> lista = new ArrayList<Carona>();

		String sql = "SELECT * FROM carona WHERE idmotorista = ? and  idmotorista <> '0'";

		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, idMotorista);
			// executa
			ResultSet rs = stmt.executeQuery();
			// armazena
			while (rs.next()) {
				Carona carona = new Carona(rs.getString("data"), rs.getString("hora"), rs.getInt("idmotorista"),
						rs.getInt("idlogradouroorigem"), rs.getInt("idlogradourodestino"));
				carona.setId(rs.getInt("id"));
				lista.add(carona);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return lista;
	}
}
