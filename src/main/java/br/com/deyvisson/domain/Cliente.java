package br.com.deyvisson.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Cliente extends GenericDomain{

	@Column(name = "data_cadastro", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;
	
	@Column(nullable = false)
	private Boolean liberado;
	
	@OneToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoa pessoa;
	

	public Cliente() {
		super();
	}

	public Cliente(Date dataCadastro, Boolean liberado, Pessoa pessoa) {
		super();
		this.dataCadastro = dataCadastro;
		this.liberado = liberado;
		this.pessoa = pessoa;
	}



	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getLiberado() {
		return liberado;
	}

	public void setLiberado(Boolean liberado) {
		this.liberado = liberado;
	}
	
	@Transient
	public String getFormatadoLiberado() {
		String formatadoLiberado = null;
		
		if(liberado) {
			
			formatadoLiberado = "Sim";
		}else {
			formatadoLiberado = "Não";
		}
		
		return formatadoLiberado;
		
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}	
}