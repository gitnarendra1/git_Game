package com.cg.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cg.bean.Day;
import com.cg.bean.Game;
import com.cg.exception.DuplicateElementException;
import com.cg.repo.DayRepo;
import com.cg.repoimpl.DayRepoImpl;

public class DayRepoTest {

	private DayRepo dayRepo;
		
	@Before
	public void init(){
		
		dayRepo = new DayRepoImpl();
	}
	
	@Test(expected=NullPointerException.class)
	public void test_save() {
		Day day = new Day();
		dayRepo.save(day);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_save1() {
		Day day = null;		
		dayRepo.save(day);
	}
	
	@Test(expected=DuplicateElementException.class)
	public void test_save2() {
		Day day = new Day();
		day.setName("hockey");
		dayRepo.save(day);
		
		Day day1 = new Day();
		day1.setName("hockey");
		dayRepo.save(day1);
	}
	

	@Test(expected=NullPointerException.class)
	public void test_findByGamesName() {
		String GameName =null;
		dayRepo.findByGamesName(GameName);
	}
	
	@Test
	public void test_findByGamesName1() {
		Game game = new Game();
		game.setName("hockey");
		
		Day day = new Day();
		day.setName("1");
		day.setGame(game);
		
		dayRepo.save(day);
		
		String GameName ="hockey";
		List<Day> days=dayRepo.findByGamesName(GameName);
	
		assertFalse(days.isEmpty());
	}
	
	@Test
	public void test_findByGamesName2() {
		Game game = new Game();
		game.setName("hockey");
		
		Day day = new Day();
		day.setName("1");
		day.setGame(game);
		
		dayRepo.save(day);
		
		String GameName ="cricket";
		List<Day> days=dayRepo.findByGamesName(GameName);
	
		assertTrue(days.isEmpty());
	}
	
	
}
