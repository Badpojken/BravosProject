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
			if (!this.repositorioProdutos.existe(p.getNomeProduto())) {
				this.repositorioProdutos.criarProduto(p);
				System.out.println("Portanto, criado com sucesso!");
			} else {
				System.out.println("Portanto, não foi criado!");

			}
		}
	}

	public void descadastrar(String n) {
		Produto p = this.repositorioProdutos.procurar(n);
		if (p != null) {
			this.repositorioProdutos.remover(n);
		} else {

		}

	}

	public Produto procurar(String n) {
		return this.repositorioProdutos.procurar(n);
	}

	public boolean existe(String n) {
		return this.repositorioProdutos.existe(n);
	}

	public void remover(String n) {
		this.repositorioProdutos.remover(n);
	}

	// PARTE DE ADICIONAR MÉTODOS EM RELAÇÃO A ATRIBUTOS DO PRODUTO (COMO SETPREÇO,
	// GETPREÇO, ETC)...

	public void adicionarDescricao(String n, String d) {
		Produto p = this.repositorioProdutos.procurar(n);
		if (p != null) {
			p.setDescricaoProduto(d);
		}
	}

	public void pausarProduto(String n) {
		Produto p = this.repositorioProdutos.procurar(n);
		if (p != null && p.temEstoque() == true) {
			p.setEstoque(false);
		} else {

		}
	}

	public void despausarProduto(String n) {

		Produto p = this.repositorioProdutos.procurar(n);
		if (p != null && p.temEstoque() == false) {
			p.setEstoque(true);
		} else {

		}
	}

	public String toString() {
		return repositorioProdutos.toString();
	}

}
