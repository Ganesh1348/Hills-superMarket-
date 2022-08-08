package com.electric.ElectricBilling.Model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomerListWtCount {
	
	private List<CustomerList> CustomerList;
	private Integer count;
	public List<CustomerList> getCustomerList() {
		return CustomerList;
	}
	public void setCustomerList(List<CustomerList> customerList) {
		CustomerList = customerList;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "CustomerListWtCount [CustomerList=" + CustomerList + ", count=" + count + "]";
	}
	
	

}
