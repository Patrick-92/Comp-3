package excecoes;

@SuppressWarnings("serial")
public class ExceptionUsuarioNaoConvidado extends Exception{
	public String toString() {
		return "Usu�rio n�o convidado!";
	}
	
	@Override
	public String getMessage() {
		return "Usu�rio n�o convidado!";
	}
}
