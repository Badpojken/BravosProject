package negocios;

import dados.RepositorioPedidos;
import negocios.beans.Pedido;

public class ControladorPedidos {

	private RepositorioPedidos repositorioPedidos;

	public ControladorPedidos() {
		this.repositorioPedidos = new RepositorioPedidos();
	}

	public void cadastrar(Pedido p) {
		if (p != null) {
			if (!this.repositorioPedidos.existe(p)) {
				this.repositorioPedidos.addPedido(p);
				;
				System.out.println("Portanto, criado com sucesso!");
			} else {
				System.out.println("Portanto, não foi criado!");

			}
		}
	}

	public void descadastrar(Pedido p) {
		this.repositorioPedidos.procurar(p);
		if (p != null) {
			this.repositorioPedidos.remover(p);
		} else {

		}

	}

	public Pedido procurar(Pedido p) {
		return this.repositorioPedidos.procurar(p);
	}

	public boolean existe(Pedido p) {
		return this.repositorioPedidos.existe(p);
	}

	public void remover(Pedido p) {
		this.repositorioPedidos.remover(p);
	}

}
