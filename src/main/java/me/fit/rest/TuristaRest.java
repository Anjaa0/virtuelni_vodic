package me.fit.rest;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.exception.TuristaException;
import me.fit.model.Turista;
import me.fit.service.TuristaService;


@Path("/turista")

public class TuristaRest {

	    @Inject
	    private TuristaService turistaServis; 
	    
	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Path("/createTurista")
	    public Response createTurista(Turista t) {
	        try {
	           Turista turista = turistaServis.dodajTuristu(t);
	            return Response.ok().entity(turista).build();
	        } catch (TuristaException e) {
	            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
	        }
	    }
	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    @Path("/getAllTuriste")
	    public Response getAllTuriste() {
	        List<Turista> turiste = turistaServis.getAllTuriste();
	        return Response.ok().entity(turiste).build();
	    }

	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    @Path("/getTuristaByName")
	    public Response geByTuristaName(@QueryParam(value = "name") String name) {
	        System.out.println("NAME QUERY PARAMETER: " + name);
	        List<Turista> turisti = turistaServis.getTuristaByName(name);
	        return Response.ok().entity(turisti).build();
	    }
	   
	    @GET
	    @Path("/zdravo")
	    @Produces(MediaType.TEXT_PLAIN)
	    public String hello() {
	        return "Ćao Anja";
	    }
	    
	    @GET
	    @Path("/prijatno")
	    @Produces(MediaType.TEXT_PLAIN)
	    public String goodbye() {
	        return "Doviđenja Anja";
	    }
}
