package com.bank.service.mapper;

import org.springframework.stereotype.Component;

import com.bank.service.model.entity.BankCustomer;
import com.bank.service.model.request.BankCustomerRequest;

@Component
public class BankServiceMapper {
	public BankCustomer mapRequestWithBankCustomer(BankCustomerRequest bankCustomerRequest) {

		BankCustomer bankCustomer = BankCustomer.builder().accNo(bankCustomerRequest.getAccNo())
				.custName(bankCustomerRequest.getCustName()).place(bankCustomerRequest.getPlace()).build();
		return bankCustomer;
	}
}
