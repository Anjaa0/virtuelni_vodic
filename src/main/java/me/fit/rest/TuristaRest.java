package me.fit.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import me.fit.service.TuristaService;


@Path("/turista")

public class TuristaRest {

	    @Inject
	    private TuristaService turistaService; 
	    
	 
	    @GET
	    @Path("/svetijebem")
	    @Produces(MediaType.TEXT_PLAIN)
	    public String hello() {
	        return "Ćao Anja";
	    }
	    
	    @GET
	    @Path("/jbg")
	    @Produces(MediaType.TEXT_PLAIN)
	    public String goodbye() {
	        return "Doviđenja Anja";
	    }
}
