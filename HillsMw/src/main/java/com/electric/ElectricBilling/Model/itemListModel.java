package com.electric.ElectricBilling.Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class itemListModel 
{
	private int itemNo;
	private String itemDescr;
	private int itemQty;
	private String createdUser;
	private String LastUpdatedUser;
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getItemDescr() {
		return itemDescr;
	}
	public void setItemDescr(String itemDescr) {
		this.itemDescr = itemDescr;
	}
	public int getItemQty() {
		return itemQty;
	}
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getLastUpdatedUser() {
		return LastUpdatedUser;
	}
	public void setLastUpdatedUser(String lastUpdatedUser) {
		LastUpdatedUser = lastUpdatedUser;
	}
	@Override
	public String toString() {
		return "itemListModel [itemNo=" + itemNo + ", itemDescr=" + itemDescr + ", itemQty=" + itemQty
				+ ", createdUser=" + createdUser + ", LastUpdatedUser=" + LastUpdatedUser + "]";
	}
	
	
	
}
