package excecoes;

@SuppressWarnings("serial")
public class ExceptionUsuarioConvidado extends Exception{
	public String toString() {
		return "Usuário já foi convidado!";
	}
	
	@Override
	public String getMessage() {
		return "Usuário já foi convidado!";
	}
}
