package dados;

import java.util.ArrayList;
import negocios.Administrador;

public class RepositorioAdministrador {

	private ArrayList<Administrador> administrador = new ArrayList<Administrador>();
	private int tamanho;

	public RepositorioAdministrador() {

	}

	public void cadastrarAdministrador(String n, String e) {
		Administrador admin = new Administrador();
		admin.setNome(n);
		admin.setEndereço(e);
		this.administrador.add(admin);
		tamanho = this.administrador.size();
	}

	private int procurarIndice(Administrador a) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < tamanho)) {
			if (a.equals(this.administrador.get(i))) {
				achou = true;
			} else {
				i++;
			}
		}
		return i;
	}

	public Administrador procurar(String n, String e) {
		Administrador a = new Administrador();
		a.setNome(n);
		a.setEndereço(e);
		int i = this.procurarIndice(a);
		Administrador resultado = null;
		if (i != this.administrador.size()) {
			resultado = this.administrador.get(i);
		}
		return resultado;
	}

	public boolean existe(String n, String e) {
		Administrador a = new Administrador();
		a.setEndereço(e);
		a.setNome(n);
		boolean existe = false;
		int indice = this.procurarIndice(a);
		if (indice != tamanho) {
			existe = true;
			System.out.println("A conta existe");
		} else {
			System.out.println("A conta não existe");
		}
		return existe;
	}

	public void remover(String n, String e) {
		Administrador a = new Administrador();
		a.setEndereço(e);
		a.setNome(n);
		int i = this.procurarIndice(a);
		if (i != tamanho) {
			this.administrador.remove(i);
			System.out.println("Administrador removido.");
		} else {
			System.out.println("Administrador não encontrado. Portanto, não foi removido.");
		}
		tamanho = this.administrador.size();
	}

	public String toString() {
		return "Administrador(es): " + administrador;
	}

}
