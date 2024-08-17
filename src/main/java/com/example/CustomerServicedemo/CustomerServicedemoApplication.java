package com.example.CustomerServicedemo;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.Customers.CustomerCare;

@SpringBootApplication
public class CustomerServicedemoApplication {
	private static String userProblem;

	public static void main(String[] args) {

		/*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.

			 Tasks:
		 *  1. Load the beans from ApplicationContext.xml
		 *  2. Display all the departments available and get the input from user.
		 *  3. Get the message from user and store it into the respective department.
		 *  
		 */
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
		CustomerCare paymentDepartment = (CustomerCare) context.getBean("paymentDepartment");
		CustomerCare queryDepartment = (CustomerCare) context.getBean("queryDepartment");
		CustomerCare salesDepartment = (CustomerCare) context.getBean("salesDepartment");
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Complaint portal!");
		while(true) {
			System.out.println("Please Enter your name:");
			String name = sc.nextLine();
			System.out.println("Please select a department for which you have complaint: \n1. Payment Department \n2. Query Department \n3. Sales Department \n4. Exit");
			int customerChoice = sc.nextInt();
			switch (customerChoice) {
			case 1: {
				paymentDepartment.setCustomerName(name);
				paymentDepartment.getService();
				System.out.println("Please mention your problem:");
				userProblem();
				paymentDepartment.setProblem(userProblem);
				paymentDepartment.getProblem();
				return;
			}
			case 2 : {
				queryDepartment.setCustomerName(name);
				queryDepartment.getService();
				System.out.println("Please mention your problem:");
				userProblem();
				queryDepartment.setProblem(userProblem);
//				sc.close();
				queryDepartment.getProblem();
				return;
			}
			case 3: {
				salesDepartment.setCustomerName(name);
				salesDepartment.getService();
				System.out.println("Please mention your problem:");
				userProblem();
				salesDepartment.setProblem(userProblem);
				salesDepartment.getProblem();
				return;
			}
			
			case 4: {
				System.out.println("Exiting...");
				return;
			}
			
		}
			
			
		}
	}
	public static void userProblem() {
		Scanner prb = new Scanner(System.in);
		userProblem = prb.nextLine();
	}
}
