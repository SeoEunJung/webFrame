package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.NewOfferDAO;
import kr.ac.hansung.model.NewOffer;

@Service
public class NewOfferService {
	@Autowired
	private NewOfferDAO newofferDao;

	public List<NewOffer> getCurrent() {
		return newofferDao.getNewOffers();
	}

	public void insert(NewOffer newoffer) {
		newofferDao.insert(newoffer);
	}
}
