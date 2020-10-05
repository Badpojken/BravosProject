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

	public String getEnderešo() {
		return endereco;
	}

	public void setEnderešo(String enderešo) {
		this.endereco = enderešo;
	}

	public boolean equals(Pessoa p) {
		boolean resultado = false;
		if (p != null && p.getEnderešo() != null && p.getNome() != null && this.nome.equals(p.nome)
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
