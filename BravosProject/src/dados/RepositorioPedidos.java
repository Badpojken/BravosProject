package dados;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import negocios.beans.Pedido;

public class RepositorioPedidos {

	private ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
	private int tamanho;

	public RepositorioPedidos() {

	}

	public void addPedido(Pedido p) {
		this.listaPedidos.add(p);
		this.tamanho = this.listaPedidos.size();
	}

	public void removePedido(Pedido p) {
		this.listaPedidos.remove(p);
		this.tamanho = this.listaPedidos.size();
	}

	private int procurarIndice(Pedido p) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < tamanho)) {
			if (p.equals(this.listaPedidos.get(i))) {
				achou = true;
			} else {
				i++;
			}
		}
		return i;
	}

	public Pedido procurar(Pedido p) {
		int i = this.procurarIndice(p);
		Pedido resultado = null;
		if (i != this.listaPedidos.size()) {
			resultado = this.listaPedidos.get(i);
			System.out.println("Produto encontrado.");
		} else {
			System.out.println("Produto n�o encontrado.");
		}
		return resultado;
	}

	public boolean existe(Pedido p) {
		boolean existe = false;
		int indice = this.procurarIndice(p);
		if (indice != tamanho) {
			existe = true;
			System.out.println("O produto existe");
		} else {
			System.out.println("O produto n�o existe");
		}
		return existe;
	}

	public void remover(Pedido p) {
		int i = this.procurarIndice(p);
		if (i != tamanho) {
			this.listaPedidos.remove(i);
			System.out.println("Produto removido.");
		} else {
			System.out.println("Produto n�o encontrado. Portanto, n�o foi removido.");
		}
		tamanho = this.listaPedidos.size();
	}

	@Override
	public String toString() {
		return "Pedidos:" + listaPedidos;
	}

}
