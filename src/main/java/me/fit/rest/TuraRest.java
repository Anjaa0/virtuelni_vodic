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
import me.fit.exception.TuraException;
import me.fit.model.Tura;
import me.fit.service.TuraService;

@Path("/tura")
public class TuraRest {
    @Inject
    private TuraService turaServis; 
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/createTura")
    public Response createTura(Tura t) {
        try {
           Tura ture = turaServis.dodajTuru(t);
            return Response.ok().entity(ture).build();
        } catch (TuraException e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllTure")
    public Response getAllTure() {
        List<Tura> ture = turaServis.getAllTure();
        return Response.ok().entity(ture).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getTuraByName")
    public Response geByTuraName(@QueryParam(value = "name") String name) {
        System.out.println("NAME QUERY PARAMETER: " + name);
        List<Tura> ture = turaServis.getTuraByName(name);
        return Response.ok().entity(ture).build();
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
