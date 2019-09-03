package br.com.deyvisson.dao;

import java.util.Date;

import org.junit.Test;

import br.com.deyvisson.domain.Cliente;
import br.com.deyvisson.domain.Pessoa;

public class ClienteDAOtest {
	
	@Test
	public void salvar() {
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1L);
		
		Cliente cliente = new Cliente(new Date(), true, pessoa);
		ClienteDAO dao = new ClienteDAO();
		dao.salvar(cliente);
		System.out.println("Cadastrado com sucesso");
	}
}