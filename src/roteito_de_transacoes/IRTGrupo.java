package roteito_de_transacoes;

import modelo.Grupo;
import portao_acesso_dados_tabelas.TBGGrupoUsuario;

public class IRTGrupo {
	public void inativarGrupo (Grupo grupo){
		TBGGrupoUsuario gateway = new TBGGrupoUsuario();
		gateway.inativarGrupo(grupo.getId());
	}
}
