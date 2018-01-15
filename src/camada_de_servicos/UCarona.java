package camada_de_servicos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import modelo.Carona;
import modelo.Motorista;
import roteito_de_transacoes.URTCarona;
import excecoes.*;

/**
 * Servlet implementation class UCarona
 */
@WebServlet("/UCarona")
public class UCarona extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UCarona() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Carona carona = new Carona();
		try {
			if (request.getParameter("veiculo").isEmpty() || request.getParameter("logradouroOrigem").isEmpty()
					|| request.getParameter("logradouroDestino").isEmpty() || request.getParameter("idCarona").isEmpty()) {
				throw new ExceptionCamposVazios();
			} else {
				 Motorista motorista = new Motorista(Integer.parseInt(request.getParameter("idUsuario")));
				int idCarona = Integer.parseInt(request.getParameter("idCarona"));
				int veiculo = Integer.parseInt(request.getParameter("veiculo"));
				int logradouroOrigem = Integer.parseInt(request.getParameter("logradouroOrigem"));
				int logradouroDestino = Integer.parseInt(request.getParameter("logradouroDestino"));
				carona.setId(idCarona);
				carona.setVeiculo(veiculo);
				carona.setOrigem(logradouroOrigem);
				carona.setDestino(logradouroDestino);

				URTCarona roteiro = new URTCarona(carona, motorista);

				roteiro.alterarCarona();
				
				response.sendRedirect("home.jsp");
			}
		} catch (Exception e) {
			System.out.println("Ocorreu o erro:" + e);
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
