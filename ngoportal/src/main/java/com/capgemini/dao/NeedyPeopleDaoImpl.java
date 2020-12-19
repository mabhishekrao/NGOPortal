package com.capgemini.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.capgemini.model.NeedyPeople;

public class NeedyPeopleDaoImpl implements NeedyPeopleDao {

	private EntityManager entityManager;
	
	public NeedyPeopleDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public int createNeedyPerson(NeedyPeople person) {
		entityManager.persist(person);
		return 0;
	}

	public boolean readLoginData(NeedyPeople person) {
		List<NeedyPeople> people = entityManager.createQuery("select np from NeedyPeople np", NeedyPeople.class).getResultList();
		return false;
	}

	public boolean requestForHelp(NeedyPeople person) {
		
		return false;
	}

}
