package com.cg.repoImpl;

import java.util.Set;

import com.cg.bean.Game;
import com.cg.repo.GameRepo;

public class GameRepoImpl implements GameRepo {
	private Set<Game> games;

	public Game save(Game game) {
		return game ;
	}

	public Game findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}

}
