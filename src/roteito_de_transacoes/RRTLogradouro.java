package roteito_de_transacoes;

import java.util.ArrayList;

import modelo.Logradouro;
import portao_acesso_dados_tabelas.TBGLogradouro;

public class RRTLogradouro {
	public ArrayList<Logradouro> listarTodoLogradouro (){
		TBGLogradouro gateway = new TBGLogradouro();
		return gateway.listarTodoLogradouro();
	}
}
