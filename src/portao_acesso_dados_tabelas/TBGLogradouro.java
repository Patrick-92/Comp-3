package portao_acesso_dados_tabelas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import modelo.Logradouro;

public class TBGLogradouro {
	public int id;
	public String cep;
	public String estado;
	public String cidade;
	public String distrito;
	public String endereco;
	public int numero;
	
	private static Connection connection;
	
	public TBGLogradouro() {
		try {
			connection = (Connection) new Conexao().getConnection();
			System.out.println("Conexão aberta!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public TBGLogradouro incluirLogradouro (String cep, String estado, String cidade, 
			String distrito, String endereco, int numero){
		
		TBGLogradouro dados = new TBGLogradouro();
		
		String sql = "insert into logradouro" +
				"(cep, estado, cidade, distrito, endereco, numero)" +
				" values (?,?,?,?,?,?)";
		
		//prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// seta os valores
			stmt.setString(1,cep);
			stmt.setString(2,estado);
			stmt.setString(3,cidade);
			stmt.setString(4,distrito);
			stmt.setString(5,endereco);
			stmt.setInt(6,numero);
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

	public ArrayList<Logradouro> listarTodoLogradouro (){

		ArrayList<Logradouro> lista = new ArrayList<Logradouro>();

		String sql = "SELECT * FROM logradouro";

		// prepared statement para inserção
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			// executa
			ResultSet rs = stmt.executeQuery();
			// armazena
			while (rs.next()) {
				Logradouro logradouro = new Logradouro(rs.getString("cep"), rs.getString("estado"),
						rs.getString("cidade"), rs.getString("distrito"), rs.getString("endereco"),
						rs.getInt("numero"), rs.getInt("id"));
				lista.add(logradouro);
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
