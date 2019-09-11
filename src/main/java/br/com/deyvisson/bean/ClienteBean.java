package br.com.deyvisson.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.deyvisson.dao.ClienteDAO;
import br.com.deyvisson.domain.Cliente;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

	private Cliente cliente;

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
}