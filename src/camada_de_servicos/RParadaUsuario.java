package camada_de_servicos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Parada;
import modelo.Usuario;
import roteito_de_transacoes.RRTLogradouro;
import roteito_de_transacoes.RRTParada;

/**
 * Servlet implementation class RParadaUsuario
 */
@WebServlet("/RParadaUsuario")
public class RParadaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RParadaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario(Integer.parseInt(request.getParameter("idUsuario")));
		RRTParada roteiro = new RRTParada();
		ArrayList<Parada> paradas = roteiro.LerParadas(usuario);
		request.setAttribute("listaParadas", paradas);
		getServletContext().getRequestDispatcher("/frListarParada.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
