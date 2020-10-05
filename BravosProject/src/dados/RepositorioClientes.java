package dados;

import java.util.ArrayList;
import negocios.Cliente;

public class RepositorioClientes {

	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private int tamanho;

	public RepositorioClientes() {
	}

	public void cadastrarCliente(String n, String e) {
		Cliente cliente = new Cliente();
		cliente.setNome(n);
		cliente.setEndereço(e);
		this.clientes.add(cliente);
		tamanho = this.clientes.size();
	}

	private int procurarIndice(Cliente c) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < tamanho)) {
			if (c.equals(this.clientes.get(i))) {
				achou = true;
			} else {
				i++;
			}
		}
		return i;
	}

	public Cliente procurar(String n, String e) {
		Cliente c = new Cliente();
		c.setNome(n);
		c.setEndereço(e);
		int i = this.procurarIndice(c);
		Cliente resultado = null;
		if (i != this.clientes.size()) {
			resultado = this.clientes.get(i);
		}
		return resultado;
	}

	public boolean existe(String n, String e) {
		Cliente c = new Cliente();
		c.setEndereço(e);
		c.setNome(n);
		boolean existe = false;
		int indice = this.procurarIndice(c);
		if (indice != tamanho) {
			existe = true;
			System.out.println("A conta existe");
		} else {
			System.out.println("A conta não existe");
		}
		return existe;
	}

	public void remover(String n, String e) {
		Cliente c = new Cliente();
		c.setEndereço(e);
		c.setNome(n);
		int i = this.procurarIndice(c);
		if (i != tamanho) {
			this.clientes.remove(i);
			System.out.println("Conta removida.");
		} else {
			System.out.println("Conta não encontrada. Portanto, não foi removida.");
		}
		tamanho = this.clientes.size();
	}

	public String toString() {
		return "Clientes: "+ clientes;
	}

}
