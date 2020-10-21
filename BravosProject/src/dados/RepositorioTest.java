package dados;

import java.util.ArrayList;

import negocios.ProdutoQuantidade;
import negocios.beans.Cliente;
import negocios.beans.Pedido;
import negocios.beans.Produto;

public class RepositorioTest {

	public static void main(String[] args) {

		ArrayList<Produto> produtosCarrinho = new ArrayList<Produto>();
		Produto p = new Produto(10, "batata");
		Produto produto2 = new Produto(15, "Khal");
		produtosCarrinho.add(p);
		produtosCarrinho.add(produto2);
		ProdutoQuantidade pQ = new ProdutoQuantidade(p, 2);
		ProdutoQuantidade pQ1 = new ProdutoQuantidade(produto2, 2);
		pQ1.calcPrecoParcial();
		pQ.calcPrecoParcial();

		RepositorioClientes rc = new RepositorioClientes();
		Cliente c = new Cliente("alsdasd", "ASDAS");
		Cliente c1 = new Cliente("Lenon", "Casa A");
		rc.cadastrarCliente(c);
		rc.cadastrarCliente(c1);

		ArrayList<ProdutoQuantidade> ProdutoQ = new ArrayList<ProdutoQuantidade>();
		ProdutoQ.add(pQ);
		ProdutoQ.add(pQ1);
		Pedido pedido = new Pedido(ProdutoQ, rc.procurar(c1));
		pedido.dataHorarioPedido();
		pedido.calcPrecoTotal();
		System.out.println(pedido);
		RepositorioPedidos rp = new RepositorioPedidos();
		rp.addPedido(pedido);
		System.out.println(rp);
		System.out.println(rp);

	}

}
