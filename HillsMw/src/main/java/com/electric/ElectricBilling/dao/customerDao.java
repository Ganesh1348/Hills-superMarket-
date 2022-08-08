package com.electric.ElectricBilling.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.electric.ElectricBilling.DBconnection;
import com.electric.ElectricBilling.Command.createCustomerCommand;
import com.electric.ElectricBilling.Model.CustomerList;
import com.electric.ElectricBilling.Model.CustomerListModel;
import com.electric.ElectricBilling.Model.CustomerListWtCount;
import com.electric.ElectricBilling.SQLQueries.SQLQueriesConstant;
import com.electric.ElectricBilling.Services.CustomerInfServices;
import com.electric.ElectricBilling.Services.interfaceImplementation;


public class customerDao 
{
	DBconnection DBconnection=new DBconnection();
	SQLQueriesConstant SQLQueriesConstant=new SQLQueriesConstant();
	
	CustomerInfServices CustomerInfServices=new interfaceImplementation();
	
	public String executeCreateDao(createCustomerCommand createCustomerCommand) throws Exception {
		int countInserted;
		Connection con=DBconnection.getConnection();
		PreparedStatement ps = con
				.prepareStatement(SQLQueriesConstant.CREATECUSTOMERCONSTANT);
	ps.setString(1, createCustomerCommand.getCustomerName().toUpperCase());
	ps.setString(2, createCustomerCommand.getCity().toUpperCase());
	ps.setString(3, createCustomerCommand.getPinCode());

	countInserted=ps.executeUpdate();
	
	String result=countInserted>=1?"true":"false";

	return result;
	}

	public List<CustomerList> executeCustomerList() throws Exception {
		List<CustomerListModel> list=new LinkedList<CustomerListModel>();
		Connection con=DBconnection.getConnection();
		PreparedStatement ps=con.prepareStatement(SQLQueriesConstant.CUSTOMERLIST);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) 
		{
			CustomerListModel cust=new CustomerListModel();
			
			cust.setCustNo(rs.getInt(1));
			cust.setCustName(rs.getString(2));
			cust.setCity(rs.getString(3));
			cust.setPincode(rs.getString(4));
			cust.setStatus(rs.getString(5));
			
			
			list.add(cust);
		}
		List<CustomerList> custList=CustomerInfServices.executeCustStatus(list);
		
		return custList;
	}

}
