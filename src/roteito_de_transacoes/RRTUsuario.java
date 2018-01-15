package roteito_de_transacoes;

import java.util.ArrayList;

import modelo.Grupo;
import modelo.Usuario;
import portao_acesso_dados_tabelas.TBGGrupoUsuario;
import portao_acesso_dados_tabelas.TBGUsuario;

public class RRTUsuario {
	public ArrayList<Usuario> listarUsuario (Grupo grupo){
		TBGGrupoUsuario gateway = new TBGGrupoUsuario();
		TBGUsuario gateway2 = new TBGUsuario();
		return gateway2.lerUsuarios(gateway.lerUsuarioGrupo(grupo.getId()));
		
	}
}
