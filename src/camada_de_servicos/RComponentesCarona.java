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
import modelo.Logradouro;
import modelo.Motorista;
import modelo.Veiculo;
import roteito_de_transacoes.RRTLogradouro;
import roteito_de_transacoes.RRTVeiculo;

/**
 * Servlet implementation class RComponentesCarona
 */
@WebServlet("/RComponentesCarona")
public class RComponentesCarona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RComponentesCarona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Motorista motorista = new Motorista(Integer.parseInt(request.getParameter("idUsuario")));
		Grupo grupo = new Grupo(Integer.parseInt(request.getParameter("idGrupo")));
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
		ArrayList<Logradouro> logradouros = new ArrayList<Logradouro>();
		
		RRTVeiculo roteiro = new RRTVeiculo();
		RRTLogradouro roteiro2 = new RRTLogradouro();
		
		veiculos = roteiro.LerVeiculo(motorista);
		logradouros = roteiro2.listarTodoLogradouro();
		
		request.setAttribute("listaVeiculo", veiculos);
		request.setAttribute("listaLogradouro", logradouros);
		request.setAttribute("grupo", grupo);
		
		getServletContext().getRequestDispatcher("/frCriarCarona.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
