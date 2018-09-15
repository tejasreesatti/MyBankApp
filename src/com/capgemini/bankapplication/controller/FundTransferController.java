package com.capgemini.bankapplication.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.capgemini.bankapplication.model.Customer;
import com.capgemini.bankapplication.service.BankAccountService;
import com.capgemini.bankapplication.service.impl.BankAccountServiceImpl;


@WebServlet("/fundTransfer")
public class FundTransferController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletContext context; 
    private BankAccountService bankAccountService;
    
    
    public FundTransferController() {
    	bankAccountService = new BankAccountServiceImpl();
    }

	
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	//bankAccountService = new BankAccountServiceImpl();
    	context = config.getServletContext();
    	
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		long payeeAccountNumber = Long.parseLong(request.getParameter("payeeAccountNumber"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		Customer custTemp;
		
		HttpSession session = request.getSession();
		custTemp = (Customer) session.getAttribute("customer");
		
		System.out.println(payeeAccountNumber);
		
		RequestDispatcher dispatcher;
		if(bankAccountService.fundTransfer(custTemp.getBankAccount().getAccountId(), payeeAccountNumber, amount))
		{
		
			dispatcher = request.getRequestDispatcher("transferSuccess.jsp");
System.out.println("hello");
		}
		else
		{
			dispatcher = request.getRequestDispatcher("transferFail.jsp");
		}
		
		dispatcher.include(request, response);
	}



}