package com.cg.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.cg.bean.Game;
import com.cg.repo.GameRepo;
import com.cg.repoImpl.GameRepoImpl;
import com.cg.service.GameService;

public class GameServiceImpl implements GameService {

	@Override
	public Game add(Game g) {
		
		GameRepoImpl repoImpl=new GameRepoImpl();
		g.setName("Cricket");
		g.setNumofplayers((byte)11);
		repoImpl.save(g);
		
		return g;
	}

}
