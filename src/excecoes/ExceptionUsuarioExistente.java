package excecoes;

@SuppressWarnings("serial")
public class ExceptionUsuarioExistente extends Exception{
	public String toString() {
		return "Usu�rio j� existente no sistema!";
	}
	
	@Override
	public String getMessage() {
		return "Usu�rio j� existente no sistema!";
	}
}
