package model;

public class Person {

	private long id;
	private String nome;
	private String email;
	private String cpf;
	private String senha;
	private String celular;
	private String nomeCurriculo;
	private String profissao;
	private String experiencia;
	private String educacao;
	private String extra;
	private String chave;
	private String favorito;
	
	
	
	
	public Person(String cpf) {
		super();
		this.cpf = cpf;
	}

	public String getFavorito() {
		return favorito;
	}

	public void setFavorito(String favorito) {
		this.favorito = favorito;
	}

	public Person() {
		
	}
	
	public Person(String nome, String email, String cpf,String senha, String celular, String nomeCurriculo,String profissao, String experiencia, String educacao, String extra, String chave){
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.celular = celular;
		this.nomeCurriculo = nomeCurriculo;
		this.profissao = profissao;
		this.experiencia = experiencia;
		this.educacao = educacao;
		this.extra = extra;
		this.chave = chave;
		
		
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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

	public String getNomeCurriculo() {
		return nomeCurriculo;
	}

	public void setNomeCurriculo(String nomeCurriculo) {
		this.nomeCurriculo = nomeCurriculo;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public String getEducacao() {
		return educacao;
	}

	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}
	
	
	
}
