package com.cg.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.cg.bean.Game;
import com.cg.exception.DuplicateGameException;
import com.cg.repo.GameRepo;
import com.cg.repoImpl.GameRepoImpl;
import com.cg.service.GameService;

public class GameServiceImpl implements GameService {

	private GameRepo repo;

	public GameServiceImpl(GameRepo repo) {
		super();
		this.repo = repo;
	}

	public Game add(Game game) {

		if (game == null || game.getName() == null) {
			throw new IllegalArgumentException();
		}

		Game existingGame = repo.findByName(game.getName());
		if (existingGame != null) {
			throw new DuplicateGameException();
		}
		return repo.save(game);

	}
}
