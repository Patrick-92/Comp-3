package excecoes;

@SuppressWarnings("serial")
public class ExceptionUsuarioPertenceGrupo extends Exception{
	public String toString() {
		return "Usu�rio j� pertence ao grupo!";
	}
	
	@Override
	public String getMessage() {
		return "Usu�rio j� pertence ao grupo!";
	}
}
