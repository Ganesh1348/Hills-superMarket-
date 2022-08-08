package com.electric.ElectricBilling.Command;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class customerCommand 
{
	private List<createCustomerCommand> createCustomerCommand;
	
	
	public List<createCustomerCommand> getCreateCustomerCommand() {
		return createCustomerCommand;
	}
	public void setCreateCustomerCommand(List<createCustomerCommand> createCustomerCommand) {
		this.createCustomerCommand = createCustomerCommand;
	}	
	
}
