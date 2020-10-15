package dados;

import java.util.ArrayList;
import negocios.*;
import negocios.ProdutoQuantidade;
import negocios.beans.*;


public class Teste {

	public static void main(String[] args) {
 /*
		RepositorioClientes r = new RepositorioClientes();
		r.cadastrarCliente("Lenon", "Teste");
		r.cadastrarCliente("Chagas", "Casa");
		System.out.println(r);
		r.remover("Lenon", "Teste");
		System.out.println(r.procurar("Lenon", "Teste"));		
		System.out.println(r.procurar("Chagas", "Casa"));	
		
		RepositorioProdutos p = new RepositorioProdutos();
		Produto p1 = new Produto(10, "BigCheddar", 0);
		Produto p2 = new Produto(11, "CreamBacon", 0);
		p.criarProduto(p1);
		p.criarProduto(p2);
		System.out.println(p);
		
		
		*/
		//PARA CADA PEDIDO, SE CRIA UM ARRAYLIST DE PRODUTO!
		
		
		
		RepositorioProdutos bomdia = new RepositorioProdutos();
		//bomdia.criarProduto(new Produto(10, "bomdia"));
		//bomdia.criarProduto(new Produto(5, "boanoite"));
		//bomdia.salvarEmJson();
		//bomdia.copiandoDoJson();
		//System.out.println(bomdia);
		
		
		Produto p = new Produto(10, "batata");
		ProdutoQuantidade pQ = new ProdutoQuantidade(p , 1);
		ArrayList<ProdutoQuantidade> aPQ = new ArrayList<>();
		aPQ.add(pQ);
		Cliente c = new Cliente("alsdasd", "ASDAS");
		Pedido p1 = new Pedido(aPQ,c);
		
		RepositorioPedidos rP1 = new RepositorioPedidos();
		rP1.addPedido(p1);
		rP1.salvarEmJson();
		rP1.copiandoDoJson();
		System.out.println(rP1);
		
		//RepositorioClientes rC = new RepositorioClientes();
		//rC.cadastrarCliente(c);
		//rC.salvarEmJson();
		//rC.copiandoDoJson();
		//System.out.println(rC);
		
	}
}
