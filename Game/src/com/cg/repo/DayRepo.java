package com.cg.repo;



import java.util.List;

import com.cg.bean.Day;
import com.cg.bean.Game;


public interface DayRepo {
	
	public Day save(Day day) ;
	public Day findByName(String name);
}
