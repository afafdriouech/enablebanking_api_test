package com.example.banking;

import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;



public class Runner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("hello cmd line runner");
		Scanner scanner=new Scanner(System.in);
		String s=scanner.nextLine();
		System.out.println(s);
		System.out.println(ApiController.connect());
		
		
		//display list of available banks
		//user inputs bank id or name
		//display authentication link
		//waits for authorization code
		//
	}
	
}

