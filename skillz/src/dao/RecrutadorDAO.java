package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Candidato;
import model.Person;
import model.Recrutador;

public class RecrutadorDAO {
	
	public List<Person> selectall(HttpServletRequest request, HttpServletResponse response) {
		
		String sql = "select * from PERSON ";
		Connection conn = null;
		try {
			conn = (Connection) request.getServletContext().getAttribute("connection");
//			Statement stmt = conn.createStatement();
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
			return persons;
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
	
	
	public List<Person> delete(HttpServletRequest request, HttpServletResponse response){
		
		String cpf = "";
		
		System.out.println("ola");
		String sql = "select * from PERSON where id=?";
		Connection conn = null;
		try {
			
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
			return persons;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Person> search(String chave,HttpServletRequest request, HttpServletResponse response){
		
		
		String sql = "select * from PERSON where chaves like ?";
		Connection conn = null;
		try {
			conn = (Connection) request.getServletContext().getAttribute("connection");
//			Statement stmt = conn.createStatement();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+chave+"%");
			ResultSet rs = stmt.executeQuery();
			
			List<Person> persons = new ArrayList<>();
			while (rs.next()) {
				Person p = new Person();
				p.setId(rs.getLong("ID"));
				p.setNomeCurriculo(rs.getString("curriculoNome"));
				p.setProfissao(rs.getString("profissao"));
				p.setFavorito(rs.getString("favorito"));
				p.setChave(rs.getString("chaves"));
				persons.add(p);
			}
			return persons;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public void insertRecrutador(Recrutador recrutador,HttpServletRequest request, HttpServletResponse response) {

		String sql = "insert into recrutador(nome,email,cnpj,empresa,senha,telefone) values (?,?,?,?,?,?)";

		Connection conn = null;
		
		try {
			
			conn = (Connection) request.getServletContext().getAttribute("connection");
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setString(1, recrutador.getNome());
			pStmt.setString(2, recrutador.getEmail());
			pStmt.setString(3, recrutador.getCnpj());
			pStmt.setString(4, recrutador.getEmpresa());
			pStmt.setString(5, recrutador.getSenha());
			pStmt.setString(6, recrutador.getTelefone());
			

			int row = pStmt.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
}
