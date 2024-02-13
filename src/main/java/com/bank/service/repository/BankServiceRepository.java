package com.bank.service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.service.model.entity.BankCustomer;


public interface BankServiceRepository {
	@Query(value = "select * from bank_account.bank_customer", nativeQuery = true)
	public List<BankCustomer> findAll();

	public BankCustomer getBankCustomerByAccNo(String accNo);
	
	public int createBankCustomer(BankCustomer bankCustomer);
	public int updateBankCustomerByAccNo(BankCustomer bankCustomer);

	public int deleteBankCustomerByAccNo(String accNo);

}
