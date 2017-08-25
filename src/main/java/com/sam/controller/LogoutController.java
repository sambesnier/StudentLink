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
public class LogoutController {
	
	@ManagedProperty(value = "#{myContext}")
	MyContext myContext;
	public Logger logger = LogManager.getLogger("CDILogger");
	public LogoutController() {
		// TODO Auto-generated constructor stub
	}
	
	public void logout() {
		
		
		FacesContext facesContext = FacesContext.getCurrentInstance(); 
    	HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
    	session.removeAttribute("user");
    	System.out.println("test");
    	
    	
    	try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
		} catch (IOException e) {
			
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

}
