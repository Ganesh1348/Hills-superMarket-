package com.electric.ElectricBilling.Command;

public class createCustomerCommand {
	private String City;
	private String customerName;
	private String pinCode;

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	
	
}
