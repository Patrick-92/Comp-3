package portao_acesso_dados_tabelas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import modelo.Veiculo;

public class TBGVeiculo {
	protected int id;
	protected String modelo;
	protected String placa;
	protected String cor;
	protected int idMotorista;

	private static Connection connection;

	public TBGVeiculo() {
		try {
			connection = (Connection) new Conexao().getConnection();
			System.out.println("Conexão aberta!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void incluirVeiculo(String modelo, String placa, String cor, int idMotorista, int vagas) {

		

		String sql = "insert into veiculo" + "(modelo, placa, cor, idMotorista, vagas)" + " values (?,?,?,?,?)";

		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// seta os valores
			stmt.setString(1, modelo);
			stmt.setString(2, placa);
			stmt.setString(3, cor);
			stmt.setInt(4, idMotorista);
			stmt.setInt(5, vagas);
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

	public ArrayList<Veiculo> LerVeiculos(int idMotorista) {

		ArrayList<Veiculo> lista = new ArrayList<Veiculo>();

		String sql = "SELECT * FROM veiculo WHERE idmotorista = ?";

		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, idMotorista);
			// executa
			ResultSet rs = stmt.executeQuery();
			// armazena
			while (rs.next()) {
				Veiculo veiculo = new Veiculo(rs.getString("modelo"), rs.getString("placa"), rs.getString("cor"));
				veiculo.setId(rs.getInt("id"));
				lista.add(veiculo);
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return lista;
	}

	public void alterarVeiculo(String cor, int id) {

		String sql = "update veiculo set cor = ? where id = ?";

		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, cor);
			stmt.setInt(2, id);

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public Veiculo LerVeiculoVaga(int idVeiculo) {
		
		Veiculo veiculo = new Veiculo();

		String sql = "SELECT * FROM veiculo WHERE id = ?";

		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, idVeiculo);
			// executa
			ResultSet rs = stmt.executeQuery();
			// armazena
			while (rs.next()) {
				Veiculo veiculoTemp = new Veiculo(rs.getString("modelo"), rs.getString("placa"), 
rs.getInt("idmotorista"), rs.getString("cor"), rs.getInt("id") ,rs.getInt("vagas"));
				veiculo = veiculoTemp;
			}

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return veiculo;
	}
}
