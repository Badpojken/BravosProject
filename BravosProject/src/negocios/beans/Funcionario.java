package negocios.beans;

public class Funcionario extends Pessoa {

	private double caixaApurado;
	
	public Funcionario() {

	}
	public Funcionario(String n, String e) {
		this.setNome(n);
		this.setEndereço(e);
	}

}
