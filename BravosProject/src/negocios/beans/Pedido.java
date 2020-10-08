package negocios.beans;

public class Pedido {

	private Cliente clientePedido = new Cliente();
	private Funcionario funcionario = new Funcionario();
	private Produto produtoPedido = new Produto();
	private int quantidade;
	private double preco;

	public Pedido() {

	}

	public Pedido(Produto p, int q, double pr, Funcionario f, Cliente c) {
		this.produtoPedido = p;
		this.quantidade = q;
		this.preco = pr;
		this.funcionario = f;
		this.clientePedido = c;

	}

	public Produto getProdutoPedido() {
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

	public void setProdutoPedido(Produto produtoPedido) {
		this.produtoPedido = produtoPedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void calcPreco() {
		double i;
		i = (produtoPedido.getPreco() * this.quantidade);
		this.preco = i;
	}

	public boolean equals(Pedido p) {
		boolean resultado = false;
		if ((p != null) && (this.getPreco() == p.getPreco()) && (this.getProdutoPedido().equals(p.getProdutoPedido()))
				&& (this.getQuantidade() == p.getQuantidade()) && this.getClientePedido().equals(p.getClientePedido())
				&& (this.getFuncionario().equals(p.getFuncionario()))) {
			resultado = true;
		}
		return resultado;
	}

	public String toString() {
		return "Pedido [clientePedido=" + clientePedido + ", funcionario=" + funcionario + ", produtoPedido="
				+ produtoPedido + ", quantidade=" + quantidade + ", preco=" + preco + "]";
	}

	

}
