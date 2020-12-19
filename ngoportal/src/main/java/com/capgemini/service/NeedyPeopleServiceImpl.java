package com.capgemini.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.capgemini.dao.NeedyPeopleDao;
import com.capgemini.dao.NeedyPeopleDaoImpl;
import com.capgemini.model.NeedyPeople;
import com.capgemini.util.Util;

public class NeedyPeopleServiceImpl implements NeedyPeopleService {

	private final EntityManager entityManager;
	private NeedyPeopleDao needyPeopleDao;

	public NeedyPeopleServiceImpl() {
		Util util = Util.getInstance();
		entityManager = util.getEntityManager();
		needyPeopleDao = new NeedyPeopleDaoImpl(entityManager);
	}

	public boolean registerNeedyPerson(NeedyPeople person) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		needyPeopleDao.createNeedyPerson(person);
		entityTransaction.commit();
		return true;
	}

	public boolean login(NeedyPeople person) {
		needyPeopleDao.readLoginData(person);
		return true;
	}

	public boolean requestForHelp(NeedyPeople person) {
		needyPeopleDao.requestForHelp(person);
		return false;
	}

}
