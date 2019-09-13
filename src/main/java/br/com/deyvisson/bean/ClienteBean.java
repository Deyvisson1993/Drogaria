package br.com.deyvisson.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.deyvisson.dao.ClienteDAO;
import br.com.deyvisson.dao.PessoaDAO;
import br.com.deyvisson.domain.Cliente;
import br.com.deyvisson.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

	private Cliente cliente;

	private List<Pessoa> pessoas;
	private List<Cliente> clientes;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
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
			ClienteDAO dao = new ClienteDAO();
			clientes = dao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar listar os Clientes");
			erro.printStackTrace();
		}

	}

	public void novo() {

		try {
			cliente = new Cliente();

			PessoaDAO dao = new PessoaDAO();
			pessoas = dao.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar iniciar o Cliente");
			erro.printStackTrace();
		}

	}

	public void salvar() {

		try {
			ClienteDAO dao = new ClienteDAO();
			dao.merge(cliente);

			novo();

			clientes = dao.listar();
			Messages.addGlobalInfo("Cliente salvo com Sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao tentar Salvar o Cliente");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {

		try {

			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionadoEditar");

			PessoaDAO dao = new PessoaDAO();
			pessoas = dao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar Editar um Cliente");
			erro.printStackTrace();
		}

	}

	public void excluir(ActionEvent evento) {

		try {
			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionadoExcluir");

			ClienteDAO dao = new ClienteDAO();
			dao.excluir(cliente);

			clientes = dao.listar();

			Messages.addGlobalInfo("Cliente excluido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar Editar um Cliente");
			erro.printStackTrace();
		}

	}

}