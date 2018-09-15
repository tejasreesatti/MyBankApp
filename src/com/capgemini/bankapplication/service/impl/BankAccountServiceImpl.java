package com.capgemini.bankapplication.service.impl;

import com.capgemini.bankapplication.dao.BankAccountDao;
import com.capgemini.bankapplication.dao.impl.BankAccountDaoImpl;
import com.capgemini.bankapplication.service.BankAccountService;

public class BankAccountServiceImpl implements BankAccountService {

	private BankAccountDao bankAccountDao;
	public BankAccountServiceImpl() {
		bankAccountDao=new BankAccountDaoImpl();
	}

	@Override
	public double getBalance(long accountId) {
		return bankAccountDao.getBalance(accountId);
	}

	@Override
	public boolean withdraw(long accountId, double amount) {
		System.out.println("BankAccountServiceImpl");
		if(bankAccountDao.updateBalance(accountId, bankAccountDao.getBalance(accountId)-amount)) {
			System.out.println("BankAccountServiceImplIf");
			return true;}
		return false;
	}

	@Override
	public boolean deposit(long accountId, double amount) {
		System.out.println("BankAccountServiceImpl");
		if(bankAccountDao.updateBalance(accountId, amount)) {
			System.out.println("BankAccountServiceImpdepositlIf");
			return true;}
		return false;
	}

	@Override
	public boolean fundTransfer(long fromAcc, long toAcc, double amount){
		if(bankAccountDao.getBalance(toAcc)<0)
		{
			return false;
		}
		
		else if(bankAccountDao.updateBalance(fromAcc, -1*amount))
		{
			if(bankAccountDao.updateBalance(toAcc, amount))
			{
				return true;
			}
		}
		return false;
		
		
	}

}