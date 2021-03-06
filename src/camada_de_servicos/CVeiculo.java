package camada_de_servicos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Motorista;
import modelo.Veiculo;
import roteito_de_transacoes.CRTVeiculo;

/**
 * Servlet implementation class CVeiculo
 */
@WebServlet("/CVeiculo")
public class CVeiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CVeiculo() {
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
		Veiculo veiculo = new Veiculo(request.getParameter("modelo"), request.getParameter("placa"),
				request.getParameter("cor"), Integer.parseInt(request.getParameter("vagas")));
		Motorista motorista = new Motorista(Integer.parseInt(request.getParameter("idUsuario")));
		veiculo.setMotorista(motorista);
		
		CRTVeiculo roteiro = new CRTVeiculo(veiculo);
		roteiro.incluirVeiculo();
		
		response.sendRedirect("login.jsp");
	}

}
