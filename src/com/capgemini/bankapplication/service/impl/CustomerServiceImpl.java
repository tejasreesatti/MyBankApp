package com.capgemini.bankapplication.service.impl;

import com.capgemini.bankapplication.dao.CustomerDao;
import com.capgemini.bankapplication.dao.impl.CustomerDaoImpl;
import com.capgemini.bankapplication.model.Customer;
import com.capgemini.bankapplication.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	private CustomerDao customerDao;
	
	
	public CustomerServiceImpl() {
		super();
		this.customerDao = new CustomerDaoImpl();
	}

	@Override
	public Customer authenticate(Customer customer) {
		System.out.println("serv impl");
		return customerDao.authenticate(customer);
	}

	@Override
	public Customer updateProfile(Customer customer) {
		return customerDao.updateProfile(customer);
	}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		return customerDao.updatePassword(customer, oldPassword, newPassword);
	}

}
