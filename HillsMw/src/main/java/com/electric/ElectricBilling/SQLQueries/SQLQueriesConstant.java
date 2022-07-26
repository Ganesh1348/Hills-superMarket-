package com.electric.ElectricBilling.SQLQueries;

public class SQLQueriesConstant 
{
	public String CREATEITEMCONSTANT
	="INSERT INTO ITEM_IT01(DESCP,CREATED_USER,LAST_UPDATED_USER,ITEM_QTY)\n"
			+ "VALUES(?,?,?,?);";
	
	public String ITEMLIST="SELECT ITEM_NO,DESCP,ITEM_QTY,CREATED_USER,LAST_UPDATED_USER FROM ITEM_IT01;\n"
			+ "";
	
	public String ITEMLISTPARAM="SELECT ITEM_NO,DESCP,ITEM_QTY,CREATED_USER,LAST_UPDATED_USER FROM ITEM_IT01 WHERE ITEM_NO=%s;\n"
			+ "";
	
	public String UPDATEITEMQTY="UPDATE ITEM_IT01 SET ITEM_QTY=?,LAST_UPDATED_USER=? ,\n"
			+ "LAST_UPDATED_DATE=CURDATE() WHERE ITEM_NO=?";
	
	public String UPDATESELLABLEQTY="UPDATE ITEM_IT02 SET SELLABLE_QTY=SELLABLE_QTY+? WHERE ITEM_NO=?";
	
	public String UPDATESELLABLEANDONHANDQTY="UPDATE ITEM_IT02 SET ON_HAND_QTY=ON_HAND_QTY-? WHERE ITEM_NO=?;\n"
			+ "";
	
	public String CREATECUSTOMERCONSTANT="INSERT INTO CUST_CU01(CUST_NAME,CITY,PINCODE)VALUES(?,?,?);";
	
	public String CUSTOMERLIST="SELECT CUST_NO,CUST_NAME,CITY,PINCODE,CUST_STATUS FROM CUST_CU01;";

}