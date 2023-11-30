package model;

public class Curriculo {
	
	private String nome;
	private String profissao;
	private String experiencia;
	private String educacao;
	private String extra;
	private String palavrachave;
	
	public Curriculo() {
		
	}
	
	public Curriculo(String nome, String profissao, String experiencia, String educacao, String extra,
			String palavrachave) {
		super();
		this.nome = nome;
		this.profissao = profissao;
		this.experiencia = experiencia;
		this.educacao = educacao;
		this.extra = extra;
		this.palavrachave = palavrachave;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getPalavrachave() {
		return palavrachave;
	}
	public void setPalavrachave(String palavrachave) {
		this.palavrachave = palavrachave;
	}
}
