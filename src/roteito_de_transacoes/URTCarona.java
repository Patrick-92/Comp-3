package roteito_de_transacoes;

import java.util.ArrayList;

import excecoes.ExceptionNumeroDeOcupantes;
import modelo.Carona;
import modelo.Motorista;
import modelo.Veiculo;
import portao_acesso_dados_tabelas.TBGCarona;
import portao_acesso_dados_tabelas.TBGParada;
import portao_acesso_dados_tabelas.TBGVeiculo;

public class URTCarona {
	
	private Carona carona;
	private Motorista motorista;
	
	public URTCarona(Carona carona, Motorista motorista) {
		this.carona = carona;
		this.motorista= motorista;
	}
	
	public void alterarCarona () throws Exception{
		
		TBGCarona gateway = new TBGCarona();
		TBGParada gateway2 = new TBGParada();
		TBGVeiculo gateway3 = new TBGVeiculo();
		Carona caronaTemp = gateway.lerCarona(carona.getId());
		Veiculo veiculoNovo = gateway3.LerVeiculoVaga(carona.getVeiculo());
		Veiculo veiculoRegistrado = gateway3.LerVeiculoVaga(caronaTemp.getVeiculo());
		ArrayList<Integer> caronas = gateway2.LerParadasPorId(carona.getId());
		int numeroDeOcupantes= caronas.size()- 2;
		if (numeroDeOcupantes == 0 && veiculoNovo.getVagas() == veiculoRegistrado.getVagas()){
			TBGParada gateway4 = new TBGParada();
			gateway.alterarCarona(carona.getVeiculo(), carona.getOrigem(), carona.getDestino(), carona.getId());
		} else
			throw new ExceptionNumeroDeOcupantes();
	}
}
