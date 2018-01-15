package roteito_de_transacoes;

import modelo.Grupo;
import modelo.Usuario;
import portao_acesso_dados_tabelas.TBGGrupoUsuario;

public class SRTGrupo {
	public void sairGrupo (Grupo grupo, Usuario usuario){
		TBGGrupoUsuario gateway = new TBGGrupoUsuario();
		gateway.sairGrupo(usuario.getId(), grupo.getId());
	}
}
