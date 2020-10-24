package negocios.beans;

public class Produto {

	private double preco;
	private String nomeProduto;
	private String descricaoProduto;

	public Produto() {

	}

	public Produto(double p, String np) {
		this.preco = p;
		this.nomeProduto = np;
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


	public String toString() {
		return "{\"nomeProduto\"" + ":" + "\"" + nomeProduto + "\"" +","+ "\"preco\"" + ":" + preco + ","+ "\"descricaoProduto\"" + ":" + "\"" + descricaoProduto + "\"" +"}";                                              
	}

	public boolean equals(Produto p) {
		boolean resultado = false;
		if ((p != null) && (this.getNomeProduto() == p.getNomeProduto())) {
			resultado = true;
		}
		return resultado;
	}

}
