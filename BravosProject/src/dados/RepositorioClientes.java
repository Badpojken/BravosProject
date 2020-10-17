package dados;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import negocios.beans.Cliente;

public class RepositorioClientes {

	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private int tamanho;

	public RepositorioClientes() {
	}

	public void cadastrarCliente(Cliente c) {
		this.clientes.add(c);
		tamanho = this.clientes.size();
	}

	private int procurarIndice(Cliente c) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < tamanho)) {
			if (c.equals(this.clientes.get(i))) {
				achou = true;
			} else {
				i++;
			}
		}
		return i;
	}

	// ATUALIZAR DEPOIS
	public Cliente procurar(Cliente c) {
		int i = this.procurarIndice(c);
		Cliente resultado = null;
		if (i != this.clientes.size()) {
			resultado = c;

		}
		return resultado;
	}

	public boolean existe(Cliente c) {
		boolean existe = false;
		int indice = this.procurarIndice(c);
		if (indice != tamanho) {
			existe = true;
			System.out.println("A conta existe");
		} else {
			System.out.println("A conta não existe");
		}
		return existe;
	}

	public void remover(Cliente c) {
		int i = this.procurarIndice(c);
		if (i != tamanho) {
			this.clientes.remove(i);
			System.out.println("Cliente removido.");
		} else {
			System.out.println("Cliente não encontrado. Portanto, não foi removido.");
		}
		tamanho = this.clientes.size();
	}

	public String toString() {
		return "Clientes:" + clientes;
	}

	// métodos relacionados à json

	public void salvarEmJson() {
		FileWriter writer = null;
		JSONObject jeissom = new JSONObject();
		jeissom.put("Clientes", this.clientes);
		try {
			FileWriter writeFile = new FileWriter("repositorioClientes.json");
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
			jasao = (JSONObject) parser.parse(new FileReader("repositorioClientes.json"));
			this.clientes.clear();
			this.clientes.addAll((ArrayList<Cliente>) jasao.get("Clientes"));

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
