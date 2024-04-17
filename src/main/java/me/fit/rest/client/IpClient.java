package me.fit.rest.client;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import me.fit.rest.IpLog;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@Path("/data")
@RegisterRestClient(configKey = "ip-client")
public interface IpClient {

    @GET
    @Path("/client-ip")
    IpLog getIp();
}