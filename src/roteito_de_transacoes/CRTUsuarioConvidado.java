package roteito_de_transacoes;

import modelo.Usuario;
import portao_acesso_dados_tabelas.TBGUsuario;

public class CRTUsuarioConvidado {
	private Usuario usuario;

	public CRTUsuarioConvidado(Usuario usuario) {
		super();
		this.usuario = usuario;
	}
	
	public void incluirUsuarioConvidado (){
		TBGUsuario gateway = new TBGUsuario();
		gateway.alterarUsuario(usuario.getNome(), usuario.getTelefone(), usuario.getId(), usuario.getSenha());
	}
}
