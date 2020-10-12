package negocios.beans;

public class Produto {

	private double preco;
	private String nomeProduto;
	private String descricaoProduto;
	private boolean estoque;
	private int quantidade;

	public Produto() {

	}

	public Produto(double p, String np, int pq) {
		this.preco = p;
		this.nomeProduto = np;
		this.quantidade = pq;
		this.descricaoProduto = null;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public boolean temEstoque() {
		return estoque;
	}

	public void setEstoque(boolean estoque) {
		this.estoque = estoque;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String toString() {
		return nomeProduto + "(Preco=" + preco + ", Quantidade=" + quantidade + ")";
	}

	public boolean equals(Produto p) {
		boolean resultado = false;
		if ((p != null) && (this.getNomeProduto() == p.getNomeProduto())
				&& (this.getDescricaoProduto() == p.getDescricaoProduto())) {
			resultado = true;
		}
		return resultado;
	}

}
