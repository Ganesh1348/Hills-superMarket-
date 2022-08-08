package com.electric.ElectricBilling.Command;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class createItemCommand 
{
 
	private String descr;
	private String userId;
	private int itemQty;
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getItemQty() {
		return itemQty;
	}
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}
	@Override
	public String toString() {
		return "createItemCommand [descr=" + descr + ", userId=" + userId + ", itemQty=" + itemQty + "]";
	}
	
	
}
