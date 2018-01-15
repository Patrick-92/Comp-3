package camada_de_servicos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Carona;
import modelo.Grupo;
import modelo.Usuario;
import roteito_de_transacoes.RRTCaronaGrupo;
import roteito_de_transacoes.RRTUsuario;

/**
 * Servlet implementation class RCaronaGrupo
 */
@WebServlet("/RCaronaGrupo")
public class RCaronaGrupo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RCaronaGrupo() {
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
			RRTCaronaGrupo roteiro2 = new RRTCaronaGrupo(usuarios, grupo);
			ArrayList<Carona> caronas = roteiro2.listarCaronaGrupoPorIdUsuario();
			request.setAttribute("lista", caronas);
			getServletContext().getRequestDispatcher("/frListarCaronaGrupo.jsp").forward(request, response);
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
