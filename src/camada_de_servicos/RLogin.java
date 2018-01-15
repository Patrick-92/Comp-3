package camada_de_servicos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;

import roteito_de_transacoes.RRTLogin;

/**
 * Servlet implementation class RLogin
 */
@WebServlet("/RLogin")
public class RLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RLogin() {
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
		Usuario usuario = new Usuario(null, request.getParameter("e-mail"), 
				null, null, null, null, request.getParameter("senha"));
		RRTLogin roteiro = new RRTLogin();
		request.getSession().setAttribute("IdUsuario", roteiro.loginUsuario(usuario).id);
		
		if(roteiro.loginUsuario(usuario).motorista == 0)
			response.sendRedirect("index.jsp");
		else if (roteiro.loginUsuario(usuario).motorista == 1) 
			response.sendRedirect("index_motorista.jsp");
		else
			response.sendRedirect("login.jsp");
	}

}
