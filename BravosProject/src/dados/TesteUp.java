package dados;

import java.io.FileReader;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class TesteUp {

	public static void main(String[] args) {
		
		
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
		
		System.out.println(jrr);
		
		
		
		
		
		
		
		
		
		

	}

}
