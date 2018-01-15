package modelo;

import java.util.ArrayList;

public class Motorista extends Usuario{
	
	public Motorista(String nome, String email, String telefone, ArrayList<Grupo> grupos, ArrayList<Parada> paradas,
			ArrayList<Avaliacao> avaliacoes, String senha) {
		super(nome, email, telefone, grupos, paradas, avaliacoes, senha);
		// TODO Auto-generated constructor stub
	}
	
	public Motorista(int id){
		super(id);
	}
	
	protected ArrayList<Veiculo> veiculos; 
}
