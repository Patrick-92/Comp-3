package modelo;

import java.util.ArrayList;

public class Grupo {
	protected int id;
	protected String nome;
	protected String descricao;
	protected String regras;
	protected int limite;
	protected int idUsuarioCriador;
	public ArrayList<Usuario> participantes;
	
	public Grupo(String nome, String descricao, String regras, int limite, int idUsuarioCriador) {
		this.nome = nome;
		this.descricao = descricao;
		this.regras = regras;
		this.limite = limite;
		this.idUsuarioCriador = idUsuarioCriador;
	}
	
	public Grupo(int id, String nome, String descricao, String regras, int limite) {
		this.nome = nome;
		this.descricao = descricao;
		this.regras = regras;
		this.limite = limite;
		this.id = id;
	}
	
	public Grupo (int id){
		this.id = id;
	}
	
	public int getIdUsuarioCriador() {
		return idUsuarioCriador;
	}
	public void setIdUsuarioCriador(int idUsuarioCriador) {
		this.idUsuarioCriador = idUsuarioCriador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getRegras() {
		return regras;
	}
	public void setRegras(String regras) {
		this.regras = regras;
	}
	public int getLimite() {
		return limite;
	}
	public void setLimite(int limite) {
		this.limite = limite;
	}
	public ArrayList<Usuario> getParticipantes() {
		return participantes;
	}
	public void setParticipantes(ArrayList<Usuario> participantes) {
		this.participantes = participantes;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
