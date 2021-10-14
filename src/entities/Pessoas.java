package entities;

public class Pessoas {

	private String name;
	private String email;
	private Integer idade;

	public Pessoas() {

	}

	public Pessoas(String name, String email, Integer idade) {
		this.name = name;
		this.email = email;
		this.idade = idade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Pessoas [name=" + name + ", email=" + email + ", idade=" + idade + "]";
	}

}
