package com.cg.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import com.cg.bean.Day;
import com.cg.bean.Player;
import com.cg.repo.DayRepo;
import com.cg.repoImpl.DayRepoImpl;

public class DayRepoTest {
	private DayRepo dayRepo ;
	@Test(expected=NullPointerException.class)
	public void test_save() {
		Day day = new Day();
		dayRepo.save(day);
	}
	
	@Test(expected=NullPointerException.class)
	public void test_save1() {
		Day day = null;		
		dayRepo.save(day);
			}
	
	@Test(expected=Exception.class)
	public void test_save2() throws Exception {
		Day player1=new Day();
		player1.setName("Day1");
		
		Day player2=new Day();
		player2.setName("Day2");
		
		Day player3=new Day();
		player3.setName("Day3");
		
		
	    List<Day> l1=new ArrayList<Day>();
	    l1.add(player1);
	    l1.add(player2);
	    l1.add(player3);
	    assertEquals(3, l1.size());
	}

}
