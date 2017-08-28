package com.sam.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.sam.beans.VoteContext;
import com.sam.voting.Vote;

@ManagedBean
@ViewScoped
public class ListeVoteController {

	List<Vote> votes;
	
	public ListeVoteController() {
		votes = VoteContext.getContext().getVotes();
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
	
	
	
}
