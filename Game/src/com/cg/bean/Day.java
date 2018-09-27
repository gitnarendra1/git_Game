package com.cg.bean;

import java.util.Set;

public class Day {
private String name;
private Set<Game> games;

public Day() {
	super();
}

public Day(String name, Set<Game> games) {
	super();
	this.name = name;
	this.games = games;
	}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Set<Game> getGames() {
	return games;
}
public void setGames(Set<Game> games) {
	this.games = games;
}
}



