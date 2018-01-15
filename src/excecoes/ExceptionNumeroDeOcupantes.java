package excecoes;

@SuppressWarnings("serial")
public class ExceptionNumeroDeOcupantes extends Exception{
	public String toString() {
		return "Número de ocupantes na carona maior que zero!";
	}
	
	@Override
	public String getMessage() {
		return "Número de ocupantes na carona maior que zero!";
	}

}
