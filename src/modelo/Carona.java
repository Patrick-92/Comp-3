package modelo;

import java.util.ArrayList;

public class Carona {
	private String dia;
	private String hora_saida;
	private int veiculo;
	private int origem;
	private int destino;
	private ArrayList<Parada> paradas;
	private int id;
		
	public Carona(String dia, String hora_saida, int veiculo, int origem, int destino) {
		super();
		this.dia = dia;
		this.hora_saida = hora_saida;
		this.veiculo = veiculo;
		this.origem = origem;
		this.destino = destino;
	}

	public Carona(){
		
	}
	
	public Carona(String dia, String hora_saida) {
		this.dia = dia;
		this.hora_saida = hora_saida;
	}

	public Carona(int id){
		this.id =id;
	}
	
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHora_saida() {
		return hora_saida;
	}
	public void setHora_saida(String hora_saida) {
		this.hora_saida = hora_saida;
	}
	public int getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(int veiculo) {
		this.veiculo = veiculo;
	}
	public int getOrigem() {
		return origem;
	}
	public void setOrigem(int origem) {
		this.origem = origem;
	}
	public int getDestino() {
		return destino;
	}
	public void setDestino(int destino) {
		this.destino = destino;
	}
	public ArrayList<Parada> getParadas() {
		return paradas;
	}
	public void setParadas(ArrayList<Parada> paradas) {
		this.paradas = paradas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
