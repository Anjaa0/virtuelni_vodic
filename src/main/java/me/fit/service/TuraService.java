package me.fit.service;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.enmus.TuraStatus;

import me.fit.exception.TuraException;

import me.fit.model.Tura;

@Dependent
public class TuraService {
	@Inject
	private EntityManager em;
	
	@Transactional
	public Tura dodajTuru(Tura t) throws TuraException {
		
		List<Tura>ture=getAllTure();
		
       if(ture.contains(t)){
    	throw new TuraException(TuraStatus.EXISTS.getLabel());   
       }
		
		
		return em.merge(t);
	}

	@Transactional
	public List<Tura> getAllTure() {
		List<Tura> ture = em.createNamedQuery(Tura.GET_ALL_TURE, Tura.class).getResultList();

		return ture;
	}
	@Transactional
	public List<Tura> getTuraByName(String name) {
		List<Tura>ture = em.createNamedQuery(Tura.GET_TURA_BY_NAME, Tura.class)
				.setParameter("name", name).getResultList();
		
		return ture;

	}
}
