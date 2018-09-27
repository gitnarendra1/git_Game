package com.cg.serviceImpl;

import com.cg.bean.Day;
import com.cg.bean.Game;
import com.cg.exception.DuplicateGameException;
import com.cg.repo.DayRepo;
import com.cg.repo.GameRepo;
import com.cg.service.DayService;

public class DayServiceImpl implements DayService {
	private DayRepo repo;

	public DayServiceImpl(DayRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Day add(Day day) {
		if (day == null || day.getName() == null) {
			throw new IllegalArgumentException();
		}

		Day existingDay = repo.findByName(day.getName());
		if (existingDay != null) {
			throw new DuplicateGameException();
		}
		return repo.save(day);
	}
	
	

}
