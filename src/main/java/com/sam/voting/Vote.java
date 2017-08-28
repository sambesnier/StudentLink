package com.sam.voting;

public class Vote {

	String question;
	
	String nom;
	
	int yes;
	
	int no;
	
	int blur;
	
	int votants;
	
	public Vote(String question, String nom) {
		setYes(0);
		setNo(0);
		setBlur(0);
		setVotants(0);
		setQuestion(question);
		setNom(nom);
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

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the yes
	 */
	public int getYes() {
		return yes;
	}

	/**
	 * @param yes the yes to set
	 */
	public void setYes(int yes) {
		this.yes = yes;
	}

	/**
	 * @return the no
	 */
	public int getNo() {
		return no;
	}

	/**
	 * @param no the no to set
	 */
	public void setNo(int no) {
		this.no = no;
	}

	/**
	 * @return the blur
	 */
	public int getBlur() {
		return blur;
	}

	/**
	 * @param blur the blur to set
	 */
	public void setBlur(int blur) {
		this.blur = blur;
	}

	/**
	 * @return the votants
	 */
	public int getVotants() {
		return votants;
	}

	/**
	 * @param votants the votants to set
	 */
	public void setVotants(int votants) {
		this.votants = votants;
	}
	
	
}
