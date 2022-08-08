package com.electric.ElectricBilling.Services;


import java.sql.SQLException;
import java.util.List;

import com.electric.ElectricBilling.inject;
import com.electric.ElectricBilling.Command.createItemCommand;
import com.electric.ElectricBilling.Model.itemListModel;
import com.electric.ElectricBilling.dao.itemDao;

public class itemServices {
	
	@inject
	itemDao _itemdao;
	
	itemDao itemDao=new itemDao();

	public String getCreateItem(createItemCommand cmd) throws Exception {
		System.out.println(cmd);
		int itemQty=cmd.getItemQty()<1?1:cmd.getItemQty();		
		
		return itemDao.executeCreateItem(cmd,itemQty);
		
	}

	public List<itemListModel> getItemListServices(int itemNo) throws Exception 
	{
		return itemDao.executeItemList(itemNo);
	}

	public String updateItemQtyServices(int qty, int itemNo, String userId) throws Exception 
	{
		int itemQty=qty<1?1:qty;
		
		return itemDao.executeItemQty(itemQty,itemNo,userId);
	}

	public String updateSellable(Integer itemNo, Integer qty) throws Exception {
		
		return itemDao.executeSellableQty(itemNo,qty);
	}

}
