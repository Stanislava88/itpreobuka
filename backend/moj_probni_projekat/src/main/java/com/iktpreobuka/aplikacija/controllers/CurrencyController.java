package com.iktpreobuka.aplikacija.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.aplikacija.entities.CurrencyEntity;
import com.iktpreobuka.aplikacija.repositories.CurrencyRepository;

@RestController
@RequestMapping(path = "/currency")
public class CurrencyController {
	
	@Autowired
	private CurrencyRepository currencyRepository;
	
	@RequestMapping(path = "/all", method=RequestMethod.GET)
	public Iterable<CurrencyEntity> getCurrencies(){
		try {
			return currencyRepository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

}
