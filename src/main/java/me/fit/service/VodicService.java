package me.fit.service;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.exception.VodicException;
import me.fit.exception.VodicStatus;
import me.fit.model.Vodic;

@Dependent
public class VodicService {

	@Inject
	private EntityManager em;
	
	@Transactional
	public Vodic dodajVodica(Vodic v) throws VodicException {
		
		List<Vodic> vodici=getAllVodic();
		
       if(vodici.contains(v)){
    	throw new VodicException(VodicStatus.EXISTS.getLabel());   
       }
		
		
		return em.merge(v);
	}
	
	@Transactional
	public List<Vodic> getAllVodic() {
		List<Vodic> vodici = em.createNamedQuery(Vodic.GET_ALL_VODIC, Vodic.class).getResultList();

		return vodici;
	}
	@Transactional
	public List<Vodic> getVodicByName(String name) {
		List<Vodic> vodici = em.createNamedQuery(Vodic.GET_VODIC_BY_NAME, Vodic.class)
				.setParameter("name", name).getResultList();
		
		return vodici;

	}
	
	

}
