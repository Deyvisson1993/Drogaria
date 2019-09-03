package br.com.deyvisson.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.deyvisson.domain.Cidade;
import br.com.deyvisson.domain.Pessoa;

public class PessoaDAOtest {
	@Test
	//@Ignore
	public void salvar() {
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(3L); 
		
		Pessoa p = new Pessoa("Wanderson Alves", "011.456.312-21", "3.455.112", "Rua B", new Short("10"), "varzia",
				"12.384-424", "Apt", "81 3354-2222", "81 996382271", "wanderson123@gmail.com", cidade);
		
		PessoaDAO dao = new PessoaDAO();
		dao.salvar(p);
		System.out.println("Cadastrado com sucesso");
		
	}
	@Test
	@Ignore
	public void listar() {
		
		PessoaDAO dao = new PessoaDAO();
		List<Pessoa> lista = dao.listar();
		
		for (Pessoa pessoa : lista) {
			System.out.println(pessoa.getNome()+ " - " + pessoa.getCpf());
		}
		
	}

}
