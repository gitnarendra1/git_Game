package com.cg.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.cg.bean.Day;
import com.cg.bean.Game;
import com.cg.exception.DuplicateGameException;
import com.cg.repo.DayRepo;
import com.cg.repoImpl.DayRepoImpl;


public class DayRepoTest {

	/*private DayRepo dayRepo;
		
	@Before
	public void init(){
		
		dayRepo = new DayRepoImpl();
	}*/
	
	@Test(expected=NullPointerException.class)
	public void test_save() {
		DayRepo dayRepo = new DayRepoImpl();
		Day day = null;
		
			dayRepo.save(day);
		
	}
	
	@Test(expected=NullPointerException.class)
	public void test_save1() {
		DayRepo dayRepo = new DayRepoImpl();
		Day day = null;		
		try {
			dayRepo.save(day);
		} catch (DuplicateGameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(expected=DuplicateGameException.class)
	public void test_save2() throws DuplicateGameException {
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
		} catch (DuplicateGameException e) {
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
		} catch (DuplicateGameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String GameName ="cricket";
		List<Day> days=dayRepo.findByGamesName(GameName);
		System.out.println(days.size());
		assertTrue(days.isEmpty());
	}
	
	
}