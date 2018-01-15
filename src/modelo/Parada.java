package modelo;

public class Parada {
	private int usuario;
	private int logradouro;
	private int carona;	
	
	public Parada(int usuario, int logradouro, int carona) {
		this.usuario = usuario;
		this.logradouro = logradouro;
		this.carona = carona;
	}
	
	public int getUsuario() {
		return usuario;
	}
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	public int getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(int logradouro) {
		this.logradouro = logradouro;
	}
	public int getCarona() {
		return carona;
	}
	public void setCarona(int carona) {
		this.carona = carona;
	}
}
