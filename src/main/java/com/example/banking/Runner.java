package com.example.banking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;



public class Runner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner=new Scanner(System.in);
		System.out.println("********************* Welcome to enable banking *********************");
		System.out.println("------ This is the list of available banks ------");
		
		//display list of available banks
		LinkedHashSet<String> banks=ApiController.banksList();
        Iterator itr = banks.iterator();     
        while (itr.hasNext()){
    		System.out.print(itr.next());
        }
        
		//user inputs bank id or name
		System.out.println("------ Enter a bank name ------ \n");
		String chosenBank=scanner.nextLine();
		
		System.out.println("Open your authentication link in a browser: \n");
		String url=ApiController.getAuthLink(chosenBank);
		//display authentication link
		System.out.println(url);
		//waits for authorization code
		System.out.println("Enter the authorization code that was given to you here: ");
		String code=scanner.nextLine();
		//session created
		String session=ApiController.createSession(code);
		if (session== null)
			System.out.println("no accounts");
		else
			System.out.println("Session created");
		String transactions=ApiController.getTransactions(session);
		System.out.println(transactions);
	}
	
}

