package camada_de_servicos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;
import roteito_de_transacoes.CRTUsuarioConvidado;

/**
 * Servlet implementation class UUsuarioConvidado
 */
@WebServlet("/UUsuarioConvidado")
public class UUsuarioConvidado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UUsuarioConvidado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario(request.getParameter("nome"), null, request.getParameter("telefone"),
				Integer.parseInt(request.getParameter("idUsuario")));
		usuario.setSenha(request.getParameter("senha"));
		CRTUsuarioConvidado roteiro = new CRTUsuarioConvidado(usuario);
		roteiro.incluirUsuarioConvidado();
		request.getSession().setAttribute("usuario", usuario);
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
