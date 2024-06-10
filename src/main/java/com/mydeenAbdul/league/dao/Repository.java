package com.mydeenAbdul.league.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mydeenAbdul.league.dto.Delivery;
import com.mydeenAbdul.league.dto.MatchData;

public class Repository {

	private static Repository repository;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("mydeen");
	private EntityManager em = emf.createEntityManager();
	private EntityTransaction et = em.getTransaction();
	private Repository() {
		
	}
	public static Repository getInstance() {
		if(repository == null) repository = new Repository();
		return repository;
	}
	
	public void storeMatches(List<MatchData> matches) {
		et.begin();
		for (MatchData match : matches) {
			em.persist(match);
		}
		et.commit();
	}
	public void storeDeliveries(List<Delivery> deliveries) {
		et.begin();
		for (Delivery delivery : deliveries) {
			em.persist(delivery);
		}
		et.commit();
	}
	public List<Delivery> getByYear(int year){
		List<MatchData> datas = getMatchDataByYear(year);
		List<Delivery> deliveries = new ArrayList<>();
		for (MatchData data : datas) {
			deliveries.addAll(getDelivery((int)data.getId()));
		}
		return deliveries;
	}
	
	public List<MatchData> getMatchDataByYear(int year){
		String sql = "select m from MatchData m where season = "+year ;
		return em.createQuery(sql, MatchData.class).getResultList();
	}
	public List<Delivery> getDelivery(int id) {
		String sql = "select d from Delivery d where d.match_id = :id";
		Query query = em.createQuery(sql, Delivery.class);
		query.setParameter("id", id);
		return query.getResultList();
	}
	public List<Delivery> getDeliveriesLast() {
		String sql = "select d from Delivery d where d.match_id < :id";
		Query query = em.createQuery(sql, Delivery.class);
		query.setParameter("id", 6);
		return query.getResultList();
	}
}
