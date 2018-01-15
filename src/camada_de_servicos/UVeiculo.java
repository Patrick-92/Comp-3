package camada_de_servicos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Veiculo;
import roteito_de_transacoes.URTVeiculo;

/**
 * Servlet implementation class Uveiuclo
 */
@WebServlet("/UVeiculo")
public class UVeiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UVeiculo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Veiculo veiculo = new Veiculo(request.getParameter("cor"),
					Integer.parseInt(request.getParameter("idVeiculo")));
			URTVeiculo roteiro = new URTVeiculo();
			roteiro.alterarVeiculo(veiculo);

			response.sendRedirect("home.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
