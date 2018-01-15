package camada_de_servicos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Carona;
import modelo.Logradouro;
import modelo.Motorista;
import modelo.Usuario;
import roteito_de_transacoes.CRTParada;

/**
 * Servlet implementation class CParada
 */
@WebServlet("/CParada")
public class CParada extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CParada() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Carona carona = new Carona(Integer.parseInt(request.getParameter("idCarona")));
			Usuario usuario = new Usuario(request.getParameter("e-mail"));
			Logradouro logradouro = new Logradouro(Integer.parseInt(request.getParameter("idLogradouro")));
			Motorista motorista = new Motorista(Integer.parseInt(request.getParameter("idMotorista")));
			CRTParada roteiro = new CRTParada();
			roteiro.incluirParada(carona, usuario, logradouro, motorista);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("home.jsp");
	}

}
