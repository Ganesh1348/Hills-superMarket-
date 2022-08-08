package com.electric.ElectricBilling.Controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.electric.ElectricBilling.inject;

import com.electric.ElectricBilling.Command.createItemCommand;
import com.electric.ElectricBilling.Model.itemListModel;
import com.electric.ElectricBilling.Services.itemServices;



@Path("/item")
public class itemController 
{
	@inject
	itemServices _itemServices;
	
	itemServices itemServices=new itemServices();
	
	@POST
	@Path("/create/items")
	@Produces("text/plain")
	public Response createItemDetails(createItemCommand cmd) 
	{
		String result = null;		
		try {
			System.out.println(cmd);
			result=itemServices.getCreateItem(cmd);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return Response.ok().entity(result).build();
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<itemListModel> getItemList(@QueryParam("itemNo") int  itemNo) 
	{
		List<itemListModel> list = null;
		try 
		{
			list=itemServices.getItemListServices(itemNo);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	@PUT
	@Path("/update/qty/{itemNo}/{qty}/{userId}")
	@Produces("text/plain")
	public String updateItemQty(@PathParam("itemNo") Integer itemNo,@PathParam("qty") Integer qty
			,@PathParam("userId") String userId)
	{
		String result=null;
		try 
		{
			result=itemServices.updateItemQtyServices(qty,itemNo,userId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@PUT
	@Path("/sellable/{itemNo}/{qty}")
	@Produces("text/plain")
	public String updateSellableQty(@PathParam("itemNo") Integer itemNo,@PathParam("qty") Integer qty
	){
		String result=null;
		try 
		{
			result=itemServices.updateSellable(itemNo,qty);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}
