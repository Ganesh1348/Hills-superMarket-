package com.electric.ElectricBilling.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.electric.ElectricBilling.DBconnection;
import com.electric.ElectricBilling.inject;
import com.electric.ElectricBilling.Command.createItemCommand;
import com.electric.ElectricBilling.Model.itemListModel;
import com.electric.ElectricBilling.SQLQueries.SQLQueriesConstant;

public class itemDao 
{
	@inject
	DBconnection _connections;
	
	DBconnection DBconnection=new DBconnection();
	SQLQueriesConstant SQLQueriesConstant=new SQLQueriesConstant();
	
	public String executeCreateItem(createItemCommand cmd, int itemQty) throws SQLException 
	{
		int countInserted;
		System.out.println(cmd);
		Connection con=DBconnection.getConnection();
		PreparedStatement ps = con
				.prepareStatement(SQLQueriesConstant.CREATEITEMCONSTANT);
	ps.setString(1, cmd.getDescr());
	ps.setString(2, cmd.getUserId());
	ps.setString(3, cmd.getUserId());
	ps.setInt(4, itemQty);

	countInserted=ps.executeUpdate();
	
	System.out.println(countInserted);
	
	String result=countInserted>=1?"true":"false";

	return result;
	}

	public List<itemListModel> executeItemList(int itemNo) throws Exception 
	{
		String query;			
		List<itemListModel> list=new ArrayList<itemListModel>();
		Connection con=DBconnection.getConnection();
		if(itemNo==0)
		{
			query=SQLQueriesConstant.ITEMLIST;			
		}
		else 
		{
			query=String.format(SQLQueriesConstant.ITEMLISTPARAM, itemNo);
		}	
		PreparedStatement ps=con.prepareStatement(query);
		System.out.println(ps);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) 
		{
			itemListModel item=new itemListModel();
			item.setItemNo(rs.getInt(1));
			item.setItemDescr(rs.getString(2));
			item.setItemQty(rs.getInt(3));
			item.setCreatedUser(rs.getString(4));
			item.setLastUpdatedUser(rs.getString(5));
			System.out.println(item);
			list.add(item);
		}
		
		return list;
	}

	public String executeItemQty(int itemQty, int itemNo, String userId) throws SQLException
	{
		int result=0;
		Connection con=DBconnection.getConnection();
		PreparedStatement ps=con.prepareStatement(SQLQueriesConstant.UPDATEITEMQTY);
		System.out.println(ps);
		ps.setInt(1, itemQty);
		ps.setString(2, userId);
		ps.setInt(3, itemNo);
		result=ps.executeUpdate();
		String res=result>=1?"true":"false";
		return res;
	}

	public String executeSellableQty(Integer itemNo, Integer qty) throws Exception 
	{
		int result=0;
		System.out.println(itemNo + " " + qty);
		Connection con=DBconnection.getConnection();
		PreparedStatement ps=con.prepareStatement(SQLQueriesConstant.UPDATESELLABLEQTY);
		System.out.println(ps);
		ps.setInt(1, qty);
		ps.setInt(2, itemNo);
		result=ps.executeUpdate();
		int onHandResult=persistSellable(itemNo,qty);
		String res=result>=1 && onHandResult>=1?"true":"false";
		return res;
	}
	
	public int persistSellable(Integer itemNo, Integer qty) throws Exception {
		int result=0;
		System.out.println(itemNo + " " + qty);
		Connection con=DBconnection.getConnection();
		PreparedStatement ps=con.prepareStatement(SQLQueriesConstant.UPDATESELLABLEANDONHANDQTY);
		System.out.println(ps);
		ps.setInt(1, qty);
		ps.setInt(2, itemNo);
		result=ps.executeUpdate();
		return result;
	}

}
