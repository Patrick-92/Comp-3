package camada_de_servicos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Grupo;
import modelo.Usuario;
import roteito_de_transacoes.CRTMembro;

/**
 * Servlet implementation class CMembro
 */
@WebServlet("/CMembro")
public class CMembro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMembro() {
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
			Grupo grupo = new Grupo(Integer.parseInt(request.getParameter("idGrupo")));
			Usuario usuario = new Usuario(request.getParameter("e-mail"));
			CRTMembro roteiro = new CRTMembro(grupo, usuario);
			
			roteiro.incluirMembro();
			response.sendRedirect("home.jsp");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
			
		
		
	}

}
