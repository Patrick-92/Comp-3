package roteito_de_transacoes;

import java.util.ArrayList;

import modelo.Motorista;
import modelo.Veiculo;
import portao_acesso_dados_tabelas.TBGVeiculo;

public class RRTVeiculo {
	public ArrayList<Veiculo> LerVeiculo(Motorista motorista){
		TBGVeiculo gateway = new TBGVeiculo();
		return gateway.LerVeiculos(motorista.getId());
	}
}
