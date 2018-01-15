package modelo;

import java.util.ArrayList;

public class Veiculo {
	private String modelo;
	private String placa;
	private Motorista motorista;
	private ArrayList<Carona> caronas;
	private String cor;
	private int id;
	private int vagas;
	private int idMotorista;
	
	public int getIdMotorista() {
		return idMotorista;
	}

	public void setIdMotorista(int idMotorista) {
		this.idMotorista = idMotorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	
	public Motorista getMotorista(){
		return motorista;
	}

	public Veiculo(String modelo, String placa, String cor) {
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
	}
	
	public Veiculo (String cor, int id){
		this.cor = cor;
		this.id = id;
	}
	
	public Veiculo(String modelo, String placa, String cor, int vagas) {
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
		this.vagas = vagas;
	}
	
	public Veiculo (){
		
	}
	
	public Veiculo(String modelo, String placa, int idMotorista, String cor, int id, int vagas) {
		super();
		this.modelo = modelo;
		this.placa = placa;
		this.idMotorista = idMotorista;
		this.cor = cor;
		this.id = id;
		this.vagas = vagas;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}
	
	public ArrayList<Carona> getCaronas() {
		return caronas;
	}
	public void setCaronas(ArrayList<Carona> caronas) {
		this.caronas = caronas;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
