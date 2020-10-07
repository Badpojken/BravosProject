package negocios.beans;

import java.util.ArrayList;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Pedido {

	private ArrayList<Produto> carrinho = new ArrayList<Produto>();
	private int quantidade;
	private double preco = 0.0f;
	private boolean promocao;
	private boolean pagamentoDinheiro;
	private boolean pagamentoCartao;

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean getPagamentoDinheiro() {
		return pagamentoDinheiro;
	}

	public void setPagamentoDinheiro(boolean pagamentoDinheiro) {
		this.pagamentoDinheiro = pagamentoDinheiro;
	}

	public boolean getPagamentoCartao() {
		return pagamentoCartao;
	}

	public void setPagamentoCartao(boolean pagamentoCartao) {
		this.pagamentoCartao = pagamentoCartao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public boolean getPromocao() {
		return promocao;
	}

	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}

	public void calcularQuantidade() {
		this.quantidade = this.carrinho.size();
	}

	public void addCarrinho(Produto p) {
		this.carrinho.add(p);
		this.calcularQuantidade();
	}

	public void calcularPrecoTotal() {
		for (int i = 0; i < this.carrinho.size(); i++) {
			this.setPreco(this.getPreco() + this.carrinho.get(i).getPreco());
		}
	}

	public String horarioPedido() {
		LocalDateTime horaAgora = LocalDateTime.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MMMM/YYYY");
		String resultadoFormatador = formatador.format(horaAgora);
		return resultadoFormatador + "  " + horaAgora.getHour() + ":" + horaAgora.getMinute() + ":"
				+ horaAgora.getSecond();
	}

}
