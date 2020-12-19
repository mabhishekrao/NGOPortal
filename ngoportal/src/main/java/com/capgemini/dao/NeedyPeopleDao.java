package com.capgemini.dao;

import com.capgemini.model.NeedyPeople;

public interface NeedyPeopleDao {
	public int createNeedyPerson(NeedyPeople person);
	public boolean readLoginData(NeedyPeople person);
	public boolean requestForHelp(NeedyPeople person);
}
