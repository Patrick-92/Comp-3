package excecoes;

@SuppressWarnings("serial")
public class ExceptionUsuarioPertenceGrupo extends Exception{
	public String toString() {
		return "Usuário já pertence ao grupo!";
	}
	
	@Override
	public String getMessage() {
		return "Usuário já pertence ao grupo!";
	}
}
