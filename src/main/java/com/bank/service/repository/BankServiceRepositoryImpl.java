package com.bank.service.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bank.service.config.ApplicationConstants;
import com.bank.service.model.entity.BankCustomer;

@Repository
public class BankServiceRepositoryImpl implements BankServiceRepository {
	private static final Logger logger = LoggerFactory.getLogger(BankServiceRepositoryImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public BankCustomer getBankCustomerByAccNo(String accNo) throws DataAccessException {
		// TODO Auto-generated method stub
		logger.info("BankServiceRepositoryImpl.getBankCustomerByAccNo() method called");
		BankCustomer bankCustomer = null;
		String query = ApplicationConstants.GET_CUSTOMER_BY_ACCNO_QUERY;

		RowMapper<BankCustomer> mapper = (rs, rowNum) -> {
			BankCustomer row = new BankCustomer();
			row.setAccNo(rs.getString("acc_no"));
			row.setCustName(rs.getString("cust_name"));
			row.setPlace(rs.getString("place"));
			return row;
		};

		try {
			bankCustomer = jdbcTemplate.queryForObject(query, mapper, accNo);
		} catch (EmptyResultDataAccessException e) {
			return bankCustomer;
		}
		logger.info("BankCustomer details: " + bankCustomer);

		return bankCustomer;
	}

	@Override
	public List<BankCustomer> findAll() {
		// TODO Auto-generated method stub
		logger.info("BankServiceRepositoryImpl.findAll() method called");
		String query = ApplicationConstants.GET_ALL_CUSTOMER_QUERY;
		RowMapper<BankCustomer> mapper = (rs, rowNum) -> {
			BankCustomer row = new BankCustomer();
			row.setAccNo(rs.getString("acc_no"));
			row.setCustName(rs.getString("cust_name"));
			row.setPlace(rs.getString("place"));
			return row;
		};
		List<BankCustomer> bankCustomerList = jdbcTemplate.query(query, mapper);

		logger.info("Returning BankCustomers List:" + bankCustomerList);
		return bankCustomerList;
	}

	@Override
	public int createBankCustomer(BankCustomer bankCustomer) {
		// TODO Auto-generated method stub
		logger.info("BankServiceRepositoryImpl.createBankCustomer() method called");
		int result = 0;
		String query = ApplicationConstants.INSERT_QUERY;
		result = jdbcTemplate.update(query, bankCustomer.getAccNo(), bankCustomer.getCustName(),
				bankCustomer.getPlace());
		return result;
	}

	@Override
	public int updateBankCustomerByAccNo(BankCustomer bankCustomer) {
		// TODO Auto-generated method stub
		logger.info("BankServiceRepositoryImpl.updateBankCustomerByAccNo() method called");
		int result = 0;
		String query = ApplicationConstants.UPDATE_QUERY;
		result = jdbcTemplate.update(query, bankCustomer.getCustName(), bankCustomer.getPlace(),
				bankCustomer.getAccNo());
		return result;
	}

	@Override
	public int deleteBankCustomerByAccNo(String accNo) {
		// TODO Auto-generated method stub
		logger.info("BankServiceRepositoryImpl.deleteBankCustomerByAccNo() method called");
		int result = 0;
		String query = ApplicationConstants.DELETE_QUERY;
		result = jdbcTemplate.update(query, accNo);
		return result;
	}

}
