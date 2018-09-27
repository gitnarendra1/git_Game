package com.cg.bean;

import java.util.Set;

public class Player {

	private String name;
	private Set<Game> game;
	public String getName() {
		return name;
	}
	public Player(String name, Set<Game> game) {
		super();
		this.name = name;
		this.game = game;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Game> getGame() {
		return game;
	}
	public void setGame(Set<Game> game) {
		this.game = game;
	}
}
