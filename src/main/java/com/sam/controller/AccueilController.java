package com.sam.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sam.beans.MyContext;
import com.sam.db.models.User;

@ManagedBean
@ViewScoped
public class AccueilController {

	//@ManagedProperty(value = "#{myContext}")
	MyContext myContext;
	
//	String login;
//	String password;
//	String email;
	User user;

	public Logger logger = LogManager.getLogger("CDILogger");
	
	/**
	 * Default Constructor
	 */
	public AccueilController() {
		myContext = new MyContext();
		user = (User)myContext.getSession().getAttribute("user");
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	
}
