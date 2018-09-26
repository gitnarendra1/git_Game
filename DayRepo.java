package com.cg.repo;

import java.util.List;

import com.cg.beans.Day;
import com.cg.exception.DuplicateElementException;

public interface DayRepo {


	public Day save(Day day) throws DuplicateElementException;
	
	//public Day findByPlayerName(String playerName);
	
	public List<Day> findByGamesName(String gameName);
}
