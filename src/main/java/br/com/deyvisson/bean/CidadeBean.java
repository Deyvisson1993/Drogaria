package br.com.deyvisson.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.deyvisson.dao.CidadeDAO;
import br.com.deyvisson.dao.EstadoDAO;
import br.com.deyvisson.domain.Cidade;
import br.com.deyvisson.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {

	private Cidade cidade;
	private List<Cidade> cidades;
	private List<Estado> estados;

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	@PostConstruct
	public void listar() {
		try {
			CidadeDAO dao = new CidadeDAO();
			cidades = dao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar Listar as Cidades");
			erro.printStackTrace();

		}

	}

	public void novo() {

		try {
			cidade = new Cidade();
			EstadoDAO dao = new EstadoDAO();
			estados = dao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Nao foi possivel inicialiar a Cidade");
			erro.printStackTrace();
		}
	}

	public void salvar() {

		try {

			CidadeDAO dao = new CidadeDAO();
			dao.merge(cidade);

			novo();

			cidades = dao.listar();

			Messages.addGlobalInfo("Cidade Salva com Sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Nao foi possivel listar as Cidades");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionadoExcluir");

			CidadeDAO dao = new CidadeDAO();
			dao.excluir(cidade);

			cidades = dao.listar();

			Messages.addGlobalInfo("Cidade Excluida com Sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Nao foi possivel Excluir a Cidade");
			erro.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {

		try {
			
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionadoEditar");

			EstadoDAO dao = new EstadoDAO();
			estados = dao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar selecionar uma Cidade");
			erro.printStackTrace();
		}
	}
}
