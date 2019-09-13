package br.com.deyvisson.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericDomain {

	@Column(length = 32, nullable = false)
	private String senha;

	@Column(nullable = false)
	private Character tipo;

	@Column(nullable = false)
	private Boolean estado;

	@OneToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoa pessoa;

	public Usuario() {
		super();
	}

	public Usuario(String senha, Character tipo, Boolean estado, Pessoa pessoa) {
		super();
		this.senha = senha;
		this.tipo = tipo;
		this.estado = estado;
		this.pessoa = pessoa;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Character getTipo() {
		return tipo;
	}

	@Transient // Indica que este é um campo só para formatação
	public String getTipoFormatado() {
		String tipoFormatado = null;

		if (tipo == 'A') {

			tipoFormatado = "Adimistrador";

		} else if (tipo == 'B') {

			tipoFormatado = "Balconista";
		} else if (tipo == 'G') {

			tipoFormatado = "Gerente";
		}

		return tipoFormatado;

	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@Transient
	public String getEstadoFormatado() {
		String estadoFormatado = null;
		
		if (estado) {

			estadoFormatado = "Sim";
		} else {
			estadoFormatado = "Não";
			
		}

		return estadoFormatado;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
