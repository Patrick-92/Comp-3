package excecoes;

@SuppressWarnings("serial")
public class ExceptionUsuarioNaoConvidado extends Exception{
	public String toString() {
		return "Usuário não convidado!";
	}
	
	@Override
	public String getMessage() {
		return "Usuário não convidado!";
	}
}
