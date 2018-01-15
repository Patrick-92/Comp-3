package portao_acesso_dados_tabelas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class TBGGrupoUsuario {
	public int id;
	public int idGrupo;
	public int idUsuario;

	private static Connection connection;

	public TBGGrupoUsuario() {
		try {
			connection = (Connection) new Conexao().getConnection();
			System.out.println("Conexão aberta!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void incluirGrupoUsuario(int idGrupo, int idUsuario) {

		String sql = "insert into grupousuario" + "(idgrupo, idusuario)" + " values (?,?)";

		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// seta os valores
			stmt.setInt(1, idGrupo);
			stmt.setInt(2, idUsuario);
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

	public ArrayList<Integer> lerGrupoUsuario(int idUsuario) {

		ArrayList<Integer> lista = new ArrayList<Integer>();

		String sql = "SELECT idgrupo FROM grupousuario WHERE idusuario = ?";

		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, idUsuario);
			// executa
			ResultSet rs = stmt.executeQuery();
			// armazena
			while (rs.next()) {
				Integer id = rs.getInt("idgrupo");
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

	public ArrayList<Integer> lerUsuarioGrupo(int idGrupo) {

		ArrayList<Integer> lista = new ArrayList<Integer>();

		String sql = "SELECT idusuario FROM grupousuario WHERE idgrupo = ?";

		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, idGrupo);
			// executa
			ResultSet rs = stmt.executeQuery();
			// armazena
			while (rs.next()) {
				Integer id = rs.getInt("idusuario");
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

	public void inativarGrupo(int idGrupo) {

		String sql = "delete from grupousuario where idgrupo = ?";

		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// seta os valores
			stmt.setInt(1, idGrupo);

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public void sairGrupo(int idUsuario, int idGrupo) {

		// if(cozinha == null) return;

		String sql = "delete from grupousuario where idgrupo = ? and idusuario = ?";

		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// seta os valores
			stmt.setInt(1, idUsuario);
			stmt.setInt(2, idGrupo);

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
