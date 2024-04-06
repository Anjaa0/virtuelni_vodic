package me.fit.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.Turista;

@Dependent
public class TuristaService {

		@Inject
		private EntityManager em;
		
		@Transactional
		public Turista createTurista(Turista t) {
			return em.merge(t);
		}
}
