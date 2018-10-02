package com.cg.repo;

import java.util.List;

import com.cg.bean.Player;

public interface PlayerRepo {

	public Player save(Player player);
	
	public List<Player> findByGamesName(String gameName);

}
