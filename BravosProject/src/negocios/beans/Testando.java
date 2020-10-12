package negocios.beans;

import java.util.ArrayList;

public class Testando {

	public static void main(String[] args) {
		Cliente c = new Cliente("Chagas", "Apartamento B");
		Cliente c1 = new Cliente("Lenon", "Apartamento A");
		Funcionario f1 = new Funcionario("Joao", "Casa B");
		Produto pr1 = new Produto(20, "Bravos", 3);
		Produto pr2 = new Produto(5, "Batata", 2);
		Produto pr3 = new Produto(10, "Khal", 1);
		ArrayList<Produto> produtosArray = new ArrayList<Produto>();
		ArrayList<Produto> produtosArray2 = new ArrayList<Produto>();
		produtosArray.add(pr1);
		produtosArray2.add(pr2);
		produtosArray2.add(pr3);
		ArrayList<Pedido> pedidos = new ArrayList <Pedido>();
		Pedido pedido = new Pedido(produtosArray, f1, c);
		Pedido pedido2 = new Pedido(produtosArray2, f1, c1);
		pedidos.add(pedido);
		pedidos.add(pedido2);
		pedido.calcPrecoTotal();
		pedido2.calcPrecoTotal();
		System.out.println(pedidos);
	
		
		
		
		
		
	
		
		
		
		
		
		
	}

}
