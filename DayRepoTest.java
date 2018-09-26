package com.cg.repo.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cg.beans.Day;
import com.cg.beans.Game;
import com.cg.exception.DuplicateElementException;
import com.cg.repo.DayRepo;
import com.cg.repo.DayRepoImpl;

public class DayRepoTest {

	/*private DayRepo dayRepo;
		
	@Before
	public void init(){
		
		dayRepo = new DayRepoImpl();
	}*/
	
	@Test(expected=NullPointerException.class)
	public void test_save() {
		DayRepo dayRepo = new DayRepoImpl();
		Day day = new Day();
		try {
			dayRepo.save(day);
		} catch (DuplicateElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(expected=NullPointerException.class)
	public void test_save1() {
		DayRepo dayRepo = new DayRepoImpl();
		Day day = null;		
		try {
			dayRepo.save(day);
		} catch (DuplicateElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(expected=DuplicateElementException.class)
	public void test_save2() throws DuplicateElementException {
		DayRepo dayRepo = new DayRepoImpl();
		
		Day day = new Day();
		day.setName("hockey");		
		dayRepo.save(day);
		
		Day day1 = new Day();
		day1.setName("hockey");
		dayRepo.save(day1);
	}
	

	@Test(expected=NullPointerException.class)
	public void test_findByGamesName() {
		DayRepo dayRepo = new DayRepoImpl();
		String GameName =null;
		dayRepo.findByGamesName(GameName);
	}
	
	@Test
	public void test_findByGamesName1() {
		DayRepo dayRepo = new DayRepoImpl();
		Game game = new Game();
		game.setName("hockey");
		
		Day day = new Day();
		day.setName("1");
		day.setGame(game);
		
		try {
			dayRepo.save(day);
		} catch (DuplicateElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String GameName ="hockey";
		List<Day> days=dayRepo.findByGamesName(GameName);
	
		assertFalse(days.isEmpty());
	}
	
	@Test
	public void test_findByGamesName2() {
		DayRepo dayRepo = new DayRepoImpl();
		Game game = new Game();
		game.setName("hockey");
		
		Day day = new Day();
		day.setName("1");
		day.setGame(game);
		
		try {
			dayRepo.save(day);
		} catch (DuplicateElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String GameName ="cricket";
		List<Day> days=dayRepo.findByGamesName(GameName);
		System.out.println(days.size());
		assertTrue(days.isEmpty());
	}
	
	
}
