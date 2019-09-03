package br.com.deyvisson.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.deyvisson.dao.FabricanteDAO;
import br.com.deyvisson.domain.Fabricante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable {

	private Fabricante fabricante;
	private List<Fabricante> fabricantes;

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	@PostConstruct
	public void listar() {

		try {
			FabricanteDAO dao = new FabricanteDAO();
			fabricantes = dao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Nao foi possivel listar os FABRICANTES");
			erro.printStackTrace();
		}
	}

	public void novo() {
		fabricante = new Fabricante();

	}

	public void salvar() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.merge(fabricante);

			novo();
			
			fabricantes = dao.listar();


			Messages.addGlobalInfo("Salvo com Sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Nao foi possivel cadastra o FABRICANTE");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			fabricante = (Fabricante) evento.getComponent().getAttributes().get("estadoSelecionadoExcluir");
			
			FabricanteDAO dao = new FabricanteDAO();
			dao.excluir(fabricante);
			
			fabricantes = dao.listar();
			
			Messages.addGlobalInfo("Fabrincate Excluido com Sucesso");
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar excluir o Fabricante");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		
		fabricante = (Fabricante) evento.getComponent().getAttributes().get("estadoSelecionadoEditar");

	}
}