package com.cg.bean;


public class Game {
	private String name;
	private byte numberOfPlayers;

	public Game() {
		super();
	}

	public Game(String name, byte numberOfPlayers) {
		super();
		this.name = name;
		this.numberOfPlayers = numberOfPlayers;
	}

	@Override
	public String toString() {
		return "Game [name=" + name + ", numberOfPlayers=" + numberOfPlayers + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numberOfPlayers;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberOfPlayers != other.numberOfPlayers)
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(byte numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

}
