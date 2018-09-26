package com.cg.repoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cg.bean.Game;
import com.cg.repo.GameRepo;

public class GameRepoImpl implements GameRepo {
private Set<Game> games;

public Game save(Game g){
	return g;
}

@Override
public Game fidByName(String name) {
	// TODO Auto-generated method stub
	return null;
}
}
