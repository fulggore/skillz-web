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

/**
 * Servlet implementation class AddPersonDetail
 */
@WebServlet("/AddPersonDetailR")
public class AddPersonDetailR extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPersonDetailR() {
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
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		String celular = request.getParameter("celular");
		String nomeCurriculo = request.getParameter("nomeCurriculo");
		String profissao = request.getParameter("profissao");
		String experiencia = request.getParameter("experiencia");
		String educacao = request.getParameter("educacao");
		String extra = request.getParameter("extra");
		String chave = request.getParameter("chave");
		String favorito = request.getParameter("favorito");
		
//		System.out.println(favorito);

		Person person = new Person(nome,email,cpf,senha,celular,nomeCurriculo,profissao,experiencia,educacao,extra,chave);
		
		
			String sql = "update PERSON set FIRST_NAME=?,email=?,cpf=?,senha=?,celular=?,curriculoNome=?,profissao=?,experiencia=?,educacao=?,infoExtra=?,chaves=?, favorito=? where id=?";

			Connection conn = null;

			try {
				conn = (Connection) request.getServletContext().getAttribute("connection");
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, person.getNome());
				pStmt.setString(2, person.getEmail());
				pStmt.setString(3, person.getCpf());
				pStmt.setString(4, person.getSenha());
				pStmt.setString(5, person.getCelular());
				pStmt.setString(6, person.getNomeCurriculo());
				pStmt.setString(7, person.getProfissao());
				pStmt.setString(8, person.getExperiencia());
				pStmt.setString(9, person.getEducacao());
				pStmt.setString(10, person.getExtra());
				pStmt.setString(11, person.getChave());
				pStmt.setString(12, favorito);
				pStmt.setInt(13, Integer.parseInt(id));

				int row = pStmt.executeUpdate();


				
				request.setAttribute("msg", "Editado com Sucesso!");
				
				
				
				sql = "select * from PERSON ";
				 conn = null;
				try {
					conn = (Connection) request.getServletContext().getAttribute("connection");
					PreparedStatement stmt = conn.prepareStatement(sql);
					
					ResultSet rs = stmt.executeQuery();
					
					List<Person> persons = new ArrayList<>();
					while (rs.next()) {
						Person p = new Person();
						p.setId(rs.getLong("ID"));
						p.setNomeCurriculo(rs.getString("curriculoNome"));
						p.setProfissao(rs.getString("profissao"));
						p.setChave(rs.getString("chaves"));
						p.setFavorito(rs.getString("favorito"));
						persons.add(p);
					}
					request.setAttribute("persons", persons);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
				
				
				
				

				request.getRequestDispatcher("/homeRecruiter.jsp").include(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		

	}

}
