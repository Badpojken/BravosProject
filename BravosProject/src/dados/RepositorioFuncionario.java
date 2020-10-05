package dados;

import java.util.ArrayList;
import negocios.Funcionario;

public class RepositorioFuncionario {
	private ArrayList<Funcionario> funcionario = new ArrayList<Funcionario>();
	private int tamanho;

	public RepositorioFuncionario() {

	}

	public void cadastrarFuncionario(String n, String e) {
		Funcionario func = new Funcionario();
		func.setNome(n);
		func.setEndereço(e);
		this.funcionario.add(func);
		tamanho = this.funcionario.size();
	}

	private int procurarIndice(Funcionario f) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < tamanho)) {
			if (f.equals(this.funcionario.get(i))) {
				achou = true;
			} else {
				i++;
			}
		}
		return i;
	}

	public Funcionario procurar(String n, String e) {
		Funcionario f = new Funcionario();
		f.setNome(n);
		f.setEndereço(e);
		int i = this.procurarIndice(f);
		Funcionario resultado = null;
		if (i != this.funcionario.size()) {
			resultado = this.funcionario.get(i);
		}
		return resultado;
	}
	
	public boolean existe(String n, String e) {
		Funcionario f = new Funcionario();
		f.setEndereço(e);
		f.setNome(n);
		boolean existe = false;
		int indice = this.procurarIndice(f);
		if (indice != tamanho) {
			existe = true;
			System.out.println("A conta existe");
		} else {
			System.out.println("A conta não existe");
		}
		return existe;
	}
	public void remover(String n, String e) {
		Funcionario f = new Funcionario();
		f.setEndereço(e);
		f.setNome(n);
		int i = this.procurarIndice(f);
		if (i != tamanho) {
			this.funcionario.remove(i);
			System.out.println("Conta removida.");
		} else {
			System.out.println("Conta não encontrada. Portanto, não foi removida.");
		}
		tamanho = this.funcionario.size();
	}
	public String toString() {
		return "Funcionario(s): "+ funcionario;
	}
	

}
