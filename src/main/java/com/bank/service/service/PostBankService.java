package com.bank.service.service;

import java.util.List;

import com.bank.service.model.entity.BankCustomer;
import com.bank.service.model.request.BankCustomerRequest;

public interface PostBankService {
	public int createBankCustomer(BankCustomerRequest bankCustomerRequest);
	public int updateBankCustomerByAccNo(BankCustomerRequest bankCustomerRequest, String accNo);
	public int deleteBankCustomerByAccNo(String accNo);
}
