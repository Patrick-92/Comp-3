package camada_de_servicos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Motorista;
import modelo.Veiculo;
import roteito_de_transacoes.RRTVeiculo;

/**
 * Servlet implementation class RVeiculo
 */
@WebServlet("/RVeiculo")
public class RVeiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RVeiculo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Motorista motorista = new Motorista(Integer.parseInt(request.getParameter("id")));
			RRTVeiculo roteiro = new RRTVeiculo();
			ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
			System.out.println(motorista.getId());
			veiculos = roteiro.LerVeiculo(motorista);
			request.setAttribute("lista", veiculos);
			getServletContext().getRequestDispatcher("/frListarVeiculo.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
