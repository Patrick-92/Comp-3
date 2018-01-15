package roteito_de_transacoes;

import java.util.ArrayList;

import modelo.Parada;
import modelo.Usuario;
import portao_acesso_dados_tabelas.TBGParada;

public class RRTParada {
	public ArrayList<Parada> LerParadas (Usuario usuario){
		TBGParada gateway = new TBGParada();
		ArrayList<Parada> parada = gateway.LerParadas(usuario.getId());
		return parada;
	}
}
