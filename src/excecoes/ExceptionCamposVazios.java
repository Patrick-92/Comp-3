package excecoes;

@SuppressWarnings("serial")
public class ExceptionCamposVazios extends Exception{
	public String toString() {
		return "Campo n�o preenchido!";
	}
	
	@Override
	public String getMessage() {
		return "Campo n�o preenchido!";
	}
}
