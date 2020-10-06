package dados;

public class Teste {

	public static void main(String[] args) {

		RepositorioClientes r = new RepositorioClientes();
		r.cadastrarCliente("Lenon", "Teste");
		r.cadastrarCliente("Chagas", "Ponte");
		System.out.println(r);
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
		//so um teste msm; ~chagas
	}
}
