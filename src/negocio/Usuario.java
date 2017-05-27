package negocio;

import java.util.List;

public class Usuario {
	
	private int id;
	private String login;
	private String nome;
	private String senha;
	private List<Musica> musicas;
	
	
	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}

	public Usuario(int id, String nome, String login, String senha) {
		this(nome, login, senha);
		this.setId(id);
	}
	
	public Usuario(String nome, String login, String senha) {
		this.setNome(nome);
		this.setLogin(login);
		this.setSenha(senha);
	}
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
