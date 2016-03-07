package br.edu.ifpi.ads.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns="/*")
public class EntityManagerFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		try {
			JPAUtil.getCurrentEntityManager().getTransaction().begin();
			System.out.println("JPA Filter..");
			chain.doFilter(req, resp);
			JPAUtil.getCurrentEntityManager().getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JPAUtil.getCurrentEntityManager().getTransaction().rollback();
			new ServletException(e);
		}finally{
			JPAUtil.closeCurrentEntityManager();
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
