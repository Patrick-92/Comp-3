package portao_acesso_dados_tabelas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import modelo.Usuario;

public class TBGUsuario {
	public int id;
	public String nome;
	public String email;
	public String telefone;
	public String senha;
	public int motorista = 2;
	
	private static Connection connection;
	
	public TBGUsuario() {
		try {
			connection = (Connection) new Conexao().getConnection();
			System.out.println("Conexão aberta!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Usuario incluirUsuario (String email, int status){
		
		Usuario dados = new Usuario();
		
		String sql = "insert into usuario" +
				"(email, status)" +
				" values (?,?)";
		
		//prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// seta os valores
			stmt.setString(1,email);
			stmt.setInt(2,status);
			// executa
			stmt.executeUpdate();
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			dados.setId(-1);
			if (generatedKeys.next()) {
				dados.setId(generatedKeys.getInt(1));
			}
			stmt.close();
			return dados;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public static TBGUsuario loginUsuario (String email, String senha){
		TBGUsuario dados = new TBGUsuario();
		
		String sql = "SELECT id, email, senha, motorista FROM usuario WHERE email=? and senha= ?";
		
		PreparedStatement stmt;
		
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
            stmt.setString(1, email);  
            stmt.setString(2, senha);  
			// executa
			ResultSet rs = stmt.executeQuery();
			// armazena
			while (rs.next()) {
				dados.id = rs.getInt("id");
				dados.motorista = rs.getInt("motorista");
			}
				
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return dados;
	}

	public static void alterarUsuario (String nome, String telefone, int id){
		
		String sql = "update usuario set nome = ?, telefone= ? where id = ?";
		
		//prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// seta os valores
			stmt.setString(1,nome);
			stmt.setString(2,telefone);
			stmt.setInt(3,id);			

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}

	public void alterarUsuarioMotorista (int id){
		
		String sql = "update usuario set motorista = ? where id = ?";
		
		//prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// seta os valores
			stmt.setInt(1,1);
			stmt.setInt(2,id);			

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}

	public ArrayList<Usuario> lerUsuarios(ArrayList<Integer> idUsuarios) {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		String sql = "SELECT * FROM usuario WHERE id = ?";

		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			for (Integer usuarios : idUsuarios) {
				stmt = (PreparedStatement) connection.prepareStatement(sql);
				stmt.setInt(1, usuarios);
				// executa
				ResultSet rs = stmt.executeQuery();
				// armazena
				while (rs.next()) {
					Usuario usuario = new Usuario(rs.getString("nome"), rs.getString("email"), 
							rs.getString("telefone"), rs.getInt("id")); 
					lista.add(usuario);
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

	public Usuario buscarUsuario (String email){
		
		Usuario usuario = new Usuario();
		
		String sql = "SELECT id, status FROM usuario WHERE email=?";
		
		PreparedStatement stmt;
		
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
            stmt.setString(1, email);    
			// executa
			ResultSet rs = stmt.executeQuery();
			// armazena
			while (rs.next()) {
				usuario.setId(rs.getInt("id"));
				usuario.setStatus(rs.getInt("status"));
			}
				
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return usuario;
	}

	public Usuario buscarUsuarioPorId (int idUsuario){
		
		Usuario usuario = new Usuario();
		
		String sql = "SELECT * FROM usuario WHERE id=?";
		
		PreparedStatement stmt;
		
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
            stmt.setInt(1, idUsuario);    
			// executa
			ResultSet rs = stmt.executeQuery();
			// armazena
			while (rs.next()) {
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setStatus(rs.getInt("status"));
			}
				
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return usuario;
	}

	public void alterarUsuario (String nome, String telefone, int id, String senha){
		
		String sql = "update usuario set nome = ?, telefone= ?, senha= ?, status= '1' where id = ?";
		
		//prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// seta os valores
			stmt.setString(1,nome);
			stmt.setString(2,telefone);
			stmt.setString(3,senha);
			stmt.setInt(4,id);

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
}
