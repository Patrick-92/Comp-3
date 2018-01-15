package camada_de_servicos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Carona;
import modelo.Logradouro;
import roteito_de_transacoes.RRTLogradouro;

/**
 * Servlet implementation class RParada
 */
@WebServlet("/RParada")
public class RParada extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RParada() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Carona carona = new Carona(Integer.parseInt(request.getParameter("idCarona")));
		ArrayList<Logradouro> logradouros = new ArrayList<Logradouro>();
		RRTLogradouro roteiro = new RRTLogradouro();
		logradouros = roteiro.listarTodoLogradouro();
		request.setAttribute("idCarona", carona);
		request.setAttribute("listaLogradouro", logradouros);
		getServletContext().getRequestDispatcher("/frCriarParada.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
