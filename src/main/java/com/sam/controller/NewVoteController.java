package com.sam.controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sam.beans.MyContext;
import com.sam.beans.VoteContext;
import com.sam.db.models.User;
import com.sam.voting.Vote;

@ManagedBean
@ViewScoped
public class NewVoteController {

	@ManagedProperty(value = "#{myContext}")
	MyContext myContext;
	
	String question;
	
	public Logger logger = LogManager.getLogger("CDILogger");
	
	public NewVoteController() {
		// TODO Auto-generated constructor stub
	}
	
	public void submit() {
		FacesContext facesContext = FacesContext.getCurrentInstance(); 
    	HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
    	User user = (User)session.getAttribute("user");
		Vote vote = new Vote(question, user.getUsername());
		VoteContext.getContext().removeVoteDoublons(user.getUsername());
		VoteContext.getContext().getVotes().add(vote);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("../users/vote.xhtml?nom=" + user.getUsername());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the myContext
	 */
	public MyContext getMyContext() {
		return myContext;
	}

	/**
	 * @param myContext the myContext to set
	 */
	public void setMyContext(MyContext myContext) {
		this.myContext = myContext;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	
	
}
