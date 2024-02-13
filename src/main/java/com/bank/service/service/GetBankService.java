package com.bank.service.service;

import java.util.List;

import com.bank.service.model.entity.BankCustomer;
import com.bank.service.model.request.BankCustomerRequest;

public interface GetBankService {
	public BankCustomer getBankCustomerByAccNo(String accNo);
	public List<BankCustomer> getAllBankCustomer();
}
