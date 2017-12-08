package kr.ac.hansung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Offer2;
import kr.ac.hansung.service.Offer2Service;
@Controller
public class Offer2Controller {

	@Autowired
	private Offer2Service offer2Service;
	
	@RequestMapping("/offers2")
	public String showOffers2(Model model){
		List<Offer2> offers2 = offer2Service.getCurrent();
		model.addAttribute("offers2", offers2);
	
		return "offers2";
	}
}
