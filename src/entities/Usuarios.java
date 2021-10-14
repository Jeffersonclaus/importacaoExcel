package entities;

import java.io.Serializable;

public class Usuarios implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nome;
	private String login;
	private String senha;
	private String cpf;

	
	public Usuarios() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public Usuarios(String nome, String login, String senha, String cpf) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.cpf = cpf;
	}





	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}





	@Override
	public String toString() {
		return "Usuarios [nome=" + nome + ", login=" + login + ", senha=" + senha + ", cpf=" + cpf + "]";
	}
	
	
	

}
