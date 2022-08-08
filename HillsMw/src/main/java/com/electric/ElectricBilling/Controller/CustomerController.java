package com.electric.ElectricBilling.Controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.electric.ElectricBilling.Command.customerCommand;
import com.electric.ElectricBilling.Model.CustomerList;
import com.electric.ElectricBilling.Model.CustomerListWtCount;
import com.electric.ElectricBilling.Services.serviceImplementation;

@Path("/customer")
public class CustomerController 
{
	serviceImplementation serviceImplementation=new serviceImplementation();
	@POST
	@Path("/create")
	@Produces("text/plain")
	public Response createItemDetails(customerCommand cmd) 
	{
		String result = null;		
		try {
			
			result=serviceImplementation.checkCustomer(cmd);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return Response.ok().entity(result).build();
	}

	@Path("/list")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CustomerList> getCustomerList(@QueryParam("offset") int offset) {
		List<CustomerList> list = null;
		try
		{
			list=serviceImplementation.getListOfCustomer();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
