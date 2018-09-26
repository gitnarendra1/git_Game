package com.cg.Test;

import org.junit.Test;
import org.mockito.Mock;

import com.cg.bean.Game;
import com.cg.repo.GameRepo;
import com.cg.service.GameService;

public class GameRepoTest {
	
	private GameRepo repo;	
	
	@Test
	public Game test_save(Game g)
	{
		return g;
		
	}
	
	@Test
	public Game test_findByName(String name)
	{
		return null;
		
	}
}
