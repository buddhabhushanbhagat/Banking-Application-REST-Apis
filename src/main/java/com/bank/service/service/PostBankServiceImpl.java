package com.bank.service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.service.config.ApplicationConstants;
import com.bank.service.exception.BankCustomerAlredyExistsException;
import com.bank.service.exception.CustomerCreationFailedException;
import com.bank.service.exception.CustomerDeletionFailedException;
import com.bank.service.exception.CustomerUpdateOperationFailedException;
import com.bank.service.exception.ResourceNotFoundException;
import com.bank.service.mapper.BankServiceMapper;
import com.bank.service.model.entity.BankCustomer;
import com.bank.service.model.request.BankCustomerRequest;
import com.bank.service.repository.BankServiceRepository;

@Service
public class PostBankServiceImpl implements PostBankService {
	private static final Logger logger = LoggerFactory.getLogger(PostBankServiceImpl.class);
	@Autowired
	BankServiceRepository bankServiceRepository;

	@Autowired
	BankServiceMapper bankServiceMapper;

	@Override
	public int createBankCustomer(BankCustomerRequest bankCustomerRequest)
			throws CustomerCreationFailedException, BankCustomerAlredyExistsException {
		// TODO Auto-generated method stub
		logger.info("PostBankServiceImpl.createBankCustomer() method called");
		BankCustomer bankCustomer = bankServiceMapper.mapRequestWithBankCustomer(bankCustomerRequest);
		BankCustomer bankCustomer2 = bankServiceRepository.getBankCustomerByAccNo(bankCustomer.getAccNo());
		if (bankCustomer2 != null)
			throw new BankCustomerAlredyExistsException(
					ApplicationConstants.BANK_CUSTOMER_ALREDY_EXISTS + bankCustomer.getAccNo());
		int createdBankCustomer = bankServiceRepository.createBankCustomer(bankCustomer);
		if (createdBankCustomer == 0)
			throw new CustomerCreationFailedException(ApplicationConstants.FAILED_CUSTOMER_CREATION);
		return createdBankCustomer;

	}

	@Override
	public int updateBankCustomerByAccNo(BankCustomerRequest bankCustomerRequest, String accNo)
			throws ResourceNotFoundException, CustomerUpdateOperationFailedException {
		// TODO Auto-generated method stub
		logger.info("PostBankServiceImpl.updateBankCustomerByAccNo() method called");
		BankCustomer bankCustomer = bankServiceRepository.getBankCustomerByAccNo(accNo);
		if (bankCustomer == null)
			throw new ResourceNotFoundException(ApplicationConstants.BANK_CUSTOMER_NOT_FOUND + accNo);
		bankCustomer.setCustName(bankCustomerRequest.getCustName());
		bankCustomer.setPlace(bankCustomerRequest.getPlace());
		int updatedBankCustomer = bankServiceRepository.updateBankCustomerByAccNo(bankCustomer);
		if (updatedBankCustomer == 0)
			throw new CustomerUpdateOperationFailedException(ApplicationConstants.FAILED_CUSTOMER_UPDATE);
		return updatedBankCustomer;
	}

	@Override
	public int deleteBankCustomerByAccNo(String accNo)
			throws CustomerDeletionFailedException, ResourceNotFoundException {
		// TODO Auto-generated method stub
		logger.info("PostBankServiceImpl.deleteBankCustomerByAccNo() method called");
		BankCustomer bankCustomer = bankServiceRepository.getBankCustomerByAccNo(accNo);
		if (bankCustomer == null)
			throw new ResourceNotFoundException(ApplicationConstants.BANK_CUSTOMER_NOT_FOUND + accNo);
		int deletedBankCustomer = bankServiceRepository.deleteBankCustomerByAccNo(accNo);
		if (deletedBankCustomer == 0)
			throw new CustomerDeletionFailedException(ApplicationConstants.FAILED_CUSTOMER_DELETE + accNo);
		return deletedBankCustomer;
	}

}
