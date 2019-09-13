package br.com.deyvisson.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.com.deyvisson.domain.Pessoa;
import br.com.deyvisson.domain.Usuario;

public class UsuarioDAOtest {
	@Test
	//@Ignore
	public void salvar() {
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1L);
		
		Usuario usuario = new Usuario("8896",'A', true, pessoa);
		UsuarioDAO dao = new UsuarioDAO();
		dao.salvar(usuario);
		
		System.out.println("Cadastrado com sucesso");
		
		
	}

}
