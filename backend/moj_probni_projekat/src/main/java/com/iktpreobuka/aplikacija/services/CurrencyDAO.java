package com.iktpreobuka.aplikacija.services;

import com.iktpreobuka.aplikacija.entities.CurrencyEntity;

public interface CurrencyDAO {
	
	public CurrencyEntity findCurrencyByName(String name);

}
