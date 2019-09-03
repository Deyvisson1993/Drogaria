package br.com.deyvisson.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.deyvisson.dao.CidadeDAO;
import br.com.deyvisson.dao.PessoaDAO;
import br.com.deyvisson.domain.Cidade;
import br.com.deyvisson.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {

	private Pessoa pessoa;
	private List<Cidade> cidades;
	private List<Pessoa> pessoas;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public void novo() {

		try {

			pessoa = new Pessoa();
			CidadeDAO dao = new CidadeDAO();
			cidades = dao.listar();
		} catch (RuntimeException erro) {

			Messages.addGlobalError("Nao foi Possivel Listar as Cidades");
			erro.printStackTrace();
		}

	}
	@PostConstruct
	public void listar() {
		try {
			PessoaDAO dao = new PessoaDAO();
			pessoas = dao.listar();

		} catch (RuntimeException erro) {

			Messages.addGlobalError("Erro Ao tentar listar as Pessoas");
			erro.printStackTrace();
		}

	}

	public void salvar() {

		try {
			PessoaDAO dao = new PessoaDAO();
			dao.merge(pessoa);

			novo();

			pessoas = dao.listar();

			Messages.addGlobalInfo("Salvo com Sucesso");
		} catch (RuntimeException erro) {

			Messages.addGlobalError("Erro Ao tentar Salvar os dados de Pessoa");
			erro.printStackTrace();

		}
	}

	public void excluir(ActionEvent evento) {
		try {
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionadaExcluir");

			PessoaDAO dao = new PessoaDAO();
			dao.excluir(pessoa);

			pessoas = dao.listar();

			Messages.addGlobalInfo("Excluido com Sucesso");
		} catch (RuntimeException erro) {

			Messages.addGlobalError("Erro Ao tentar Excluir os dados de Pessoa");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {

		try {
			
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionadaEditar");
			CidadeDAO dao = new CidadeDAO();
			cidades = dao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro Ao tentar editar os dados de Pessoa");
			erro.printStackTrace();
		}

	}

}