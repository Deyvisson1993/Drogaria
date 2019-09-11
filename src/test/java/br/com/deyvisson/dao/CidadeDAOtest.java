package br.com.deyvisson.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.deyvisson.domain.Cidade;
import br.com.deyvisson.domain.Estado;

public class CidadeDAOtest {
	
	//@Test
	@Ignore
	public void salvar() {
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado e =  estadoDAO.buscar(3L);
		
		Cidade c = new Cidade("Caxanga", e);
		CidadeDAO dao = new CidadeDAO();
		dao.salvar(c);
		
		System.out.println("Cadastrado com sucesso");
	}
	
	//@Test
	@Ignore
	public void listar() {
		
		CidadeDAO dao = new CidadeDAO();
		List<Cidade> lista = dao.listar();
		
		for (Cidade cidade : lista) {
			System.out.println("Codigo - " + cidade.getCodigo());
			System.out.println("Nome da cidade - "+ cidade.getNome());
			System.out.println("Codigo Estado - "+ cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado - "+ cidade.getEstado().getSigla());
			System.out.println("Nome do estado - "+ cidade.getEstado().getNome());
		}
	}
	//@Test
	@Ignore
	public void buscar() {
		
		Long codigo = 1L;
		
		CidadeDAO dao = new CidadeDAO();
		Cidade cidade = dao.buscar(codigo);
		
			System.out.println("Codigo - " + cidade.getCodigo());
			System.out.println("Nome da cidade - "+ cidade.getNome());
			System.out.println("Codigo Estado - "+ cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado - "+ cidade.getEstado().getSigla());
			System.out.println("Nome do estado - "+ cidade.getEstado().getNome());
		
	}
	//@Test
	@Ignore
	public void excluir() {
		
		Long codigo = 1L;
		
		CidadeDAO dao = new CidadeDAO();
		Cidade cidade = dao.buscar(codigo);
		
		dao.excluir(cidade);
		System.out.println("Excluido com sucesso");
		
	}
	
	//@Test
	@Ignore
	public void atualizar() {
		
		Long codigo = 2L;
		
		CidadeDAO dao = new CidadeDAO();
		Cidade cidade = dao.buscar(codigo);
		
		cidade.setNome("Regiao Metropolitana");
		dao.atualizar(cidade);
		
		System.out.println("Atualizado = " + cidade.getNome());
		
	}
	
	@Test
	public void bucarPorEstado() {
		
		Long estadoCodigo = 5L;
		
		CidadeDAO dao = new CidadeDAO();
		List<Cidade> lista = dao.buscarPorEstado(estadoCodigo);
		
		for (Cidade cidade : lista) {
			System.out.println("Codigo - " + cidade.getCodigo());
			System.out.println("Nome da cidade - "+ cidade.getNome());
			System.out.println("Codigo Estado - "+ cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado - "+ cidade.getEstado().getSigla());
			System.out.println("Nome do estado - "+ cidade.getEstado().getNome());
			System.out.println("");
		}
	}
}