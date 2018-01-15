package camada_de_servicos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;
import roteito_de_transacoes.URTUsuario;

/**
 * Servlet implementation class UUsuario
 */
@WebServlet("/UUsuario")
public class UUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UUsuario() {
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
			Usuario usuario = new Usuario(request.getParameter("nome"), null, request.getParameter("telefone"), null, null, null, null);
			usuario.setId(Integer.parseInt(request.getParameter("id")));
			URTUsuario roteiro = new URTUsuario();
			roteiro.alterarUsuario(usuario);
			response.sendRedirect("home.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}	
					
	}

}
