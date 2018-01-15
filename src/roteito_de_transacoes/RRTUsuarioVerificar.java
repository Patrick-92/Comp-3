package roteito_de_transacoes;

import excecoes.ExceptionUsuarioExistente;
import excecoes.ExceptionUsuarioNaoConvidado;
import modelo.Usuario;
import portao_acesso_dados_tabelas.TBGUsuario;

public class RRTUsuarioVerificar {
	private Usuario usuario;

	public RRTUsuarioVerificar(Usuario usuario) {
		super();
		this.usuario = usuario;
	}
	
	public Usuario verificarUsuario () throws ExceptionUsuarioExistente, ExceptionUsuarioNaoConvidado{
		TBGUsuario gateway = new TBGUsuario();
		Usuario usuarioTemp =  gateway.buscarUsuario(usuario.getEmail());
		int status = usuarioTemp.getStatus(); 
		if(status == 1){
			throw new ExceptionUsuarioExistente();
		}
		if (usuario.getEmail() == null) {
			throw new ExceptionUsuarioNaoConvidado();
		} else
			return usuarioTemp;
	}  
}
