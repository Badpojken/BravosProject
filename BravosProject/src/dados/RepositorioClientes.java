package dados;

import java.util.ArrayList;

import negocios.Cliente;

public class RepositorioClientes {

	private ArrayList<Cliente> clientes;
	private int proximoCliente = 0;

	public void cadastrarCliente(Cliente c) {
		clientes.add(c);
		this.proximoCliente = this.proximoCliente + 1;
	}

	public Cliente procurar(Cliente c) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.proximoCliente)) {
			if (c.equals(this.clientes.get(i))) {
				achou = true;
			} else {
				i++;
			}

		}
		Cliente resultado = null;
		if (i != this.proximoCliente) {
			resultado = this.clientes.get(i);
		}
		return resultado;
	}

}
