package camada_de_servicos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Grupo;
import roteito_de_transacoes.CRTGrupo;

/**
 * Servlet implementation class CGrupo
 */
@WebServlet("/CGrupo")
public class CGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CGrupo() {
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
			Grupo grupo = new Grupo(request.getParameter("nome"), request.getParameter("descricao"),
					request.getParameter("regras"), Integer.parseInt(request.getParameter("limite")),
					Integer.parseInt(request.getParameter("idUsuarioCriador")));
			CRTGrupo roteiro = new CRTGrupo(grupo);
			roteiro.incluirGrupo();

			response.sendRedirect("home.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
