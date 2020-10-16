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

	// PARTE DE ADICIONAR MÉTODOS EM RELAÇÃO A ATRIBUTOS DO PRODUTO (COMO SETPREÇO,
	// GETPREÇO, ETC)...

	public void adicionarDescricao(Produto p, String d) {
		this.repositorioProdutos.procurar(p);
		if (p != null) {
			p.setDescricaoProduto(d);
		}
	}

	public void pausarProduto(Produto p) {
		this.repositorioProdutos.procurar(p);
		if (p != null && p.temEstoque() == true) {
			p.setEstoque(false);
		} else {

		}
	}

	public void despausarProduto(Produto p) {

		this.repositorioProdutos.procurar(p);
		if (p != null && p.temEstoque() == false) {
			p.setEstoque(true);
		} else {

		}
	}

	public String toString() {
		return repositorioProdutos.toString();
	}

}
