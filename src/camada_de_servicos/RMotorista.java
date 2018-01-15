package camada_de_servicos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Carona;
import modelo.Usuario;
import roteito_de_transacoes.RRTMotorista;

/**
 * Servlet implementation class RMotorista
 */
@WebServlet("/RMotorista")
public class RMotorista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RMotorista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Carona carona = new Carona(Integer.parseInt(request.getParameter("idCarona")));
		RRTMotorista roteiro = new RRTMotorista(carona);
		Usuario motorista = roteiro.lerMotorista();
		request.setAttribute("motorista", motorista);
		getServletContext().getRequestDispatcher("/frListarMotorista.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
