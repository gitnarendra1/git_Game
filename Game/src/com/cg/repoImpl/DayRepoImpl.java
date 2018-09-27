package com.cg.repoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cg.bean.Day;
import com.cg.bean.Game;
import com.cg.repo.DayRepo;

public class DayRepoImpl implements DayRepo{
	private Set<Day> day;

	public DayRepoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Day save(Day day) {
		// TODO Auto-generated method stub
		return day;
	}

	public Day findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Day> getday() {
		return day;
	}

	public void setGames(Set<Day> day) {
		this.day = day;
	}		
	
	

}
