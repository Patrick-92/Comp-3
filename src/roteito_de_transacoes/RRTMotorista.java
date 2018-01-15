package roteito_de_transacoes;

import modelo.Carona;
import modelo.Usuario;
import portao_acesso_dados_tabelas.TBGCarona;
import portao_acesso_dados_tabelas.TBGUsuario;
import portao_acesso_dados_tabelas.TBGVeiculo;

public class RRTMotorista {
	private Carona carona;
	
	public RRTMotorista(Carona carona) {
		this.carona = carona;
	}

	public Usuario lerMotorista (){
		TBGCarona gateway = new TBGCarona();
		TBGUsuario gateway2 = new TBGUsuario();
		TBGVeiculo gateway3 = new TBGVeiculo();
		carona = gateway.lerCarona(carona.getId());
		return gateway2.buscarUsuarioPorId(gateway3.LerVeiculoVaga(carona.getVeiculo()).getIdMotorista());
	}
}
