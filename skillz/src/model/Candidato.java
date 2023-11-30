package model;

public class Candidato {
	private String nome;
	private long id;
	private String email;
	private String cpf;
	private String senha;
	private String celular;
	
	
	
	

	public Candidato(long id,String nome, String email, String cpf, String senha, String celular) {
		super();
		this.nome = nome;
		this.id = id;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
		this.celular = celular;
	}
	
	public Candidato(String nome, String email, String cpf, String senha, String celular) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.senha = senha;
		this.celular = celular;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}
	
}
