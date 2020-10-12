package negocios.beans;

public class Cliente extends Pessoa {

	private int pontosCliente;

	public Cliente() {

	}

	public Cliente(String n, String e) {
		super(n, e);
	}

	public int getPontosCliente() {
		return pontosCliente;
	}

	public void setPontosCliente(int pontosCliente) {
		this.pontosCliente = pontosCliente;
	}

}
