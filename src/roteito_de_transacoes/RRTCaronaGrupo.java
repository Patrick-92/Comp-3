package roteito_de_transacoes;

import java.util.ArrayList;

import modelo.Carona;
import modelo.Grupo;
import modelo.Usuario;
import portao_acesso_dados_tabelas.TBGCarona;

public class RRTCaronaGrupo {
	
	private ArrayList<Usuario> usuarios;
	private Grupo grupo;
		
	public RRTCaronaGrupo(ArrayList<Usuario> usuarios, Grupo grupo) {
		super();
		this.usuarios = usuarios;
		this.grupo = grupo;
	}

	public ArrayList<Carona>  listarCaronaGrupoPorIdUsuario (){
		TBGCarona gateway = new TBGCarona();
		ArrayList<Carona> caronasTemp = new ArrayList<Carona>();
		ArrayList<Carona> caronas = new ArrayList<Carona>();
		
		for (Usuario usuario : usuarios) {
			caronasTemp = gateway.LerCaronas(usuario.getId(), grupo.getId());
			for (Carona carona : caronasTemp) {
				caronas.add(carona);
			}
		}
		return caronas;
	}
}
