package modelo;

public class Logradouro {
	private String cep;
	private String estado;
	private String cidade;
	private String distrito;
	private String endereco;
	private int numero;
	public Parada paradas;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Logradouro(String cep, String estado, String cidade, String distrito, String endereco, int numero,
			Parada paradas) {
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.distrito = distrito;
		this.endereco = endereco;
		this.numero = numero;
		this.paradas = paradas;
	}
	
	public Logradouro (String cep, String estado, String cidade, String distrito, String endereco, int numero){
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.distrito = distrito;
		this.endereco = endereco;
		this.numero = numero;
	}
	
	public Logradouro(String cep, String estado, String cidade, String distrito, String endereco, int numero, int id) {
		super();
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.distrito = distrito;
		this.endereco = endereco;
		this.numero = numero;
		this.id = id;
	}
		
	public Logradouro(int id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
}
