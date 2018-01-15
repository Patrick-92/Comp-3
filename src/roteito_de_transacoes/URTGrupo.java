package roteito_de_transacoes;

import modelo.Grupo;
import portao_acesso_dados_tabelas.TBGGrupo;

public class URTGrupo {
	public void alterarGrupo(Grupo grupo){
		TBGGrupo gateway = new TBGGrupo();
		gateway.alterarGrupo(grupo.getNome(), grupo.getDescricao(), grupo.getLimite(), grupo.getId());
	}
}
