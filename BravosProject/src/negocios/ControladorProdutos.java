package negocios;

import dados.RepositorioProdutos;
import negocios.beans.Produto;

public class ControladorProdutos {

	private RepositorioProdutos repositorioProdutos;

	public ControladorProdutos() {
		this.repositorioProdutos = new RepositorioProdutos();
	}

	public void cadastrar(Produto p) {
		if (p != null) {
			if (!this.repositorioProdutos.existe(p)) {
				this.repositorioProdutos.criarProduto(p);
				System.out.println("Portanto, criado com sucesso!");
			} else {
				System.out.println("Portanto, não foi criado!");

			}
		}
	}

	public void descadastrar(Produto p) {
		this.repositorioProdutos.procurar(p);
		if (p != null) {
			this.repositorioProdutos.remover(p);
		} else {

		}

	}

	public Produto procurar(Produto p) {
		return this.repositorioProdutos.procurar(p);
	}

	public boolean existe(Produto p) {
		return this.repositorioProdutos.existe(p);
	}

	public void remover(Produto p) {
		this.repositorioProdutos.remover(p);
	}

	public void adicionarDescricao(Produto p, String d) {
		this.repositorioProdutos.procurar(p);
		if (p != null) {
			p.setDescricaoProduto(d);
		}
	}

	public String toString() {
		return repositorioProdutos.toString();
	}

}
