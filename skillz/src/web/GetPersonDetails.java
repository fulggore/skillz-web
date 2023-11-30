package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Person;
import dao.CandidatoDAO;
import dao.RecrutadorDAO;
/**
 * Servlet implementation class GetPersonDetails
 */
@WebServlet("/GetPersonDetails")
public class GetPersonDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetPersonDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		String action = request.getParameter("action") == null ? "" : request.getParameter("action");
		
		CandidatoDAO candidato = new CandidatoDAO();
		RecrutadorDAO recrutador = new RecrutadorDAO();
		
		switch (action.toLowerCase()) {
		case "edit":
			Person person = candidato.edit(request, response);
			request.setAttribute("person", person);
			request.getRequestDispatcher("/homeCandidatoEdit.jsp").include(request, response);
			break;
		case "delete":
			List<Person> pe = candidato.delete(request, response);
			request.setAttribute("persons", pe);
			request.setAttribute("msg", "Deletado com Sucesso!");
			request.getRequestDispatcher("/homeCandidato.jsp").include(request, response);
			break;
		case "editr":
			Person per = recrutador.edit(request, response);
			request.setAttribute("person", per);
			request.getRequestDispatcher("/homeRecruiterEdit.jsp").include(request, response);
			break;
		case "deleter":
			List<Person> p = recrutador.delete(request, response);
			request.setAttribute("persons", p);
			request.setAttribute("msg", "Deletado com Sucesso!");
			request.getRequestDispatcher("/homeRecruiter.jsp").include(request, response);
			break;
		case "recruiter":
			recrutador.selectall(request, response);
			request.getRequestDispatcher("/homeRecruiter.jsp").include(request, response);
			break;
		}

	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String chave = request.getParameter("busca");
		RecrutadorDAO recrutador = new RecrutadorDAO();
		
		
		List<Person> p = recrutador.search(chave,request, response);
		request.setAttribute("persons",p );
		request.getRequestDispatcher("/homeRecruiter.jsp").include(request, response);
		
	
	}

}
