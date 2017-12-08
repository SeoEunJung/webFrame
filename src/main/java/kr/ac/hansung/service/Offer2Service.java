package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.Offer2DAO;
import kr.ac.hansung.model.Offer2;

@Service
public class Offer2Service {
	@Autowired
	private Offer2DAO offer2Dao;

	public List<Offer2> getCurrent() {
		return offer2Dao.getOffers2();
	}

	public void insert(Offer2 offer2) {
		offer2Dao.insert(offer2);
	}
}
