package negocios;

import dados.RepositorioClientes;
import negocios.beans.Cliente;

public class ControladorClientes {

	private RepositorioClientes repositorioClientes;

	public ControladorClientes() {
		this.repositorioClientes = new RepositorioClientes();
	}

	public void cadastrar(Cliente c) {
		if (c != null) {
			if (!this.repositorioClientes.existe(c)) {
				this.repositorioClientes.cadastrarCliente(c);
				System.out.println("Portanto, criado com sucesso!");
			} else {
				System.out.println("Portanto, não foi criado!");

			}
		}
	}

	public void descadastrar(Cliente c) {
		this.repositorioClientes.procurar(c);
		if (c != null) {
			this.repositorioClientes.remover(c);
		} else {

		}

	}

	public Cliente procurar(Cliente c) {
		return this.repositorioClientes.procurar(c);
	}

	public boolean existe(Cliente c) {
		return this.repositorioClientes.existe(c);
	}

	public void remover(Cliente c) {
		this.repositorioClientes.remover(c);
	}
	
	public void salvar() {
		this.repositorioClientes.salvarEmJson();
	}
	
	public void transformarJson() {
		this.repositorioClientes.copiandoDoJson();
	}

	@Override
	public String toString() {
		return repositorioClientes.toString();
	}

}
