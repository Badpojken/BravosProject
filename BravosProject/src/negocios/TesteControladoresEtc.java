package negocios;

import java.util.ArrayList;

import negocios.beans.Cliente;
import negocios.beans.Pedido;
import negocios.beans.Produto;
public class TesteControladoresEtc {

	public static void main(String[] args) {

		Cliente c = new Cliente("Chagas", "Apartamento B");
		Produto p = new Produto(20, "Bravos");
		Produto p2 = new Produto(5, "Batata");
		ControladorProdutos cp = new ControladorProdutos();
		cp.cadastrar(p);
		System.out.println(cp);
		ProdutoQuantidade pq = new ProdutoQuantidade(cp.procurar(p), 2);
		ProdutoQuantidade pq2 = new ProdutoQuantidade(p2, 2);
		pq.calcPrecoParcial();
		pq2.calcPrecoParcial();
		ArrayList<ProdutoQuantidade> pqList = new ArrayList<ProdutoQuantidade>();
		pqList.add(pq);
		pqList.add(pq2);
		Pedido pedidoUm = new Pedido(pqList, c);
		pedidoUm.calcPrecoTotal();
		pedidoUm.dataHorarioPedido();
		System.out.println(pedidoUm);
         
	}

}
