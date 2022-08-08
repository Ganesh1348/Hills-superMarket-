package com.electric.ElectricBilling.Services;

import java.util.List;

import com.electric.ElectricBilling.Command.createCustomerCommand;
import com.electric.ElectricBilling.Command.customerCommand;
import com.electric.ElectricBilling.Model.CustomerList;
import com.electric.ElectricBilling.Model.CustomerListWtCount;
import com.electric.ElectricBilling.dao.customerDao;

public class serviceImplementation

{
	customerDao customerDao=new customerDao();
	CustomerInfServices CustomerInfServices=new interfaceImplementation();
	
	public String checkCustomer(customerCommand cmd) throws Exception 
	{

		
		for(createCustomerCommand createCustomerCommand:cmd.getCreateCustomerCommand()) {
			customerDao.executeCreateDao(createCustomerCommand);
			
		}
		
		return "true";
	
	}

	public List<CustomerList> getListOfCustomer() throws Exception {
		
		return customerDao.executeCustomerList();
	}

}
