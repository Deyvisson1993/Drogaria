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
		Cidade cidade = cidadeDAO.buscar(4L); 
		
		Pessoa p = new Pessoa("Pablo Ricardo", "011.456.312-21", "3.223.1232", "Rua A", new Short("10"), "Varzia",
				"54.212-341", "Apt", "81 3354-2222", "81 996382271", "wanderson123@gmail.com", cidade);
		
		Pessoa p2 = new Pessoa("Palmira Andrade Ferraz", "092.957.842-22", "1.225.111", "Rua B", new Short("11"), "Caxanga",
				"92.788-435", "Apt", "81 3354-2222", "81 996382212", "pal_mira@gmail.com", cidade);
		
		Pessoa p3 = new Pessoa("Antonio Mendes da Silva", "011.412.432-43", "3.435.332", "Rua C", new Short("12"), "Derby",
				"72.874-424", "Apt", "81 3354-1122", "81 996382216", "an123123@gmail.com", cidade);
		
		Pessoa p4 = new Pessoa("Luiza Alves de Araujo", "033.987.666-20", "7.983.000", "Rua D", new Short("13"), "Torre",
				"32.544-424", "Apt", "81 3487-3322", "81 996382218", "lu.luiza3@gmail.com", cidade);
		
		Pessoa p5 = new Pessoa("Henrique de Padua Mendes", "111.233.454-43", "1.444.222", "Rua E", new Short("14"), "CDU",
				"44.876-424", "Apt", "81 3411-4422", "81 996382219", "bola_h123@gmail.com", cidade);
		
		Pessoa p6 = new Pessoa("Angela Maria Silva", "091.991.212-51", "7.123.333", "Rua F", new Short("15"), "Apipucos",
				"45.942-424", "Apt", "81 3466-5522", "81 996382223", "angel23@gmail.com", cidade);
		
		Pessoa p7 = new Pessoa("Fernado Riberio Alves", "009.333.333-99", "3.455.112", "Rua G", new Short("16"), "Madalena",
				"11.927-114", "Apt", "81 3471-6622", "81 996382234", "miraf.alves@gmail.com", cidade);
		
		Pessoa p8 = new Pessoa("Marcia Maria Alves", "091.990.254-23", "3.455.110", "Rua H", new Short("17"), "Curado 1",
				"13.349-424", "Apt", "81 3463-7722", "81 996382245", "marcia_3@gmail.com", cidade);
		
		PessoaDAO dao = new PessoaDAO();
		dao.salvar(p);
		dao.salvar(p8);
		dao.salvar(p2);
		dao.salvar(p3);
		dao.salvar(p4);
		dao.salvar(p5);
		dao.salvar(p6);
		dao.salvar(p7);
		System.out.println("Cadastrado com sucesso");
		
	}
	//@Test
	@Ignore
	public void listar() {
		
		PessoaDAO dao = new PessoaDAO();
		List<Pessoa> lista = dao.listar();
		
		for (Pessoa pessoa : lista) {
			System.out.println(pessoa.getNome()+ " - " + pessoa.getCpf());
		}
		
	}

}
