package com.bank.service.model.entity;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "bank_customer")
@Builder
public class BankCustomer {
	private String accNo;
	private String custName;
	private String place;
	
	public BankCustomer(String accNo, String custName, String place) {
		this.accNo = accNo;
		this.custName = custName;
		this.place = place;
	}

	public BankCustomer() {
		
	}
	
	@Id
	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	
	@Column(name = "cust_name", nullable = false)
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	@Column(name = "place", nullable = false)
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
}
