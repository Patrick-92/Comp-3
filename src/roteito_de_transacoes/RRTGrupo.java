package roteito_de_transacoes;

import java.util.ArrayList;

import modelo.Grupo;
import modelo.Usuario;
import portao_acesso_dados_tabelas.TBGGrupo;
import portao_acesso_dados_tabelas.TBGGrupoUsuario;

public class RRTGrupo {
	public ArrayList<Grupo> lerGrupo(Usuario usuario){
		TBGGrupoUsuario gateway = new TBGGrupoUsuario();
		TBGGrupo gateway2 = new TBGGrupo();
		
		return gateway2.lerGrupos(gateway.lerGrupoUsuario(usuario.getId()));
	}
}
