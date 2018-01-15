package roteito_de_transacoes;

import java.util.ArrayList;

import excecoes.ExceptionUsuarioConvidado;
import excecoes.ExceptionUsuarioPertenceGrupo;
import modelo.Grupo;
import modelo.Usuario;
import portao_acesso_dados_tabelas.TBGGrupoUsuario;
import portao_acesso_dados_tabelas.TBGUsuario;

public class CRTMembro {
	private Grupo grupo;
	private Usuario usuario;
	
	public CRTMembro(Grupo grupo, Usuario usuario) {
		super();
		this.grupo = grupo;
		this.usuario = usuario;
	}

	public void incluirMembro () throws ExceptionUsuarioConvidado, ExceptionUsuarioPertenceGrupo{
		TBGUsuario gateway = new TBGUsuario();
		TBGGrupoUsuario gateway2 = new TBGGrupoUsuario();
		//buscando o id do usuário
		Usuario usuarioTemp = gateway.buscarUsuario(usuario.getEmail());
		
		// verificando se o usuário já foi convidado
		if(usuarioTemp.getStatus() == 0 && usuarioTemp.getId() != 0){
			throw new ExceptionUsuarioConvidado();
		}
		if (usuarioTemp.getId() == 0){
			gateway.incluirUsuario(usuario.getEmail(), 0);
			return;
		}
		
		//verificando se usuário existe no grupo ao qual vai ser adicionado
		ArrayList<Integer> usuarios = new ArrayList<Integer>(); 
		usuarios = gateway2.lerUsuarioGrupo(grupo.getId());
		for (Integer id : usuarios) {
			if (id == usuario.getId()) {
				throw new ExceptionUsuarioPertenceGrupo();
			}
		}
		gateway2.incluirGrupoUsuario(grupo.getId(), usuario.getId());
	}
}
