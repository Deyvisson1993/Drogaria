package br.com.deyvisson.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class ItemVenda extends GenericDomain{
	
	@Column(nullable = false)
	private Short quantidade;
	
	@Column(name = "valor_parcial", nullable = false, precision = 7, scale = 2)
	private BigDecimal valorParcial;
	
	@ManyToOne
	@JoinColumn(name = "produto_id", nullable = false)
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "venda_id", nullable = false)
	private Venda venda;
	

	public ItemVenda() {
		super();
	}
	

	public ItemVenda(Short quantidade, BigDecimal valorParcial, Produto produto, Venda venda) {
		super();
		this.quantidade = quantidade;
		this.valorParcial = valorParcial;
		this.produto = produto;
		this.venda = venda;
	}



	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorParcial() {
		return valorParcial;
	}

	public void setValorParcial(BigDecimal valorParcial) {
		this.valorParcial = valorParcial;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
}
