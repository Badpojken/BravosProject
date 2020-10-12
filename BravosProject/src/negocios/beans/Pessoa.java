package negocios.beans;

public abstract class Pessoa {

	protected String nome;
	protected String endereco;
	protected String login;
	protected String senha;

	public Pessoa() {

	}

	public Pessoa(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereço() {
		return endereco;
	}

	public void setEndereço(String endereço) {
		this.endereco = endereço;
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

	public boolean equals(Pessoa p) {
		boolean resultado = false;
		if (p != null && p.getEndereço() != null && p.getNome() != null && this.nome.equals(p.nome)
				&& this.endereco.equals(p.endereco)) {
			resultado = true;
		} else {
			resultado = false;
		}
		return resultado;
	}

	public String toString() {
		return "(Nome: " + nome + ", Endereco: " + endereco + ")";
	}

}
