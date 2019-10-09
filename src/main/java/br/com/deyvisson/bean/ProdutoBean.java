package br.com.deyvisson.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.primefaces.event.FileUploadEvent;

import br.com.deyvisson.dao.FabricanteDAO;
import br.com.deyvisson.dao.ProdutoDAO;
import br.com.deyvisson.domain.Fabricante;
import br.com.deyvisson.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {

	private Produto produto;
	
	private List<Produto> produtos;
	private List<Fabricante> fabricantes;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public void novo() {

		try {
			produto = new Produto();
			FabricanteDAO dao = new FabricanteDAO();
			fabricantes = dao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possivel inicialiar o Produto");
			erro.printStackTrace();
		}

	}

	@PostConstruct
	public void listar() {

		try {
			ProdutoDAO dao = new ProdutoDAO();
			produtos = dao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possivel Listar o Produto");
			erro.printStackTrace();
		}

	}

	public void salvar() {

		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.merge(produto);

			novo();

			produtos = dao.listar();

			Messages.addGlobalInfo("Produto salvo com Sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possivel Salvar o Produto");
			erro.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {

		try {
			produto = (Produto) evento.getComponent().getAttributes().get("selecionadoProdutoEditar");

			FabricanteDAO dao = new FabricanteDAO();
			fabricantes = dao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possivel Editar/Selecionar o Produto");
			erro.printStackTrace();
		}

	}

	public void excluir(ActionEvent evento) {

		try {
			produto = (Produto) evento.getComponent().getAttributes().get("selecionadoProdutoExcluir");
			ProdutoDAO dao = new ProdutoDAO();
			dao.excluir(produto);

			produtos = dao.listar();

			Messages.addGlobalInfo("Produto Excluido com Sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Não foi possivel Editar/Selecionar o Produto");
			erro.printStackTrace();
		}
	}
	
	public void fotoUpload(FileUploadEvent evento) {
		
		
	}
}