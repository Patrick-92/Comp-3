package roteito_de_transacoes;

import java.util.ArrayList;

import modelo.Carona;
import modelo.Motorista;
import portao_acesso_dados_tabelas.TBGCarona;

public class RRTCarona {
	public ArrayList<Carona> listarCaronaPorIdUsuario (Motorista motorista){
		TBGCarona gateway = new TBGCarona();
		return gateway.LerCaronas(motorista.getId());
	}
}
