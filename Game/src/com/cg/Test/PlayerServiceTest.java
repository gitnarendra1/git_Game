package com.cg.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.bean.Game;
import com.cg.bean.Player;
import com.cg.exception.DuplicateGameException;
import com.cg.repo.PlayerRepo;
import com.cg.service.PlayerService;
import com.cg.serviceImpl.PlayerServiceImpl;


public class PlayerServiceTest {

	private PlayerService service;
	@Mock
	private PlayerRepo repo;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		service = new PlayerServiceImpl(repo);
	}

	/* 1 : Null games cannot be added */
	@Test(expected = IllegalArgumentException.class)
	public void test_add_playerObjectIsNull() {
		Player player = null;
		when(repo.save(player)).thenReturn(player);
		assertEquals(player, service.add(null));
	}

	/* 2 : Player name cannot be null */
	@Test(expected = IllegalArgumentException.class)
	public void test_add_playerNameIsNull_throwsExceptionForIlllegalArguments() {
		Set<Game> gameSet = new HashSet<Game>();
		gameSet.add(new Game("Cricket", (byte) 11));		
		Player player = new Player(null,gameSet);
		when(repo.save(player)).thenReturn(player);
		assertEquals(player, service.add(player));
	}

	/* 3 : Two players with same name cannot be added */
	@Test(expected = DuplicateGameException.class)
	public void test_add_gameNameAlreadyExist() {
		Set<Game> gameSet = new HashSet<Game>();
		gameSet.add(new Game("Cricket", (byte) 11));		
		Player player = new Player("Virat",gameSet);
		when(repo.findByName(player.getName())).thenReturn(player);
		service.add(player);
	}

	/* 4 : Valid games should be added */
	@Test
	public void test_add_success() {
		Set<Game> gameSet = new HashSet<Game>();
		gameSet.add(new Game("Cricket", (byte) 11));
		Player player = new Player("Virat",gameSet);
		when(repo.save(player)).thenReturn(player);
		assertEquals(player, service.add(player));
	}

}
