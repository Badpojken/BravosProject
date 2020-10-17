package dados;

import java.util.ArrayList;
import negocios.ProdutoQuantidade;
import negocios.beans.*;

public class Teste {

	public static void main(String[] args) {
		/*
		 * RepositorioClientes r = new RepositorioClientes();
		 * r.cadastrarCliente("Lenon", "Teste"); r.cadastrarCliente("Chagas", "Casa");
		 * System.out.println(r); r.remover("Lenon", "Teste");
		 * System.out.println(r.procurar("Lenon", "Teste"));
		 * System.out.println(r.procurar("Chagas", "Casa"));
		 */

		RepositorioProdutos rp = new RepositorioProdutos();
		Produto pp1 = new Produto(10, "BigCheddar");
		Produto p2 = new Produto(11, "CreamBacon");
		rp.salvarEmJson();
		rp.criarProduto(pp1);
		rp.salvarEmJson();
		rp.criarProduto(p2);
		rp.salvarEmJson();
		rp.remover(pp1);
		rp.salvarEmJson();
		rp.criarProduto(pp1);
		rp.salvarEmJson();
		System.out.println(rp);

		// PARA CADA PEDIDO, SE CRIA UM ARRAYLIST DE PRODUTO!
        /*
		RepositorioProdutos bomdia = new RepositorioProdutos();
		bomdia.criarProduto(new Produto(10, "bomdia"));
		bomdia.criarProduto(new Produto(5, "boanoite"));
		bomdia.salvarEmJson();
		bomdia.copiandoDoJson();
		*/
		Produto p = new Produto(10, "batata");
		Produto produto2 = new Produto(15, "Khal");
		ProdutoQuantidade pQ = new ProdutoQuantidade(p, 1);
		ArrayList<ProdutoQuantidade> aPQ = new ArrayList<>();
		aPQ.add(pQ);
		pQ.calcPrecoParcial();
		p.setDescricaoProduto("Teste");
		Cliente c = new Cliente("alsdasd", "ASDAS");
		Pedido p1 = new Pedido(aPQ, c);
		RepositorioPedidos rP1 = new RepositorioPedidos();
		rP1.addPedido(p1);
		p1.dataHorarioPedido();
		p1.calcPrecoTotal();
		rP1.salvarEmJson();
		rP1.copiandoDoJson();
		System.out.println(rP1.toString());
		rP1.removePedido(p1);
		rP1.removerDoJson();
		System.out.println(rP1); /*
									 * 
									 * Produto produto = new Produto(12, "Khal"); ProdutoQuantidade pQ1 = new
									 * ProdutoQuantidade(produto , 1); ArrayList<ProdutoQuantidade> aPQ1 = new
									 * ArrayList<>(); aPQ1.add(pQ1); Pedido pedido = new Pedido(aPQ1,c);
									 * rP1.addPedido(pedido); rP1.salvarEmJson(); rP1.copiandoDoJson();
									 * 
									 * System.out.println(rP1);
									 */

		/*
		 * RepositorioClientes rC = new RepositorioClientes(); rC.cadastrarCliente(c);
		 * rC.salvarEmJson(); rC.copiandoDoJson(); System.out.println(rC);
		 */
	}
}
