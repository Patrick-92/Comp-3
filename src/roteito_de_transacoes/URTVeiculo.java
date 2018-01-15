package roteito_de_transacoes;

import modelo.Veiculo;
import portao_acesso_dados_tabelas.TBGVeiculo;

public class URTVeiculo {
	public void alterarVeiculo(Veiculo veiculo){
		TBGVeiculo gateway = new TBGVeiculo();
		gateway.alterarVeiculo(veiculo.getCor(), veiculo.getId());
	}
}
