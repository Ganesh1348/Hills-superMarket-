package com.electric.ElectricBilling.Services;

import java.util.LinkedList;
import java.util.List;

import com.electric.ElectricBilling.Command.createCustomerCommand;
import com.electric.ElectricBilling.Model.CustomerList;
import com.electric.ElectricBilling.Model.CustomerListModel;
public class interfaceImplementation implements  CustomerInfServices
{

	@Override
	public String checkCustomer(createCustomerCommand cmd) throws Exception {
		if(cmd.getPinCode().substring(0, 3)=="632") 
		{
			throw new Exception("Please select the valid Pincode and city");
		}
		return "true";
	}

	@Override
	public List<CustomerList> executeCustStatus(List<CustomerListModel> list) {
		List<CustomerList> customerList=new LinkedList<CustomerList>();
		for(CustomerListModel custList:list) 
		{
			CustomerList custDel=new CustomerList();
			if(custList.getStatus().toUpperCase().equalsIgnoreCase("ACTIVE")) 
			{
				custDel.setCustNo(custList.getCustNo());
				custDel.setCustName(custList.getCustName());
				custDel.setCity(custList.getCity());
				custDel.setPincode(custList.getPincode());
				custDel.setStatus(custList.getStatus());
				customerList.add(custDel);
			}
		}
		return customerList;
	}

}
