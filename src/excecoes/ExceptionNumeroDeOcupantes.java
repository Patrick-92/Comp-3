package excecoes;

@SuppressWarnings("serial")
public class ExceptionNumeroDeOcupantes extends Exception{
	public String toString() {
		return "N�mero de ocupantes na carona maior que zero!";
	}
	
	@Override
	public String getMessage() {
		return "N�mero de ocupantes na carona maior que zero!";
	}

}
