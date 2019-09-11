package br.com.deyvisson.dao;

import java.util.Date;

import org.junit.Test;

import br.com.deyvisson.domain.Cliente;
import br.com.deyvisson.domain.Pessoa;

public class ClienteDAOtest {
	
	@Test
	public void salvar() {
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(3L);
		
		Cliente cliente = new Cliente(new Date(), false, pessoa);
		ClienteDAO dao = new ClienteDAO();
		dao.salvar(cliente);
		System.out.println("Cadastrado com sucesso");
	}
}