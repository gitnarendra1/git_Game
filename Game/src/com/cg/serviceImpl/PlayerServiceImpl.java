package com.cg.serviceImpl;

import com.cg.bean.Game;
import com.cg.bean.Player;
import com.cg.exception.DuplicateGameException;
import com.cg.repo.GameRepo;
import com.cg.repo.PlayerRepo;
import com.cg.service.PlayerService;

public class PlayerServiceImpl implements PlayerService {

	private PlayerRepo repo;

	public PlayerServiceImpl(PlayerRepo repo) {
		super();
		this.repo = repo;
	}

	public Player add(Player player) {

		if (player == null || player.getName() == null) {
			throw new IllegalArgumentException();
		}

		Player existingPlayer = repo.findByName(player.getName());
		if (existingPlayer != null) {
			throw new DuplicateGameException();
		}
		return repo.save(player);

	}
}
