package roteito_de_transacoes;

import modelo.Usuario;
import portao_acesso_dados_tabelas.TBGUsuario;

public class CRTUsuario {
	public Usuario incluirUsuario (Usuario usuario){
		TBGUsuario gateway = new TBGUsuario();
		return gateway.incluirUsuario(usuario.getNome(),usuario.getEmail(),usuario.getTelefone(),usuario.getSenha());
	}
}
