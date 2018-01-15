package roteito_de_transacoes;

import modelo.Logradouro;
import portao_acesso_dados_tabelas.TBGLogradouro;

public class CRTLogradouro {
	private Logradouro logradouro;
	
	public CRTLogradouro(Logradouro logradouro) {
		super();
		this.logradouro = logradouro;
	}

	public TBGLogradouro incluirLogradouro (){
		TBGLogradouro gateway = new TBGLogradouro();
		return gateway.incluirLogradouro(logradouro.getCep(),logradouro.getEstado(),logradouro.getCidade(),
				logradouro.getDistrito(), logradouro.getEndereco(), logradouro.getNumero());
	}

}
