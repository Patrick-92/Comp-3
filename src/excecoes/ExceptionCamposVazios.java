package excecoes;

@SuppressWarnings("serial")
public class ExceptionCamposVazios extends Exception{
	public String toString() {
		return "Campo não preenchido!";
	}
	
	@Override
	public String getMessage() {
		return "Campo não preenchido!";
	}
}
