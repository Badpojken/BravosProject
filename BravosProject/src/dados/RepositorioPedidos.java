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
			System.out.println("Produto não encontrado.");
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
			System.out.println("O produto não existe");
		}
		return existe;
	}

	public void remover(Pedido p) {
		int i = this.procurarIndice(p);
		if (i != tamanho) {
			this.listaPedidos.remove(i);
			System.out.println("Produto removido.");
		} else {
			System.out.println("Produto não encontrado. Portanto, não foi removido.");
		}
		tamanho = this.listaPedidos.size();
	}

	

	// métodos relacionados à json

	@Override
	public String toString() {
		return "Pedidos:" + listaPedidos;
	}

	public void salvarEmJson() {
		FileWriter writer = null;
		JSONObject jeissom = new JSONObject();
		jeissom.put("listaPedidos", this.listaPedidos);
		try {
			FileWriter writeFile = new FileWriter("repositorioPedidos.json");
			writeFile.write(jeissom.toJSONString());
			writeFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void copiandoDoJson() {
		JSONObject jasao;
		JSONParser parser = new JSONParser();
		try {
			jasao = (JSONObject) parser.parse(new FileReader("repositorioPedidos.json"));
			this.listaPedidos.clear();
			this.listaPedidos.addAll((ArrayList<Pedido>) jasao.get("listaPedidos"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void removerDoJson() {
		JSONObject jasao;
		JSONParser parser = new JSONParser();
		try {
			jasao = (JSONObject) parser.parse(new FileReader("repositorioPedidos.json"));
			this.listaPedidos.clear();
			this.listaPedidos.removeAll((ArrayList<Pedido>) jasao.get("listaPedidos"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		
	

}
