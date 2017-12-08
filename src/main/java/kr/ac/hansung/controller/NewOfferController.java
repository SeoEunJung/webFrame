package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import kr.ac.hansung.model.NewOffer;
import kr.ac.hansung.service.NewOfferService;

@Controller
public class NewOfferController {

	@Autowired
	private NewOfferService newofferService;
	
	@RequestMapping("/createoffer")
	public String createOffers(Model model) {
		
		model.addAttribute("newoffer", new NewOffer());
		return "createoffer";
	}
	
	@RequestMapping("/docreate")
	public String docreate(Model model, @Valid NewOffer newoffer, BindingResult result) {

		if(result.hasErrors()){
			System.out.println("===Form data does not validated");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error:errors){
				System.out.println(error.getDefaultMessage());
			}
			return "createoffer";
		}
		newofferService.insert(newoffer);
		
		return "offercreated";
	}
	@RequestMapping("/newoffers")
	public String showNewOffers(Model model){
		List<NewOffer> newoffers = newofferService.getCurrent();
		model.addAttribute("newoffers", newoffers);
	
		return "newoffers";
	}
}
