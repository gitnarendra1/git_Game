package com.cg.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cg.bean.Game;
import com.cg.bean.Player;
import com.cg.exception.DuplicateElementException;
import com.cg.repo.PlayerRepo;
import com.cg.repoimpl.PlayerRepoImpl;

public class PlayerRepoTest {

	
	private PlayerRepo playerRepo;
	
	@Before
	public void init(){
		
		playerRepo = new PlayerRepoImpl();
	}
	
	@Test(expected=NullPointerException.class)
	public void test_save() {
		Player player = new Player();
		playerRepo.save(player);
	}
	
	@Test(expected=NullPointerException.class)
	public void test_save1() {
		Player player = null;		
		playerRepo.save(player);
	}
	
	@Test(expected=DuplicateElementException.class)
	public void test_save2() {
		Player player = new Player();
		player.setName("vickey");
		playerRepo.save(player);
		
		Player player1 = new Player();
		player.setName("vickey");
		playerRepo.save(player1);
	}
	

	@Test(expected=NullPointerException.class)
	public void test_findByGamesName() {
		String gameName =null;
		playerRepo.findByGamesName(gameName);
	}
	
	@Test
	public void test_findByGamesName1() {
		Game game = new Game();
		game.setName("hockey");
		
		Player player = new Player();
		player.setName("vickey");
		player.setGame(game);
		
		playerRepo.save(player);
		
		String GameName ="hockey";
		List<Player> players=playerRepo.findByGamesName(GameName);
	
		assertFalse(players.isEmpty());
	}
	
	@Test
	public void test_findByGamesName2() {
		Game game = new Game();
		game.setName("hockey");
		
		Player player = new Player();
		player.setName("vickey");
		player.setGame(game);
		
		playerRepo.save(player);
		
		String GameName ="cricket";
		List<Player> players=playerRepo.findByGamesName(GameName);
	
		assertTrue(players.isEmpty());
	}
	
}
