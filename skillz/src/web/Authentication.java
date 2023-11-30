package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Candidato;
import model.Person;
import model.Recrutador;
import dao.CandidatoDAO;
import dao.RecrutadorDAO;

/**
 * Servlet implementation class Authentication
 */
@WebServlet("/Authentication")
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentication() {
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
		response.setContentType("text/html");
		
		String tipo = "";
		
		tipo = request.getParameter("tipo");
		
		
		
		
		if(tipo.equals("candidato")) {
			
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String cpf = request.getParameter("cpf");
			String senha = request.getParameter("senha");
			String celular = request.getParameter("celular");
			
			Candidato candidato = new Candidato(nome,email,cpf,senha,celular);
			
			CandidatoDAO candidatoDAO = new CandidatoDAO();
			
			candidatoDAO.insertCandidato(candidato, request, response);
			request.setAttribute("msg", "Cadastrado com Sucesso!");
			
			request.getRequestDispatcher("/index.jsp").include(request, response);
			
		}
		
		
		if(tipo.equals("recrutador")) {
				
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String cnpj = request.getParameter("cnpj");
			String senha = request.getParameter("senha");
			String empresa = request.getParameter("empresa");
			String telefone = request.getParameter("telefone");
			
			Recrutador recrutador = new Recrutador(nome,email,cnpj,empresa,senha,telefone);
			
			RecrutadorDAO recrutadorDAO = new RecrutadorDAO();
			
			recrutadorDAO.insertRecrutador(recrutador, request, response);
			
			request.setAttribute("msg", "Cadastrado com Sucesso!");
			request.getRequestDispatcher("/index.jsp").include(request, response);
				
		}
			
		if (tipo.equals("candidatoLogin")) {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			
			CandidatoDAO candidatoDAO = new CandidatoDAO();
			String cpf = candidatoDAO.searchUser(username,password,request, response);
			
			
			Person person = new Person (cpf);
			List<Person> pessoas = candidatoDAO.list(person,request, response);
			
			request.setAttribute("persons", pessoas);
			request.setAttribute("cpf", cpf);
			request.getRequestDispatcher("/homeCandidato.jsp").include(request, response);
					
		}
		
		
		
		if(tipo.equals("recrutadorLogin")) {
			
		}
				
		
		
		
		
	}

}
