package com.cg.repoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cg.bean.Day;
import com.cg.bean.Game;
import com.cg.exception.DuplicateElementException;

public class DayRepoImpl implements DayRepo{

	List<Day> days = new ArrayList<Day>();
	
	public Day save(Day day) throws DuplicateElementException {
		if(day == null)
			throw new NullPointerException();
		if(day.getName()==null)
			throw new NullPointerException();
		
		if(days.contains(day))
			throw new DuplicateElementException("day object already present");
		
		days.add(day);
		
		return day;
	}

	public List<Day> findByGamesName(String gameName) {
		if(gameName == null)
			throw new NullPointerException();
		List<Day> d1 = new ArrayList<Day>();
		
		for(Day d:days) {
			
			Set<Game> games=d.getGames();
			
			for(Game g:games) {
				
				String sname=g.getName();						
				
				if(sname==gameName)
				{
					d1.add(d);
				}
			}
		}
		
		return d1;
	}
	
	

}
