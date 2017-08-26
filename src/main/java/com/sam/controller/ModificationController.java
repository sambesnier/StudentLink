package com.sam.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sam.beans.MyContext;
import com.sam.db.models.User;

@ManagedBean
@ViewScoped
public class ModificationController {
	@ManagedProperty(value = "#{myContext}")
	MyContext myContext;
	
	String login;
	String password;
	String newpass1;
	String newpass2;
	User user;
	
	public Logger logger = LogManager.getLogger("CDILogger");

public ModificationController() {
		
}
public boolean login() {
//	logger.info("demande de connexion");

	Map<String, Object> prop = new HashMap<String, Object>();
	prop.put("login", login);
	Object obj = myContext.getRepository().queryObject("User.findByEmailOrUserName", prop);
	
//	logger.info("User = " + obj);
//	
//	
//	logger.info("login = " + login);
//	logger.info("Password = " + password);  
	
    if (obj!=null && ((User)obj).getPassword().equals(password)) {
    
    	user =  (User)obj;
    	
    	FacesContext facesContext = FacesContext.getCurrentInstance(); 
    	HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
    	
    	session.setAttribute("user", user);
    	
    	logger.info("Connexion = OK ");
    	
    	return true;
    	

    } else {
    	
    	logger.info("Connexion = KO ");
    	
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "That's the wrong password.");
        FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
        return false;
    }
}

public boolean Confirm(){
	if (newpass1.equals(newpass2) && (!newpass1.isEmpty())) {
		return true;
	}
	return false;
}

public void soumettre() {
	boolean a = Confirm();
	boolean b = login();
	if ((b == true) && (a == true)) {
		user.setPassword(newpass1);
		myContext.getRepository().update((Object)user);
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("accueil.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else {
		System.out.println("or not");
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
 * @return the login
 */
public String getLogin() {
	return login;
}
/**
 * @param login the login to set
 */
public void setLogin(String login) {
	this.login = login;
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
 * @return the newpass1
 */
public String getNewpass1() {
	return newpass1;
}
/**
 * @param newpass1 the newpass1 to set
 */
public void setNewpass1(String newpass1) {
	this.newpass1 = newpass1;
}
/**
 * @return the newpass2
 */
public String getNewpass2() {
	return newpass2;
}
/**
 * @param newpass2 the newpass2 to set
 */
public void setNewpass2(String newpass2) {
	this.newpass2 = newpass2;
}























}