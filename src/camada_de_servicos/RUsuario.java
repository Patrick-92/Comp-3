package camada_de_servicos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Grupo;
import modelo.Usuario;
import roteito_de_transacoes.RRTUsuario;

/**
 * Servlet implementation class RUsuario
 */
@WebServlet("/RUsuario")
public class RUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Grupo grupo = new Grupo(Integer.parseInt(request.getParameter("idGrupo")));
			RRTUsuario roteiro = new RRTUsuario();
			ArrayList<Usuario> usuarios = roteiro.listarUsuario(grupo);
			usuarios.get(0).setIdGrupo(grupo.getId());
			request.setAttribute("lista", usuarios);
			getServletContext().getRequestDispatcher("/frListarMembro.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
