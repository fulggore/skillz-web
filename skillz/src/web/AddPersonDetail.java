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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Person;
import dao.CandidatoDAO;

/**
 * Servlet implementation class AddPersonDetail
 */
@WebServlet("/AddPersonDetail")
public class AddPersonDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPersonDetail() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String id = request.getParameter("id");
		
		String nome = "";
		String email = "";
		String cpf = request.getParameter("cpf");
		String senha = "";
		String celular = "";
		String nomeCurriculo = request.getParameter("nomeCurriculo");
		String profissao = request.getParameter("profissao");
		String experiencia = request.getParameter("experiencia");
		String educacao = request.getParameter("educacao");
		String extra = request.getParameter("extra");
		String chave = request.getParameter("chave");

		Person person = new Person(nome,email,cpf,senha,celular,nomeCurriculo,profissao,experiencia,educacao,extra,chave);
		CandidatoDAO candidato = new CandidatoDAO();
		
		if (id == "" || id.isEmpty()) {
			
			List<Person> persons =  candidato.insert(person,request, response);
			request.setAttribute("cpf", cpf);
			request.setAttribute("persons", persons);
			request.setAttribute("msg", "Adicionado com Sucesso!");
			request.getRequestDispatcher("/homeCandidato.jsp").include(request, response);
			
			
		} else {
			
			List<Person> persons =  candidato.update(id,person,request, response);
			request.setAttribute("persons", persons);
			request.setAttribute("cpf", cpf);
			request.setAttribute("msg", "Editado com Sucesso!");
			request.getRequestDispatcher("/homeCandidato.jsp").include(request, response);
				
		}

	}

}
