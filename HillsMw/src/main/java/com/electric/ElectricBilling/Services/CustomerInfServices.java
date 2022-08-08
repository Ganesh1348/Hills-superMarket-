package com.electric.ElectricBilling.Services;

import java.util.List;

import com.electric.ElectricBilling.Command.createCustomerCommand;
import com.electric.ElectricBilling.Model.CustomerList;
import com.electric.ElectricBilling.Model.CustomerListModel;

public interface CustomerInfServices 
{
	public String checkCustomer(createCustomerCommand createCustomerCommand) throws Exception;
	
	public List<CustomerList> executeCustStatus(List<CustomerListModel> list);
}
