package excecoes;

@SuppressWarnings("serial")
public class ExceptionDiaHoraIguaisCarona extends Exception{
	public String toString() {
		return "Dia ou hora da carona igual ao de uma carona já existente!";
	}
	
	@Override
	public String getMessage() {
		return "Dia ou hora da carona igual ao de uma carona já existente!!";
	}
}
