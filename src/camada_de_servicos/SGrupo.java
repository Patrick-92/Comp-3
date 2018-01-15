package camada_de_servicos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Grupo;
import modelo.Usuario;
import roteito_de_transacoes.SRTGrupo;

/**
 * Servlet implementation class SGrupo
 */
@WebServlet("/SGrupo")
public class SGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SGrupo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Grupo grupo = new Grupo(Integer.parseInt(request.getParameter("idGrupo")));
		Usuario usuario = new Usuario(Integer.parseInt(request.getParameter("idUsuario")));
		SRTGrupo roteiro = new SRTGrupo();
		roteiro.sairGrupo(grupo, usuario);
		response.sendRedirect("home.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
