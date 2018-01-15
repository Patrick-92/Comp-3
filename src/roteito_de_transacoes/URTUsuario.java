package roteito_de_transacoes;

import modelo.Usuario;
import portao_acesso_dados_tabelas.TBGUsuario;

public class URTUsuario {
	public void alterarUsuario (Usuario usuario){
		TBGUsuario.alterarUsuario(usuario.getNome(), usuario.getTelefone(), usuario.getId());
	}
}
