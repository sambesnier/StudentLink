package com.sam.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.sam.db.dao.IRepository;
import com.sam.db.dao.impl.Repository;

@ManagedBean(name="myContext")
@SessionScoped
public class MyContext {
	IRepository repository;
	FacesContext facesContext;
	HttpSession session;
	
	public MyContext() {
		repository = new Repository();
		facesContext = FacesContext.getCurrentInstance(); 
    	session = (HttpSession) facesContext.getExternalContext().getSession(true);
	}

	/**
	 * @return the repository
	 */
	public IRepository getRepository() {
		return repository;
	}

	/**
	 * @param repository the repository to set
	 */
	public void setRepository(IRepository repository) {
		this.repository = repository;
	}
	
	/**
	 * @return the session
	 */
	public HttpSession getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(HttpSession session) {
		this.session = session;
	}
}
