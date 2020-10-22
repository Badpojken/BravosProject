package negocios.beans;

public class Cliente {

	private String nome;
	private String endereco;
	private String login;
	private String senha;
	private int pontosCliente;

	public Cliente() {

	}

	public Cliente(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereço) {
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

	public int getPontosCliente() {
		return pontosCliente;
	}

	public void setPontosCliente(int pontosCliente) {
		this.pontosCliente = pontosCliente;
	}

	public boolean equals(Cliente p) {
		boolean resultado = false;
		if (p != null && p.getEndereco() != null && p.getNome() != null && this.nome.equals(p.nome)
				&& this.endereco.equals(p.endereco)) {
			resultado = true;
		} else {
			resultado = false;
		}
		return resultado;
	}
	
	public boolean equalsUsuario(Cliente p) {
		boolean resultado = false;
		if (p != null && p.getLogin() != null && p.getSenha() != null && this.senha.equals(p.senha) && this.login.equals(p.login)) {
			resultado = true;
		} else {
			resultado = false;
		}
		return resultado;
	}

	public String toString() {
		return "{" + "\"nome\"" +":"+ "\"" + nome + "\"," + "\"endereco\"" + ":" + "\"" + endereco + "\"" + "}";
		
	}
	


}
