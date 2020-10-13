package dados;

import java.util.ArrayList;

import negocios.beans.*;

import negocios.*;

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
		
        
		RepositorioAdministrador a = new RepositorioAdministrador();
		a.cadastrarAdministrador("Lenon", "Casa");
		System.out.println(a.procurar("Lenon", "Casa"));
		System.out.println(a);
		a.remover("Lenon", "Casa");
		System.out.println(a);

		RepositorioFuncionario f = new RepositorioFuncionario();
		f.cadastrarFuncionario("Joao", "Casa");
		System.out.println(f.procurar("Joao", "Casa"));
		System.out.println(f);
		f.remover("Joao", "Casa");
		System.out.println(f);
        */
		RepositorioProdutos p = new RepositorioProdutos();
		Produto p1 = new Produto(10, "BigCheddar", 0);
		Produto p2 = new Produto(11, "CreamBacon", 0);
		p.criarProduto(p1);
		p.criarProduto(p2);
		System.out.println(p);
		
		
		
		//PARA CADA PEDIDO, SE CRIA UM ARRAYLIST DE PRODUTO!
		RepositorioPedidos y = new RepositorioPedidos();
		Cliente c = new Cliente ("Chagas", "Teste");
		Cliente c2= new Cliente ("Lenon", "Av Conselheiro");
		Funcionario f1 = new Funcionario ("Joao", "Casa B");
		Funcionario f2 = new Funcionario ("Joao", "Casa A");
		ArrayList<Produto> produtosCarrinho = new ArrayList<Produto>();
		ArrayList<Produto> produtosCarrinho2 = new ArrayList<Produto>();
		Produto pr1 = new Produto (10, "Batata", 3);
		Produto pr4 = new Produto (20, "Bravos", 2);
		Produto pr2 = new Produto (10, "Batata", 2);
		pr1.setPrecoTotal();
		pr2.setPrecoTotal();
		pr4.setPrecoTotal();
		produtosCarrinho.add(pr1);
		produtosCarrinho.add(pr4);
		produtosCarrinho2.add(pr2);
		Pedido pedido = new Pedido (produtosCarrinho, f1, c);
		Pedido pedido2 = new Pedido (produtosCarrinho2, f2, c2);
		pedido.calcPrecoTotal();
		pedido2.calcPrecoTotal();
		pedido.dataHorarioPedido();
		pedido2.dataHorarioPedido();
		y.addPedido(pedido);
		y.addPedido(pedido2);
		System.out.println(y);
		

	}
}
