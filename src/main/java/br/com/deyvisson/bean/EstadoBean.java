package br.com.deyvisson.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.deyvisson.dao.EstadoDAO;
import br.com.deyvisson.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {

	private Estado estado;
	private List<Estado> estados;

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@PostConstruct // Vai Lstar todos os dados atomaticamente na tela
	public void listar() {

		try {

			EstadoDAO dao = new EstadoDAO();
			estados = dao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Tentar Listar os Dados de ESTADO");
			erro.printStackTrace();
		}
	}

	public void novo() {
		estado = new Estado();
	}

	public void salvar() {
		try {
			EstadoDAO dao = new EstadoDAO();
			dao.merge(estado);

			novo();

			estados = dao.listar(); // Apos salvar ele atualiza a Lista

			Messages.addGlobalInfo("Salvo com Sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar salvar o ESTADO");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionadoExcluir");

			EstadoDAO dao = new EstadoDAO();
			dao.excluir(estado);

			estados = dao.listar();// Apos excluir ele atualiza a Lista

			Messages.addGlobalInfo("Estado excludo com Sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("NÂO foi possivel excluir o Estado");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionadoEditar");

	}
}