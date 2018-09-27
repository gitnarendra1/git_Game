package com.cg.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.bean.Day;
import com.cg.bean.Game;
import com.cg.exception.DuplicateGameException;
import com.cg.repo.DayRepo;
import com.cg.repo.GameRepo;
import com.cg.service.DayService;
import com.cg.service.GameService;
import com.cg.serviceImpl.DayServiceImpl;
import com.cg.serviceImpl.GameServiceImpl;


public class DayServiceTest {

	private DayService service;
	@Mock
	private DayRepo repo;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		service = new DayServiceImpl(repo);
	}

	/* 1 : Null days cannot be added */
	@Test(expected = IllegalArgumentException.class)
	public void test_add_dayObjectIsNull() {
		Day day = null;
		when(repo.save(day)).thenReturn(day);
		assertEquals(day, service.add(null));
	}

	/* 2 : Day name cannot be null */
	@Test(expected = IllegalArgumentException.class)
	public void test_add_dayNameIsNull_throwsExceptionForIlllegalArguments() {
		Set<Game> gameSet = new HashSet<Game>();
		gameSet.add(new Game("Cricket", (byte) 11));		
		Day day = new Day(null,gameSet);
		when(repo.save(day)).thenReturn(day);
		assertEquals(day, service.add(day));
	}

	/* 3 : Two days with same name cannot be added */
	@Test(expected = DuplicateGameException.class)
	public void test_add_dayNameAlreadyExist() {
		Set<Game> gameSet = new HashSet<Game>();
		gameSet.add(new Game("Cricket", (byte) 11));
		Day day = new Day("Day1",gameSet);
		when(repo.findByName(day.getName())).thenReturn(day);
		service.add(day);
			}

	/* 4 : Valid day should be added */
	@Test
	public void test_add_success() {
		Set<Game> gameSet = new HashSet<Game>();
		gameSet.add(new Game("Cricket", (byte) 11));
		Day day = new Day("Day1",gameSet);
		when(repo.save(day)).thenReturn(day);
		assertEquals(day, service.add(day));
	}

}
