package br.com.deyvisson.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Test;

import br.com.deyvisson.domain.Funcionario;
import br.com.deyvisson.domain.Pessoa;

public class FuncionarioDAOtest {

	@Test
	public void salvar() throws Exception {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		FuncionarioDAO dao = new FuncionarioDAO();
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa p = pessoaDAO.buscar(1L);

		Funcionario f = new Funcionario("43.4321", df.parse("12/03/2010"), p);
		dao.merge(f);
		System.out.println("Cadastrado com Sucesso");
	}

}
