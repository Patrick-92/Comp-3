package roteito_de_transacoes;

import modelo.Usuario;
import portao_acesso_dados_tabelas.TBGParada;

public class CNRTParada {
	private Usuario usuario;
		
	public CNRTParada(Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	public void cancelarParada (){
		TBGParada gateway = new TBGParada();
		gateway.cancelarParada(usuario.getId());
	}
}
