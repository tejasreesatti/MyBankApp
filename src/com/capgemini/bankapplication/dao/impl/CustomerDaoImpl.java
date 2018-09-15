package com.capgemini.bankapplication.dao.impl;

import java.util.HashSet;

import com.capgemini.bankapplication.dao.CustomerDao;
import com.capgemini.bankapplication.dummy.DataBase;
import com.capgemini.bankapplication.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	private HashSet<Customer> customerData;
	public CustomerDaoImpl() {
		// TODO Auto-generated constructor stub
	

	}

	@Override
	public Customer authenticate(Customer customer) {
		// TODO Auto-generated method stub
		for (Customer customer2 : DataBase.customerData) {
			if(customer2.getCustomerId()==customer.getCustomerId())
			{
				if(customer2.getPassword().equals(customer.getPassword()))
				{
					return customer2;
				}
			}
		}
		return null;
	}

	@Override
	public Customer updateProfile(Customer customer) {
		// TODO Auto-generated method stub
		for (Customer customer2 : DataBase.customerData) {
			if(customer2.getCustomerId()==customer.getCustomerId())
			{
				customer2.setAddress(customer.getAddress());
				System.out.println(customer.getAddress());
				customer2.setEmail(customer.getEmail());
				return customer2;
			}
		}
		return null;
	}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		for (Customer customer2 : DataBase.customerData) {
			if(customer2.getCustomerId()==customer.getCustomerId())
			{
				if(customer2.getPassword().equals(oldPassword))
				{
					customer2.setPassword(newPassword);
					return true;
				}
			}
		}
		return false;
	}

}