package br.com.deyvisson.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.deyvisson.dao.FuncionarioDAO;
import br.com.deyvisson.dao.PessoaDAO;
import br.com.deyvisson.domain.Funcionario;
import br.com.deyvisson.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FuncionarioBean implements Serializable {

	private Funcionario funcionario;

	private List<Funcionario> funcionarios;
	private List<Pessoa> pessoas;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	@PostConstruct
	public void listar() {

		try {
			FuncionarioDAO dao = new FuncionarioDAO();
			funcionarios = dao.listar();

		} catch (RuntimeException erro) {

			Messages.addGlobalError("Erro ao tentar listar os Funcinarios");
			erro.printStackTrace();
		}

	}

	public void novo() {

		try {

			funcionario = new Funcionario();
			PessoaDAO dao = new PessoaDAO();
			pessoas = dao.listar();

		} catch (RuntimeException erro) {

			Messages.addGlobalError("Erro ao tentar Iniciar o Funcionario");
			erro.printStackTrace();
		}

	}

	public void salvar() {

		try {

			FuncionarioDAO dao = new FuncionarioDAO();
			dao.merge(funcionario);

			novo();

			funcionarios = dao.listar();

			Messages.addGlobalInfo("Funcionario Cadastrado com Sucesso");

		} catch (RuntimeException erro) {

			Messages.addGlobalError("Erro ao tentar Iniciar o Funcionario");
			erro.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {

		try {

			funcionario = (Funcionario) evento.getComponent().getAttributes().get("funcionarioSelecionadoEditar");

			PessoaDAO dao = new PessoaDAO();
			pessoas = dao.listar();

		} catch (RuntimeException erro) {

			Messages.addGlobalError("Erro ao tentar Editar o Funcionario");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {

		try {

			funcionario = (Funcionario) evento.getComponent().getAttributes().get("funcionarioSelecionadoExcluir");

			FuncionarioDAO dao = new FuncionarioDAO();
			dao.excluir(funcionario);

			funcionarios = dao.listar();

			Messages.addGlobalInfo("Funcionario Excluido com Sucesso");

		} catch (RuntimeException erro) {

			Messages.addGlobalError("Erro ao tentar Excluir o Funcionario");
			erro.printStackTrace();
		}

	}
}