package com.capgemini.bankapplication.dummy;


import java.util.HashSet;
import com.capgemini.bankapplication.model.BankAccount;
import com.capgemini.bankapplication.model.Customer;
import java.time.LocalDate;

public class DataBase {

	public DataBase() {
		// TODO Auto-generated constructor stub
		
	}
	public static HashSet<BankAccount> bankData = new HashSet<>();
	public static HashSet<Customer> customerData = new HashSet<>();

	static
	{
		BankAccount b1 = new BankAccount(2024, 100, "SAVINGS");
		BankAccount b2 = new BankAccount(2025, 100, "CURRENT");
		BankAccount b3 = new BankAccount(2026, 100, "SAVINGS");
		BankAccount b4 = new BankAccount(2023, 100, "CURRENT");
		
	
		bankData.add(b1);
		bankData.add(b2);
		bankData.add(b3);
		bankData.add(b4);
		
		customerData.add(new Customer("saimadhuri", 1111, "madhu123", "madhuri@gmail.com", "karimnagar", LocalDate.parse("1996-11-08"),b1));
		customerData.add(new Customer("K Reshetha", 1112, "reshe123", "reshetha@gmail.com", "hyderabad", LocalDate.parse("1996-07-23"),b2));
		customerData.add(new Customer("Nikhil Rayapati", 1113, "nikhil123", "nikhil@gmail.com", "mumbai", LocalDate.parse("1997-08-22"),b3));
		customerData.add(new Customer("Tejasree", 1114, "teja123", "teja@gmail.com", "WestGodavari", LocalDate.parse("1996-07-24"),b4));
		
	}
	
}