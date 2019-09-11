package br.com.deyvisson.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.deyvisson.domain.Cidade;
import br.com.deyvisson.util.HibernetUtil;

public class CidadeDAO extends GenericDAO<Cidade>{
	
	@SuppressWarnings("unchecked")
	public List<Cidade> buscarPorEstado(Long estadoId){
		
		Session sessao = HibernetUtil.getFabricaDeSessoes().openSession();

		try {

			@SuppressWarnings("deprecation")
			Criteria consulta = sessao.createCriteria(Cidade.class);
			
			consulta.add(Restrictions.eq("estado.codigo", estadoId));
			
			consulta.addOrder(Order.asc("nome"));
			List<Cidade> resultado = consulta.list();
			return resultado;

		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
		
	}

}
