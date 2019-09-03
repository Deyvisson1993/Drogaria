package br.com.deyvisson.dao;

import org.hibernate.Session;
import org.junit.Test;

import br.com.deyvisson.util.HibernetUtil;

public class JpaUtilTest {
	
	
	@Test
	public void co() {
		
		Session session = HibernetUtil.getFabricaDeSessoes().openSession();
		session.close();
		HibernetUtil.getFabricaDeSessoes().close();
	}

}
