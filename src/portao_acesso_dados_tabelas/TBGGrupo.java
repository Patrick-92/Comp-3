package portao_acesso_dados_tabelas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import modelo.Grupo;

public class TBGGrupo {
	public int id;
	public String nome;
	public String descricao;
	public String regras;
	public int limite;
	public int idUsuarioCriador;

	private static Connection connection;

	public TBGGrupo() {
		try {
			connection = (Connection) new Conexao().getConnection();
			System.out.println("Conexão aberta!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public TBGGrupo incluirGrupo(String nome, String descricao, String regras, int limite, int idUsuarioCriador) {

		TBGGrupo dados = new TBGGrupo();

		String sql = "insert into grupo" + "(nome, descricao, regras, limite, idusuariocriador)"
				+ " values (?,?,?,?,?)";

		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// seta os valores
			stmt.setString(1, nome);
			stmt.setString(2, descricao);
			stmt.setString(3, regras);
			stmt.setInt(4, limite);
			stmt.setInt(5, idUsuarioCriador);
			// executa
			stmt.executeUpdate();
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			dados.id = -1;
			if (generatedKeys.next()) {
				dados.id = generatedKeys.getInt(1);
			}
			stmt.close();
			return dados;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public ArrayList<Grupo> lerGrupos(ArrayList<Integer> idGrupos) {

		ArrayList<Grupo> lista = new ArrayList<Grupo>();

		String sql = "SELECT * FROM grupo WHERE id = ?";

		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			for (Integer grupos : idGrupos) {
				stmt = (PreparedStatement) connection.prepareStatement(sql);
				stmt.setInt(1, grupos);
				// executa
				ResultSet rs = stmt.executeQuery();
				// armazena
				while (rs.next()) {
					Grupo grupo = new Grupo(rs.getString("nome"), rs.getString("descricao"), rs.getString("regras"),
							rs.getInt("limite"), rs.getInt("idusuariocriador"));
					grupo.setId(rs.getInt("id"));
					lista.add(grupo);
				}
				rs.close();
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return lista;
	}

	public void alterarGrupo(String nome, String descricao, int limite, int id) {
		String sql = "update grupo set nome = ?, descricao = ?, limite = ? where id = ?";

		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, nome);
			stmt.setString(2, descricao);
			stmt.setInt(3, limite);
			stmt.setInt(4, id);

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
