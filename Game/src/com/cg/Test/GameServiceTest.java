package com.cg.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.bean.Game;
import com.cg.exception.DuplicateGameException;
import com.cg.repo.GameRepo;
import com.cg.service.GameService;
import com.cg.serviceImpl.GameServiceImpl;


public class GameServiceTest {

	private GameService service;
	@Mock
	private GameRepo repo;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		service = new GameServiceImpl(repo);
	}

	/* 1 : Null games cannot be added */
	@Test(expected = IllegalArgumentException.class)
	public void test_add_gameObjectIsNull() {
		Game game = null;
		when(repo.save(game)).thenReturn(game);
		assertEquals(game, service.add(null));
	}

	/* 2 : Game name cannot be null */
	@Test(expected = IllegalArgumentException.class)
	public void test_add_gameNameIsNull_throwsExceptionForIlllegalArguments() {
		Game game = new Game(null, (byte) 11);
		when(repo.save(game)).thenReturn(game);
		assertEquals(game, service.add(new Game(null, (byte) 11)));
	}

	/* 3 : Two games with same name cannot be added */
	@Test(expected = DuplicateGameException.class)
	public void test_add_gameNameAlreadyExist() {
		Game game = new Game("Cricket", (byte) 11);
		when(repo.findByName(game.getName())).thenReturn(game);
		service.add(game);
	}

	/* 4 : Valid games should be added */
	@Test
	public void test_add_success() {
		Game game = new Game("Cricket", (byte) 11);
		when(repo.save(game)).thenReturn(game);
		assertEquals(game, service.add(new Game("Cricket", (byte) 11)));
	}

}
