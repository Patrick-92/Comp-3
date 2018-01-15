package camada_de_servicos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Logradouro;
import roteito_de_transacoes.CRTLogradouro;

/**
 * Servlet implementation class CLogradouro
 */
@WebServlet("/CLogradouro")
public class CLogradouro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CLogradouro() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Logradouro logradouro = new Logradouro(request.getParameter("cep"), request.getParameter("uf"),
					request.getParameter("cidade"), request.getParameter("distrito"), request.getParameter("endereco"),
					Integer.parseInt(request.getParameter("numero")));
			CRTLogradouro roteiro = new CRTLogradouro(logradouro);
			roteiro.incluirLogradouro();

			response.sendRedirect("home.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
