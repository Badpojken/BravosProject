package negocios;

public class Pessoa {

	private String nome;
	private String endereco;

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

	public String getEndere�o() {
		return endereco;
	}

	public void setEndere�o(String endere�o) {
		this.endereco = endere�o;
	}

	public boolean equals(Pessoa p) {
		boolean resultado = false;
		if (p != null && p.getEndere�o() != null && p.getNome() != null && this.nome.equals(p.nome)
				&& this.endereco.equals(p.endereco)) {
			resultado = true;
		} else {
			resultado = false;
		}
		return resultado;
	}

	public String toString() {
		return "(Nome: "+ nome +", Endereco: "+endereco+")";
	}
	

}
