package dados;

import java.util.ArrayList;

import negocios.beans.Produto;

public class RepositorioProdutos {
    //DUVIDA EM RELAÇÃO AO ATRIBUTO ARRAYLIST<PRODUTO> SER STATIC OU NÃO. 
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private int tamanho;

	public RepositorioProdutos() {

	}

	public void criarProduto(double p, String n) {
		Produto product = new Produto();
		product.setNomeProduto(n);
		product.setPreco(p);
		this.produtos.add(product);
		tamanho = this.produtos.size();

	}

	private int procurarIndice(Produto p) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < tamanho)) {
			if (p.equals(this.produtos.get(i))) {
				achou = true;
			} else {
				i++;
			}
		}
		return i;
	}

	public Produto procurar(String n) {
		Produto product = new Produto();
		product.setNomeProduto(n);
		int i = this.procurarIndice(product);
		Produto resultado = null;
		if (i != this.produtos.size()) {
			resultado = this.produtos.get(i);
			System.out.println("Produto encontrado.");
		}
		else {
			System.out.println("Produto não encontrado.");
		}
		return resultado;
	}
	public boolean existe(String n) {
		Produto product = new Produto();
		product.setNomeProduto(n);
		boolean existe = false;
		int indice = this.procurarIndice(product);
		if (indice != tamanho) {
			existe = true;
			System.out.println("O produto existe");
		} else {
			System.out.println("O produto não existe");
		}
		return existe;
	}
	public void remover(String n) {
		Produto product = new Produto();
		product.setNomeProduto(n);
		int i = this.procurarIndice(product);
		if (i != tamanho) {
			this.produtos.remove(i);
			System.out.println("Produto removido.");
		} else {
			System.out.println("Produto não encontrado. Portanto, não foi removido.");
		}
		tamanho = this.produtos.size();
	}

	public String toString() {
		return "Produtos:" + produtos + "";
	}

}
