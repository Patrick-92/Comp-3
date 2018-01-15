package roteito_de_transacoes;

import modelo.Usuario;
import portao_acesso_dados_tabelas.TBGUsuario;

public class RRTLogin {
	public TBGUsuario loginUsuario(Usuario usuario){
		return TBGUsuario.loginUsuario(usuario.getEmail(), usuario.getSenha());
	}
}
