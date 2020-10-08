package dados;

import negocios.beans.*;

public class Teste {

	public static void main(String[] args) {

		RepositorioClientes r = new RepositorioClientes();
		r.cadastrarCliente("Lenon", "Teste");
		r.cadastrarCliente("Chagas", "Ponte");
		System.out.println(r);
		r.remover("Lenon", "Teste");
		System.out.println(r.procurar("Lenon", "Teste"));		
		

		RepositorioAdministrador a = new RepositorioAdministrador();
		a.cadastrarAdministrador("Lenon", "Ponte");
		System.out.println(a.procurar("Lenon", "Ponte"));
		System.out.println(a);
		a.remover("Lenon", "Ponte");
		System.out.println(a);

		RepositorioFuncionario f = new RepositorioFuncionario();
		f.cadastrarFuncionario("Joao", "Casa");
		System.out.println(f.procurar("Joao", "Casa"));
		System.out.println(f);
		f.remover("Joao", "Casa");
		System.out.println(f);

		RepositorioProdutos p = new RepositorioProdutos();
		p.criarProduto(10, "Bravos");
		p.criarProduto(11, "Khal");
		p.existe("Bravos");
		p.existe("Peperrock");
		System.out.println(p);
		
		RepositorioPedidos y = new RepositorioPedidos();
		Cliente c = new Cliente ("Chagas", "Teste");
		Funcionario f1 = new Funcionario ("Joao", "Rua");
		Produto pr1 = new Produto (10, "Batata");
		Pedido pedido = new Pedido (pr1, 2, pr1.getPreco(), f1, c);
		pedido.calcPreco();
		y.addPedido(pedido);
		System.out.println(y);
		
		

	}
}
