package camada_de_servicos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Grupo;
import roteito_de_transacoes.URTGrupo;

/**
 * Servlet implementation class UGrupo
 */
@WebServlet("/UGrupo")
public class UGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UGrupo() {
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
		Grupo grupo = new Grupo(Integer.parseInt(request.getParameter("idGrupo")), request.getParameter("nome"),
				request.getParameter("descricao"), request.getParameter("regras"), 
				Integer.parseInt(request.getParameter("limite")));
		URTGrupo roteiro = new URTGrupo();
		roteiro.alterarGrupo(grupo);
		response.sendRedirect("home.jsp");
	}

}
