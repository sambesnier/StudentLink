package com.sam.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.sam.db.dao.IRepository;
import com.sam.db.dao.impl.Repository;
import com.sam.voting.Vote;

@ManagedBean(name="myContext")
@SessionScoped
public class MyContext {
	IRepository repository;
	FacesContext facesContext;
	HttpSession session;
	List<Vote> votes;
	
	public MyContext() {
		repository = new Repository();
		facesContext = FacesContext.getCurrentInstance(); 
    	session = (HttpSession) facesContext.getExternalContext().getSession(true);
    	votes = new ArrayList<Vote>();
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

	/**
	 * @return the votes
	 */
	public List<Vote> getVotes() {
		return votes;
	}

	/**
	 * @param votes the votes to set
	 */
	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}
	
	public Vote getVoteByName(String nom) {
		System.out.println("testtt");
		for (int i = 0; i < votes.size(); i++) {
			if (votes.get(i).getNom().equals(nom)) {
				return votes.get(i);
			}
		}
		return null;
	}
	
	
}
