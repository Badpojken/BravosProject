package dados;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import negocios.ControladorClientes;
import negocios.ProdutoQuantidade;
import negocios.beans.*;
import java.io.*;

public class Teste {

	public static void main(String[] args) {

		RepositorioProdutos rp = new RepositorioProdutos();
		
		rp.copiandoDoJson();
		System.out.println(rp);
		
		
		JSONArray jrr = new JSONArray();
		Object ob = null;
		JSONParser Jp = new JSONParser();
		try {
			FileReader file = new FileReader("repositorioProdutos.json");
			ob = Jp.parse(file);
			jrr = (JSONArray) ob;
			file.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar no repositorio.");
		}
		
		JSONObject jsonProdutos = new JSONObject();
		jsonProdutos.put("Produtos", jrr);
		JSONParser produtosParser = new JSONParser();
		String np = null;
		String pp = null;
		try {

			JSONObject objProdutos = (JSONObject) produtosParser.parse(jsonProdutos.toJSONString());
			JSONArray arrayProdutos = (JSONArray) objProdutos.get("Produtos");
			for (int i = 0; i < jrr.size(); i++) {
				JSONObject products = (JSONObject) arrayProdutos.get(i);
				if (products.get("nomeProduto").equals("Khal")) {
					products.put("nomeProduto", "Chagas");
					products.put("preco", "10.0");
					arrayProdutos.add(products);
					
				}
				np = products.get("nomeProduto").toString();
				pp = products.get("preco").toString();

				System.out.println(np + "\t" + pp);
			}

		} catch (ParseException e) {
			e.printStackTrace();

		}

	}

}
