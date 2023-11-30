package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Candidato;
import model.Person;

public class CandidatoDAO {
	
	

	public List<Person> insert(Person person,HttpServletRequest request, HttpServletResponse response) {

		String sql = "insert into PERSON(FIRST_NAME,email,cpf,senha,celular,curriculoNome,profissao,experiencia,educacao,infoExtra,chaves) values (?,?,?,?,?,?,?,?,?,?,?)";

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

			int row = pStmt.executeUpdate();
			
			
			
			

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		 sql = "select * from PERSON where cpf=?";

		 conn = null;
		
		try {
			
			conn = (Connection) request.getServletContext().getAttribute("connection");
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, person.getCpf());
			

			ResultSet rs = pStmt.executeQuery();
			
			List<Person> persons = new ArrayList<>();
			while (rs.next()) {
				Person p = new Person();
				p.setId(rs.getLong("ID"));
				p.setNomeCurriculo(rs.getString("curriculoNome"));
				p.setProfissao(rs.getString("profissao"));
				p.setChave(rs.getString("chaves"));
				
				persons.add(p);
			}
			
			return persons;
							
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	

	public List<Person> update(String id, Person person,HttpServletRequest request, HttpServletResponse response) {
		
		
		String sql = "update PERSON set FIRST_NAME=?,email=?,cpf=?,senha=?,celular=?,curriculoNome=?,profissao=?,experiencia=?,educacao=?,infoExtra=?,chaves=? where id=?";
		
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
			pStmt.setInt(12, Integer.parseInt(id));

			int row = pStmt.executeUpdate();

			
			
			
			
			
			
			sql = "select * from PERSON where cpf=?";
			 conn = null;
			try {
				conn = (Connection) request.getServletContext().getAttribute("connection");
//				Statement stmt = conn.createStatement();
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, person.getCpf());
				ResultSet rs = stmt.executeQuery();
				
				List<Person> persons = new ArrayList<>();
				while (rs.next()) {
					Person p = new Person();
					p.setId(rs.getLong("ID"));
					p.setNomeCurriculo(rs.getString("curriculoNome"));
					p.setProfissao(rs.getString("profissao"));
					p.setChave(rs.getString("chaves"));
					persons.add(p);
				}
				request.setAttribute("persons", persons);
				return persons;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}

	public Person edit(HttpServletRequest request, HttpServletResponse response) {
		String sql = "select * from PERSON where id=?";
		Connection conn = null;
		try {
			conn = (Connection) request.getServletContext().getAttribute("connection");
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(request.getParameter("id")));
			ResultSet rs = stmt.executeQuery();
			Person person = new Person();
			while (rs.next()) {
				
				person.setId(rs.getLong("ID"));
				person.setNome(rs.getString("FIRST_NAME"));
				person.setEmail(rs.getString("email"));
				person.setCpf(rs.getString("cpf"));
				person.setSenha(rs.getString("senha"));
				person.setCelular(rs.getString("celular"));
				person.setNomeCurriculo(rs.getString("curriculoNome"));
				person.setProfissao(rs.getString("profissao"));
				person.setExperiencia(rs.getString("experiencia"));
				person.setEducacao(rs.getString("educacao"));
				person.setExtra(rs.getString("infoExtra"));
				person.setChave(rs.getString("chaves"));
			}
			
			return person;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List<Person> delete(HttpServletRequest request, HttpServletResponse response) {
		
String cpf = "";
		
		
		String sql = "select * from PERSON where id=?";
		Connection conn = null;
		try {
			System.out.println(request.getParameter("id"));
			conn = (Connection) request.getServletContext().getAttribute("connection");
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, request.getParameter("id"));
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				cpf = rs.getString("cpf");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		 sql = "Delete from PERSON where id=?";

		 conn = null;
		try {
			conn = (Connection) request.getServletContext().getAttribute("connection");
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(request.getParameter("id")));
			int row = stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		sql = "select * from PERSON where cpf=?";
		 conn = null;
		try {
			conn = (Connection) request.getServletContext().getAttribute("connection");
//			Statement stmt = conn.createStatement();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			
			List<Person> persons = new ArrayList<>();
			while (rs.next()) {
				Person p = new Person();
				p.setId(rs.getLong("ID"));
				p.setNomeCurriculo(rs.getString("curriculoNome"));
				p.setProfissao(rs.getString("profissao"));
				p.setChave(rs.getString("chaves"));
				persons.add(p);
			}
			request.setAttribute("persons", persons);
			return persons;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	public void insertCandidato(Candidato candidato,HttpServletRequest request, HttpServletResponse response) {

		String sql = "insert into candidato(nome,email,cpf,senha,celular) values (?,?,?,?,?)";

		Connection conn = null;
		
		try {
			
			conn = (Connection) request.getServletContext().getAttribute("connection");
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, candidato.getNome());
			pStmt.setString(2, candidato.getEmail());
			pStmt.setString(3, candidato.getCpf());
			pStmt.setString(4, candidato.getSenha());
			pStmt.setString(5, candidato.getCelular());
			

			int row = pStmt.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public String searchUser(String username, String senha,HttpServletRequest request, HttpServletResponse response) {
		
		String cpf = "";
		
		
		String sql = "select * from candidato where nome=? and senha=?";
		Connection conn = null;
		try {
			
			conn = (Connection) request.getServletContext().getAttribute("connection");
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				cpf = rs.getString("cpf");
			}
			
		return cpf;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	
	
	public List<Person> list(Person person,HttpServletRequest request, HttpServletResponse response) {

		String sql = "";

		Connection conn = null;
		
		 sql = "select * from PERSON where cpf=?";

		 conn = null;
		
		try {
			
			conn = (Connection) request.getServletContext().getAttribute("connection");
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, person.getCpf());
			

			ResultSet rs = pStmt.executeQuery();
			
			List<Person> persons = new ArrayList<>();
			while (rs.next()) {
				Person p = new Person();
				p.setId(rs.getLong("ID"));
				p.setNomeCurriculo(rs.getString("curriculoNome"));
				p.setProfissao(rs.getString("profissao"));
				p.setChave(rs.getString("chaves"));
				
				persons.add(p);
			}
			
			return persons;
							
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}



}
