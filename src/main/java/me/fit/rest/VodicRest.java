package me.fit.rest;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.exception.VodicException;
import me.fit.model.Vodic;
import me.fit.rest.client.IpClient;
import me.fit.service.VodicService;

@Path("/vodic")
public class VodicRest {
	
	@RestClient
	@Inject
	IpClient ipclient;
	

    @Inject
    private VodicService vodicServis;
    

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Ćao Anja";
    }
 
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/createVodic")
    public Response createVodic(Vodic v) {
        try {
        	IpLog iplog=ipclient.getIp();
            Vodic vodic = vodicServis.dodajVodica(v,iplog);
            return Response.ok().entity(vodic).build();
        } catch (VodicException e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllVodici")
    public Response getAllVodic() {
        List<Vodic> vodici = vodicServis.getAllVodic();
        return Response.ok().entity(vodici).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getVodicByName")
    public Response getVodicByName(@QueryParam(value = "name") String name) {
        System.out.println("NAME QUERY PARAMETER: " + name);
        List<Vodic> vodici = vodicServis.getVodicByName(name);
        return Response.ok().entity(vodici).build();
    }

    @GET
    @Path("/goodbye")
    @Produces(MediaType.TEXT_PLAIN)
    public String goodbye() {
        return "Doviđenja Anja";
    }
}

