package dados;

import negocios.Cliente;

public class Teste {

	public static void main(String[] args) {

		RepositorioClientes r = new RepositorioClientes();
		r.cadastrarCliente("Lenon", "Teste");
		r.cadastrarCliente("Chagas", "Ponte");
		System.out.println(r);
		System.out.println(r.procurar("Lenon", "Teste"));
	}
}
