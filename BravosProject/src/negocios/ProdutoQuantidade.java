package negocios;

import negocios.beans.Produto;

public class ProdutoQuantidade {

	private Produto produto = new Produto();
	private int quantidade;
	private double precoTotal;

	public ProdutoQuantidade() {

	}

	public ProdutoQuantidade(Produto p, int q) {
		this.produto = p;
		this.quantidade = q;
	}

	public Produto getProduto() {
		return produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public void calcPrecoParcial() {
		precoTotal = this.produto.getPreco() * this.quantidade;
	}

	@Override
	public String toString() {
		return "{\"produto\"" + ":" + produto +","+ "\"quantidade\"" + ":" + quantidade + "\"precoTotal\"" + ":" + precoTotal + "}";
	}

}
