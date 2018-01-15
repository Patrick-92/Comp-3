package roteito_de_transacoes;

import modelo.Veiculo;
import portao_acesso_dados_tabelas.TBGUsuario;
import portao_acesso_dados_tabelas.TBGVeiculo;

public class CRTVeiculo {
	private Veiculo veiculo;
	
	public CRTVeiculo(Veiculo veiculo) {
		super();
		this.veiculo = veiculo;
	}
	
	public void incluirVeiculo (){
		TBGVeiculo gateway = new TBGVeiculo();
		TBGUsuario gateway2 = new TBGUsuario();
		gateway.incluirVeiculo(veiculo.getModelo(), veiculo.getPlaca(), veiculo.getCor(), 
				veiculo.getMotorista().getId(), veiculo.getVagas());
		gateway2.alterarUsuarioMotorista(veiculo.getMotorista().getId());
	}
}
