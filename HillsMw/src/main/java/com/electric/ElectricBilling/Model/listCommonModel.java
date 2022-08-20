package com.electric.ElectricBilling.Model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({CustomerList.class})
public class listCommonModel 
{
	private List<?> list;
	private Long count;
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "listCommonModel [list=" + list + ", count=" + count + "]";
	}
	
	
	
}
