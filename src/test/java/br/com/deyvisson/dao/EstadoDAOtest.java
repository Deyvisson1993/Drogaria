package br.com.deyvisson.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.deyvisson.dao.EstadoDAO;
import br.com.deyvisson.domain.Estado;

public class EstadoDAOtest {

	@Test
	@Ignore
	public void salvar() {

		Estado estado = new Estado("SP", "Sao Paulo");
		Estado estado1 = new Estado("PE", "Pernambuco");
		Estado estado2 = new Estado("SC", "Santa Catarina");
		Estado estado3 = new Estado("RJ", "Rido de Janeiro");

		EstadoDAO dao = new EstadoDAO();
		dao.salvar(estado);
		dao.salvar(estado1);
		dao.salvar(estado2);
		dao.salvar(estado3);

		System.out.println("Cadastrado com Sucesso!");
	}

	@Test
	@Ignore
	public void listar() {

		EstadoDAO dao = new EstadoDAO();
		List<Estado> resultado = dao.listar();

		for (Estado estado : resultado) {
			System.out.println(estado.getSigla() + " " + estado.getNome());
		}

	}

	@Test
	@Ignore
	public void buscar() {

		Long codigo = 1L;

		EstadoDAO dao = new EstadoDAO();
		Estado estado = dao.buscar(codigo);

		if (estado == null) {

			System.out.println("Nenhum estado encontrado com esse CODIGO ");
		} else {

			System.out.println(estado.getCodigo() + " " + estado.getSigla() + " " + estado.getNome());

		}
	}

	@Test
	@Ignore
	public void excluir() {

		Long codigo = 1L;

		EstadoDAO dao = new EstadoDAO();
		Estado estado = dao.buscar(codigo);
		dao.excluir(estado);
		System.out.println("Excluido com sucesso");

	}

	@Test
	public void editar() {

		Long codigo = 5L;

		EstadoDAO dao = new EstadoDAO();
		Estado estado = dao.buscar(codigo);
		if (estado == null) {
			
			System.out.println("Não existe estado com esse codigo");
			
		} else {
			estado.setNome("Rio do Janeiro");
			dao.atualizar(estado);

			System.out.println("Atualizafo com sucesso = " + estado.getSigla() + " - " + estado.getNome());
		}
	}
}