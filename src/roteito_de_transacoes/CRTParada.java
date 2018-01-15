package roteito_de_transacoes;

import java.util.ArrayList;

import modelo.Carona;
import modelo.Logradouro;
import modelo.Motorista;
import modelo.Usuario;
import modelo.Veiculo;
import portao_acesso_dados_tabelas.TBGParada;
import portao_acesso_dados_tabelas.TBGUsuario;
import portao_acesso_dados_tabelas.TBGVeiculo;

public class CRTParada {
	public void incluirParada (Carona carona, Usuario usuario, Logradouro logradouro, Motorista motorista) throws Exception{
		TBGParada gateway = new TBGParada();
		TBGVeiculo gateway2 = new TBGVeiculo();
		TBGUsuario gateway3 = new TBGUsuario();
		ArrayList<Integer> caronas = gateway.LerParadasPorId(carona.getId());
		usuario = gateway3.buscarUsuario(usuario.getEmail());
		Veiculo veiculo = gateway2.LerVeiculoVaga(motorista.getId());
		int numeroDeVagas = caronas.size()- 2;
		if (veiculo.getVagas() > numeroDeVagas){
			TBGParada gateway4 = new TBGParada();
			gateway4.incluirParada(usuario.getId(), logradouro.getId(), carona.getId());
		} else
			throw new Exception();
	}
}
