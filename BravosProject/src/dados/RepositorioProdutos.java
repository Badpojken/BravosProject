package dados;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import negocios.beans.Produto;

public class RepositorioProdutos {
	// DUVIDA EM RELAÇÃO AO ATRIBUTO ARRAYLIST<PRODUTO> SER STATIC OU NÃO.
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private int tamanho;

	public RepositorioProdutos() {

	}

	public void criarProduto(Produto p) {
		this.produtos.add(p);
		tamanho = this.produtos.size();

	}

	private int procurarIndice(Produto p) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < tamanho)) {
			if (p.equals(this.produtos.get(i))) {
				achou = true;
			} else {
				i++;
			}
		}
		return i;
	}

	public Produto procurar(Produto p) {
		int i = this.procurarIndice(p);
		Produto resultado = null;
		if (i != this.produtos.size()) {
			resultado = this.produtos.get(i);
			System.out.println("Produto encontrado.");
		} else {
			System.out.println("Produto não encontrado.");
		}
		return resultado;
	}

	public boolean existe(Produto p) {
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

	public void remover(Produto p) {
		int i = this.procurarIndice(p);
		if (i != tamanho) {
			this.produtos.remove(i);
			System.out.println("Produto removido.");
		} else {
			System.out.println("Produto não encontrado. Portanto, não foi removido.");
		}
		tamanho = this.produtos.size();
	}

	public String toString() {
		return "Produtos:" + produtos + "";
	}

	// métodos relacionados à json

	public void salvarEmJson() {
		FileWriter writer = null;
		JSONObject jeissom = new JSONObject();
		jeissom.put("Produtos", this.produtos);
		try {
			FileWriter writeFile = new FileWriter("repositorioProdutos.json", true);
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
			jasao = (JSONObject) parser.parse(new FileReader("repositorioProdutos.json"));
			this.produtos.clear();
			this.produtos.addAll((ArrayList<Produto>) jasao.get("Produtos"));

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
