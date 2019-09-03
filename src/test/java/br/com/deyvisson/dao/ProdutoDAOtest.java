package br.com.deyvisson.dao;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.deyvisson.domain.Fabricante;
import br.com.deyvisson.domain.Produto;

public class ProdutoDAOtest {
	
	@Test
	
	public void salvar() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fabricante = dao.buscar(1L);
		
		Produto produto = new Produto();
		produto.setDescricao("Buscopan 30 mg");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal("15.90"));
		produto.setQuantidade(new Short("10"));
		
		ProdutoDAO dao1 = new ProdutoDAO();
		dao1.salvar(produto);
		System.out.println("Salvo com Sucesso");
		
	}

}