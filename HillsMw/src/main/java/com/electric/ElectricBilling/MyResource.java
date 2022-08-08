
package com.electric.ElectricBilling;

import java.io.File;
import java.io.ObjectInputFilter.Status;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

//import org.hibernate.SessionFactory;


@Path("/EB")
public class MyResource {


	@GET
	@Produces("text/plain")
	public String getIt() {
		return "Hi there!";
	}

	@GET
	@Path("/chec")
	@Produces("text/plain")
	public String getItcheck() {
		return "Hi Ganesh!";
	}
	
//	@GET
//	@Path("/item")
//	@Produces("application/json")
//	public Response getitem() 
//	{
//		String s="himarket";
//		return Response.ok().entity(s).build();
//
//	}
}
