package com.cg.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.mockito.Mock;

import com.cg.bean.Day;
import com.cg.repo.DayRepo;
import com.cg.repo.GameRepo;
import com.cg.service.DayService;


public class DayServiceTest {
	private DayService service;
	@Mock private DayRepo repo;
	
	@Test
	public void test_day_object_null() {
		  Day days = null;		 
		    assertNull("day object is null", days);
	}
	
	@Test(expected=NullPointerException.class)
	public void test_save_throwsNullPointerException(){
		Day day1=new Day();
		service.add(day1);
			}
	
	@Test
	public void test_dayName_null(){
		Day day1=new Day();
		day1.setName(null);
		//assertEquals(null,game1.getName());
		assertThat(day1.getName(), nullValue(String.class));
			}
	
	@Test
	public void test_dayName_duplication() {
		 Day day1=new Day();
		 day1.setName("Day1");
		 Day day2=new Day();
		 day2.setName("Day1");
		 //assertEquals(game1.getName(),game2.getName());
		 assertSame("Duplicate Day Name",day1.getName(),day2.getName());
		 }
	
	@Test
	public void test_add_success(){
		Day day1=new Day();
		day1.setName("Day1");
		Set s=new HashSet();
		s.add("Cricket");
		day1.setGames(s);
		
	    List<Day> l1=new ArrayList<Day>();
	    l1.add(day1);
	    
	    assertEquals(1, l1.size());
		}
	
	
}
