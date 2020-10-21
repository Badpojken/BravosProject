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

		ControladorClientes cc = new ControladorClientes();
		Cliente c = new Cliente();
		c.setNome("Lenon");
		c.setEndereco("Casa E");
		cc.cadastrar(c);

		JSONObject obj = new JSONObject();
		JSONArray jrr = new JSONArray();
		JSONParser jp = new JSONParser();

		try {
			FileReader file = new FileReader("repositorioClientes.json");
			jrr = (JSONArray) jp.parse(file);
		} catch (Exception ex) {
			System.out.println("Ocorreu um erro");
		}
		obj.put("nome", cc.procurar(c).getNome());
		obj.put("endereco", cc.procurar(c).getEndereco());
		int size = jrr.size();
		for (int i = 0; i < size; i++) {
			if (jrr.get(i).equals(obj)) {
				System.out.println("Cliente já existe!");
			} else if (i == size - 1) {
				System.out.println("Adicionado!");
				jrr.add(obj);
			}
		}

		try {
			FileWriter file = new FileWriter("repositorioClientes.json");
			file.write(jrr.toJSONString());
			file.close();
		} catch (Exception ex) {
			System.out.println("Ocorreu um erro.");
		}

		System.out.println("Salvo no repositorio.");

		System.out.println(jrr);

	}

}
