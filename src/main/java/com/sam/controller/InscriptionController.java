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
import com.sam.db.dao.impl.UserCrud;
import com.sam.db.models.User;

@ManagedBean
@ViewScoped
public class InscriptionController {
	
	@ManagedProperty(value = "#{myContext}")
	MyContext myContext;
	
	String pseudo;
	String password;
	String email;
	
	public Logger logger = LogManager.getLogger("CDILogger");
	
	public InscriptionController() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void subscribe() {
		
		UserCrud uc = new UserCrud();
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setUsername(pseudo);
		
		uc.createUser(user);
		
		FacesContext facesContext = FacesContext.getCurrentInstance(); 
    	HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
    	
    	session.setAttribute("user", user);
    	
    	logger.info("Connexion = OK ");
    	
    	try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("users/accueil.xhtml");
		} catch (IOException e) {
			logger.catching(e);
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
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
