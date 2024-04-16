package me.fit.service;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.enmus.TuristaStatus;
import me.fit.exception.TuristaException;
import me.fit.model.Turista;


@Dependent
public class TuristaService {

		@Inject
		private EntityManager em;
		
		@Transactional
		public Turista dodajTuristu(Turista t) throws TuristaException {
			
			List<Turista>turisti=getAllTuriste();
			
	       if(turisti.contains(t)){
	    	throw new TuristaException(TuristaStatus.EXISTS.getLabel());   
	       }
			
			
			return em.merge(t);
		}

		@Transactional
		public List<Turista> getAllTuriste() {
			List<Turista> turisti = em.createNamedQuery(Turista.GET_ALL_TURISTE, Turista.class).getResultList();

			return turisti;
		}
		@Transactional
		public List<Turista> getTuristaByName(String name) {
			List<Turista>turisti = em.createNamedQuery(Turista.GET_TURISTA_BY_NAME, Turista.class)
					.setParameter("name", name).getResultList();
			
			return turisti;

		}
}
