package com.bank.service.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.service.config.ApplicationConstants;
import com.bank.service.exception.ResourceNotFoundException;
import com.bank.service.model.entity.BankCustomer;
import com.bank.service.repository.BankServiceRepository;

@Service
public class GetBankServiceImpl implements GetBankService {

	private static final Logger logger = LoggerFactory.getLogger(GetBankServiceImpl.class);

	@Autowired
	BankServiceRepository bankServiceRepository;

	@Override
	public BankCustomer getBankCustomerByAccNo(String accNo) {
		// TODO Auto-generated method stub
		logger.info("GetBankServiceImpl.getBankCustomerByAccNo() method called");
		BankCustomer customer = bankServiceRepository.getBankCustomerByAccNo(accNo);
		if (customer == null) {
			throw new ResourceNotFoundException(ApplicationConstants.BANK_CUSTOMER_NOT_FOUND + accNo);
		}
		return customer;
	}

	@Override
	public List<BankCustomer> getAllBankCustomer() {
		// TODO Auto-generated method stub
		logger.info("GetBankServiceImpl.getAllBankCustomer() method called");
		return bankServiceRepository.findAll();
	}

}
