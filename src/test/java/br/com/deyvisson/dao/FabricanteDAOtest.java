package br.com.deyvisson.dao;

import org.junit.Test;

import br.com.deyvisson.domain.Fabricante;

public class FabricanteDAOtest {
	
	@Test
	public void merge() {
		
//		Fabricante fabricante = new Fabricante("Medley");
//		
//		FabricanteDAO dao = new FabricanteDAO();
//		dao.merge(fabricante);
//		
		
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante f = dao.buscar(2L);
		
		dao.excluir(f);
		System.out.println("Excluido com Sucessor");
	}

}
