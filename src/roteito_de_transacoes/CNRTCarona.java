package roteito_de_transacoes;

import modelo.Carona;
import portao_acesso_dados_tabelas.TBGCarona;
import portao_acesso_dados_tabelas.TBGParada;

public class CNRTCarona {
	private Carona carona;

	public CNRTCarona(Carona carona) {
		super();
		this.carona = carona;
	}
	
	public void cancelarCarona(){
		TBGCarona gateway = new TBGCarona();
		TBGParada gateway2 = new TBGParada();
		gateway.cancelarCarona(carona.getId());
		gateway2.cancelarParadas(carona.getId());
	}
}
