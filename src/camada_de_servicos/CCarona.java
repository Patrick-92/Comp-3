package camada_de_servicos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excecoes.ExceptionDiaHoraIguaisCarona;
import modelo.Carona;
import modelo.Grupo;
import modelo.Motorista;
import roteito_de_transacoes.CRTCarona;

/**
 * Servlet implementation class CCarona
 */
@WebServlet("/CCarona")
public class CCarona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CCarona() {
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
		Carona carona = new Carona(request.getParameter("data"), request.getParameter("hora"));
		Grupo grupo = new Grupo(Integer.parseInt(request.getParameter("idGrupo")));
		int veiculo = Integer.parseInt(request.getParameter("veiculo"));
		int logradouroOrigem = Integer.parseInt(request.getParameter("logradouroOrigem"));
		int logradouroDestino = Integer.parseInt(request.getParameter("logradouroDestino"));
		Motorista motorista = new Motorista(Integer.parseInt(request.getParameter("idUsuario")));
		carona.setVeiculo(veiculo);
		carona.setOrigem(logradouroOrigem);
		carona.setDestino(logradouroDestino);
		
		CRTCarona roteiro = new CRTCarona(carona, motorista,grupo);
		try {
			roteiro.incluirCarona();
		} catch (ExceptionDiaHoraIguaisCarona e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		response.sendRedirect("home.jsp");
	}

}
