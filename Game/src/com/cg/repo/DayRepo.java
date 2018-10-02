package com.cg.repo;

import java.util.List;

import com.cg.bean.Day;

public interface DayRepo {


	public Day save(Day day);
	
	public List<Day> findByGamesName(String gameName);
}
