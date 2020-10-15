package negocios.beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import negocios.ProdutoQuantidade;

public class Pedido {

	private Cliente clientePedido = new Cliente();
	private ArrayList<ProdutoQuantidade> produtosPedido = new ArrayList<ProdutoQuantidade>();
	private double precoFinal;
	private String dataHorario;

	public Pedido() {

	}

	public Pedido(ArrayList<ProdutoQuantidade> produtosPedido, Cliente c) {
		this.produtosPedido = produtosPedido;
		this.clientePedido = c;

	}

	public ArrayList<ProdutoQuantidade> getProdutoPedido() {
		return produtosPedido;
	}

	public Cliente getClientePedido() {
		return clientePedido;
	}

	public void setClientePedido(Cliente clientePedido) {
		this.clientePedido = clientePedido;
	}

	public void setProdutoPedido(ArrayList<ProdutoQuantidade> produtoPedido) {
		this.produtosPedido = produtoPedido;
	}

	public double getPreco() {
		return precoFinal;
	}

	public void calcPrecoTotal() {
		double i = 0;
		int tamanho = this.getProdutoPedido().size();
		for (int y = 0; y < tamanho; y++) {
			i = i + this.getProdutoPedido().get(y).getPrecoTotal();
		}
		this.precoFinal = i;
	}

	public boolean equals(Pedido p) {
		boolean resultado = false;
		if ((p != null) && (this.getPreco() == p.getPreco()) && (this.getProdutoPedido().equals(p.getProdutoPedido()))
				&& (this.getClientePedido().equals(p.getClientePedido()))) {
			resultado = true;
		}
		return resultado;
	}

	// Dúvida em relação a dataHorario ser um atributo ou não!
	public void dataHorarioPedido() {
		LocalDateTime horaAgora = LocalDateTime.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MMMM/YYYY");
		String resultadoFormatador = formatador.format(horaAgora);
		dataHorario = resultadoFormatador + " " + horaAgora.getHour() + ":" + horaAgora.getMinute() + ":"
				+ horaAgora.getSecond();
	}

	public String getDataHorario() {
		return dataHorario;
	}

	public String toString() {
		return "{\"clientePedido\"" + ":" + clientePedido + "," + "\"produtoPedido\""
				+ ":" + produtosPedido + "," + "\"horarioPedido\"" + ":"  + this.getDataHorario() + "," + "\"precoFinal\"" + ":"+ precoFinal +"}";
		
	
	}

}
