package com.bank.service.config;

public class ApplicationConstants {
	//Exception messages
	public static final String BANK_CUSTOMER_NOT_FOUND = "Bank customer not found for this accNo :: ";
	public static final String NEW_CUSTOMER_CREATED = " New Bank customer created for account no :: ";
	public static final String BANK_CUSTOMER_ALREDY_EXISTS = "Bank Customer alredy exists for this accNo :: ";
	// Success Response
	public static final String CREATED_RESPONSE = "Bank Customer Created for Account Number :: ";
	public static final String UPDATED_RESPONSE = "Bank Customer Updated for Account Number :: ";
	public static final String DELETED_RESPONSE = "Bank Customer details deleted for account Number :: ";

	// Failed Response
	public static final String FAILED_CUSTOMER_CREATION = "Bank Customer Creation failed";
	public static final String FAILED_CUSTOMER_UPDATE = "Bank Customer Update failed for accNo :: ";
	public static final String FAILED_CUSTOMER_DELETE = "Bank Customer Delete failed for accNo :: ";
	
	//MYSQL Queries
	public static final String DELETE_QUERY = "delete from bank_customer where acc_no = ?";
	public static final String UPDATE_QUERY = "update bank_customer set cust_name = ?,place = ? where acc_no = ?";
	public static final String INSERT_QUERY = "insert into bank_customer (acc_no,cust_name,place) value(?,?,?)";
	public static final String GET_ALL_CUSTOMER_QUERY = "SELECT acc_no, cust_name, place FROM bank_customer";
	public static final String GET_CUSTOMER_BY_ACCNO_QUERY = "SELECT acc_no, cust_name, place FROM bank_customer WHERE acc_no = ?";

}
