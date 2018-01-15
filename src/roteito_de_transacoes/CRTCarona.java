package roteito_de_transacoes;

import java.util.ArrayList;

import excecoes.ExceptionDiaHoraIguaisCarona;
import modelo.Carona;
import modelo.Grupo;
import modelo.Motorista;
import portao_acesso_dados_tabelas.TBGCarona;
import portao_acesso_dados_tabelas.TBGParada;

public class CRTCarona {
	private Carona carona;
	private Motorista motorista;
	private Grupo grupo;
	
	public CRTCarona(Carona carona, Motorista motorista, Grupo grupo) {
		super();
		this.carona = carona;
		this.motorista = motorista;
		this.grupo = grupo;
	}

	public void incluirCarona () throws ExceptionDiaHoraIguaisCarona{
		TBGCarona gateway = new TBGCarona();
		TBGParada gateway2 = new TBGParada();
		ArrayList<Carona> caronas = gateway.lerTodasCaronas();
		for (Carona carona2 : caronas) {
			if (carona2.getDia() == carona.getDia() && carona2.getHora_saida() == carona.getHora_saida()){
				throw new ExceptionDiaHoraIguaisCarona();
				
			}
		}
		
		Carona caronaTemp = gateway.incluirCarona(carona.getVeiculo(), carona.getDia(), carona.getHora_saida(),
				carona.getOrigem(), carona.getDestino(), motorista.getId(), grupo.getId());
		carona.setId(caronaTemp.getId());
		gateway2.incluirParada(0, carona.getOrigem(), carona.getId());
		gateway2.incluirParada(0, carona.getDestino(), carona.getId());
		
	}
}
