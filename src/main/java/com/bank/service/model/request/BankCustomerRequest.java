package com.bank.service.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BankCustomerRequest {

	@NotBlank(message = "account number is mandatory")
	@Size(min = 4, max = 5, message = "Account number should be between 3 and 5 characters")
	private String accNo;

	@NotBlank(message = "Customer Name is mandatory")
	private String custName;

	@NotBlank(message = "Place name is mandatory")
	private String place;

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
