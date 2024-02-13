package com.bank.service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.service.config.ApplicationConstants;
import com.bank.service.exception.BankCustomerAlredyExistsException;
import com.bank.service.exception.CustomerCreationFailedException;
import com.bank.service.exception.ResourceNotFoundException;
import com.bank.service.model.entity.BankCustomer;
import com.bank.service.model.request.BankCustomerRequest;
import com.bank.service.service.GetBankService;
import com.bank.service.service.PostBankService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@RestController
@RequestMapping("/bank")
public class BankServiceController {

	private static final Logger logger = LoggerFactory.getLogger(BankServiceController.class);

	@Autowired
	private GetBankService getBankService;

	@Autowired
	private PostBankService postBankService;

	@GetMapping("/customer")
	public ResponseEntity<List<BankCustomer>> getAllCustomers() {
		logger.info("getBankService.getAllBankCustomer() will be called");
		List<BankCustomer> bankCustomerList = getBankService.getAllBankCustomer();
		return ResponseEntity.ok(bankCustomerList);
	}

	@GetMapping("/customer/{accNo}")
	public ResponseEntity<BankCustomer> getBankCustomerByAccNo(@Size(min = 4,max = 5) @PathVariable(value = "accNo") String accNo)
			throws ResourceNotFoundException {
		logger.info("getBankService.getBankCustomerByAccNo " + accNo + " will be called");
		BankCustomer bankCustomer = getBankService.getBankCustomerByAccNo(accNo);
		return ResponseEntity.ok(bankCustomer);
	}

	@PostMapping("/customer")
	public ResponseEntity<String> createCustomer(@Valid @RequestBody BankCustomerRequest bankCustomerRequest)
			throws CustomerCreationFailedException, BankCustomerAlredyExistsException {
		String response;
		logger.info("postBankService.createBankCustomer will be called");
		int createdBankCustomer = postBankService.createBankCustomer(bankCustomerRequest);
		response = ApplicationConstants.CREATED_RESPONSE + bankCustomerRequest.getAccNo();
		return ResponseEntity.ok(response);
	}

	@PostMapping("/customer/{accNo}")
	public ResponseEntity<String> updateCustomer( @PathVariable(value = "accNo") String accNo,
			@Valid @RequestBody BankCustomerRequest bankCustomerRequest) throws ResourceNotFoundException {
		String response;
		logger.info("postBankService.updateBankCustomerByAccNo " + accNo + " will be called");
		int updatedBankCustomer = postBankService.updateBankCustomerByAccNo(bankCustomerRequest, accNo);
		response = ApplicationConstants.UPDATED_RESPONSE + accNo;
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/customer/{accNo}")
	public ResponseEntity<String> deleteCustomer(@PathVariable(value = "accNo") String accNo)
			throws ResourceNotFoundException {
		String response;
		logger.info("postBankService.deleteBankCustomerByAccNo " + accNo + " will be called");
		int deletedBankCustomer = postBankService.deleteBankCustomerByAccNo(accNo);
		response = ApplicationConstants.DELETED_RESPONSE + accNo;
		return ResponseEntity.ok(response);
	}
}
