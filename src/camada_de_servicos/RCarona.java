package camada_de_servicos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Carona;
import modelo.Motorista;
import roteito_de_transacoes.RRTCarona;

/**
 * Servlet implementation class RCarona
 */
@WebServlet("/RCarona")
public class RCarona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RCarona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Motorista motorista = new Motorista(Integer.parseInt(request.getParameter("idUsuario")));
		RRTCarona roteiro = new RRTCarona();
		ArrayList<Carona> carona = roteiro.listarCaronaPorIdUsuario(motorista);
		request.setAttribute("lista", carona);
		getServletContext().getRequestDispatcher("/frListarCarona.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
