package roteito_de_transacoes;

import modelo.Grupo;
import portao_acesso_dados_tabelas.TBGGrupo;
import portao_acesso_dados_tabelas.TBGGrupoUsuario;

public class CRTGrupo {
	private Grupo grupo;
	
	public CRTGrupo(Grupo grupo) {
		super();
		this.grupo = grupo;
	}

	public void incluirGrupo () {
		TBGGrupo gateway = new TBGGrupo();
		TBGGrupoUsuario gateway2 = new TBGGrupoUsuario(); 
		gateway = gateway.incluirGrupo(grupo.getNome(), grupo.getDescricao(), grupo.getRegras(), 
				grupo.getLimite(), grupo.getIdUsuarioCriador());
		gateway2.incluirGrupoUsuario(gateway.id, grupo.getIdUsuarioCriador());
	}
}
