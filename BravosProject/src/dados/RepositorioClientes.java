package dados;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import negocios.beans.Cliente;

public class RepositorioClientes {

	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private int tamanho;

	public RepositorioClientes() {
	}

	public void cadastrarCliente(Cliente c) {
		this.clientes.add(c);
		tamanho = this.clientes.size();
	}

	private int procurarIndice(Cliente c) {
		int i = 0;
		
		///sdfasdfasdfasdfsds
		
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

	// ATUALIZAR DEPOIS
	public Cliente procurar(Cliente c) {
		int i = this.procurarIndice(c);
		Cliente resultado = null;
		if (i != this.clientes.size()) {
			resultado = c;

		}
		return resultado;
	}

	public boolean existe(Cliente c) {
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

	public void remover(Cliente c) {
		int i = this.procurarIndice(c);
		if (i != tamanho) {
			this.clientes.remove(i);
			System.out.println("Cliente removido.");
		} else {
			System.out.println("Cliente não encontrado. Portanto, não foi removido.");
		}
		tamanho = this.clientes.size();
	}

	public String toString() {
		return "Clientes:" + clientes;
	}

}
