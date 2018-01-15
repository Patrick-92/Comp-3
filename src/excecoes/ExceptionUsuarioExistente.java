package excecoes;

@SuppressWarnings("serial")
public class ExceptionUsuarioExistente extends Exception{
	public String toString() {
		return "Usuário já existente no sistema!";
	}
	
	@Override
	public String getMessage() {
		return "Usuário já existente no sistema!";
	}
}
