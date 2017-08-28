package com.sam.websocket;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.sam.beans.MyContext;
import com.sam.beans.VoteContext;

@ApplicationScoped
@ServerEndpoint("/vote/{nom}")
public class WebSocketVote {
	
	@OnOpen
	public void open(@PathParam("nom") String nom, Session session) {
		try {
			JSONObject obj = new JSONObject();
			obj.put("header", 1);
			obj.put("question", VoteContext.getContext().getVoteByName(nom).getQuestion());
			obj.put("votants", VoteContext.getContext().getVoteByName(nom).getVotants());
			
			session.getBasicRemote().sendText(JSONValue.toJSONString(obj));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@OnClose
	public void close(Session session) {
	}

	@OnError
	public void onError(Throwable error) {
	}

	@OnMessage
	public void handleMessage(String message, Session session) {
	}
}
