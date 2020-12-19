package com.capgemini.service;

import com.capgemini.model.NeedyPeople;

public interface NeedyPeopleService {
	public boolean registerNeedyPerson(NeedyPeople person);
	public boolean login(NeedyPeople person);
	public boolean requestForHelp(NeedyPeople person);
	
}
