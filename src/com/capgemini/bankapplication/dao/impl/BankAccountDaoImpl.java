package com.capgemini.bankapplication.dao.impl;


import com.capgemini.bankapplication.dao.BankAccountDao;
import com.capgemini.bankapplication.dummy.DataBase;
import com.capgemini.bankapplication.model.BankAccount;

public class BankAccountDaoImpl implements BankAccountDao {
	

	public BankAccountDaoImpl() {
		
	}

	@Override
	public double getBalance(long accountId) {
		// TODO Auto-generated method stub
		for (BankAccount bankAccount : DataBase.bankData) {
			if(bankAccount.getAccountId()==accountId)
			{
				return bankAccount.getBalance();
			}
		}
		return -1;
	}

	@Override
	public boolean updateBalance(long accountId, double amount) {
		// TODO Auto-generated method stub
		for (BankAccount bankAccount : DataBase.bankData) {
			if(bankAccount.getAccountId()==accountId)
			{
				if(bankAccount.getBalance()+amount>=0) {
				bankAccount.setBalance(bankAccount.getBalance()+amount);
				System.out.println(bankAccount.getBalance());
				return true;
				}
			}
		}
		return false;
	}
}