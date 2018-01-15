package modelo;

import java.util.ArrayList;

public class Usuario {
	protected String nome;
	protected String email;
	protected String telefone;
	protected ArrayList<Grupo> grupos;
	protected ArrayList<Parada> paradas;
	protected ArrayList<Avaliacao> avaliacoes;
	protected String senha;
	protected int id;
	protected int idGrupo;
	protected int status; 

	public Usuario(String nome, String email, String telefone, ArrayList<Grupo> grupos, ArrayList<Parada> paradas,
			ArrayList<Avaliacao> avaliacoes, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.grupos = grupos;
		this.paradas = paradas;
		this.avaliacoes = avaliacoes;
		this.senha = senha;
	}
	
	public Usuario(String nome, String email, String telefone, int id) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.id = id;
	}

	public Usuario(String email) {
		super();
		this.email = email;
	}

	public Usuario(int id) {
		this.id = id;
	}

	public Usuario(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public ArrayList<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(ArrayList<Grupo> grupos) {
		this.grupos = grupos;
	}

	public ArrayList<Parada> getParadas() {
		return paradas;
	}

	public void setParadas(ArrayList<Parada> paradas) {
		this.paradas = paradas;
	}

	public ArrayList<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}	
	
	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
