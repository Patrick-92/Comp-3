package excecoes;

@SuppressWarnings("serial")
public class ExceptionUsuarioConvidado extends Exception{
	public String toString() {
		return "Usu�rio j� foi convidado!";
	}
	
	@Override
	public String getMessage() {
		return "Usu�rio j� foi convidado!";
	}
}
