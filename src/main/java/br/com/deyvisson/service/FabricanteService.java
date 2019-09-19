package br.com.deyvisson.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import br.com.deyvisson.dao.FabricanteDAO;
import br.com.deyvisson.domain.Fabricante;

@Path("fabricante")
public class FabricanteService {
	
	//http://localhost:8080/Drogaria/rest/fabricante
	@GET
	public String listar() {
		
		FabricanteDAO dao = new FabricanteDAO();
		List<Fabricante> fabricantes = dao.listar();
		
		
		Gson gson = new Gson();
		String json = gson.toJson(fabricantes);		
		return json;
		
	}
	
	//http://localhost:8080/Drogaria/rest/fabricante/1
	@GET
	@Path("{codigo}")
	public String buscar(@PathParam("codigo") Long codigo) {
		
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fabricante = dao.buscar(codigo);
		
		Gson gson = new Gson();
		String json = gson.toJson(fabricante);		
		return json;
	}
	
	//http://localhost:8080/Drogaria/rest/fabricante/
	@POST
	public void salvar(String json) {
		
		Gson gson = new Gson();
		Fabricante fabricante = gson.fromJson(json, Fabricante.class);
		
		FabricanteDAO dao = new FabricanteDAO();
		dao.merge(fabricante);
	}

}
