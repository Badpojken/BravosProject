package negocios;

import negocios.beans.Produto;

public class TesteControladoresEtc {

	public static void main(String[] args) {

		ControladorProdutos produto = new ControladorProdutos();
		Produto p = new Produto(9, "X-Burger", 1);
		p.setPrecoTotal();
		produto.cadastrar(p);
		System.out.println(produto);
		p.setEstoque(true);
		produto.adicionarDescricao(p.getNomeProduto(), "Hamburguer, etc");
		produto.pausarProduto(p.getNomeProduto()); // PAUSANDO PRODUTO, DEVE APARECER FALSE NO PROX SYSOUT
		System.out.println(p.temEstoque());
		produto.despausarProduto(p.getNomeProduto()); //DESPAUSANDO...PROXIMO SYSOUT DEVE SER TRUE
		System.out.println(p.temEstoque());
		System.out.println("DescricaoHamburguer="+p.getDescricaoProduto());
		produto.descadastrar(p.getNomeProduto());
		System.out.println(produto);
		
	}

}
