package negocios.beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Pedido {

	private Cliente clientePedido = new Cliente();
	private Funcionario funcionario = new Funcionario();
	private ArrayList<Produto> produtoPedido = new ArrayList<Produto>();
	private double precoFinal;
	private String dataHorario;

	public Pedido() {

	}

	public Pedido(ArrayList<Produto> produtosPedido, Funcionario f, Cliente c) {
		this.produtoPedido = produtosPedido;
		this.funcionario = f;
		this.clientePedido = c;

	}

	public ArrayList<Produto> getProdutoPedido() {
		return produtoPedido;
	}

	public Cliente getClientePedido() {
		return clientePedido;
	}

	public void setClientePedido(Cliente clientePedido) {
		this.clientePedido = clientePedido;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void setProdutoPedido(ArrayList<Produto> produtoPedido) {
		this.produtoPedido = produtoPedido;
	}

	public double getPreco() {
		return precoFinal;
	}

	public void calcPrecoTotal() {
		double i = 0;
		int tamanho = this.getProdutoPedido().size();
		for (int y = 0; y < tamanho; y++) {
			i = i + this.getProdutoPedido().get(y).getPreco() * this.getProdutoPedido().get(y).getQuantidade();
		}
		this.precoFinal = i;
	}

	public boolean equals(Pedido p) {
		boolean resultado = false;
		if ((p != null) && (this.getPreco() == p.getPreco()) && (this.getProdutoPedido().equals(p.getProdutoPedido()))
				&& (this.getClientePedido().equals(p.getClientePedido())
						&& (this.getFuncionario().equals(p.getFuncionario())))) {
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
		return "Pedido [clientePedido=" + clientePedido + ", funcionario=" + funcionario + ", produtoPedido="
				+ produtoPedido +", horarioPedido="+this.getDataHorario()+", precoFinal=" + precoFinal + "]";
	}

}
