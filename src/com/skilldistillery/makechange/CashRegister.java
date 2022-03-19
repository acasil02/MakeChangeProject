package com.skilldistillery.makechange;

import java.util.Scanner;

public class CashRegister {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		double price;
		double amountTendered;
		Scanner input;
		
		// User Story #1
		// The user is prompted asking for the price of the item.
		System.out.println("Please enter the price of the item: ");
			price = sc.nextInt();
			double result = price;

		// User Story #2
		// The user is then prompted asking how much money was tendered by the customer.
			System.out.println("Tendered amount given: ");
			amountTendered = sc.nextInt();
			double tendered = amountTendered;

		// User Story #3
		// Display an appropriate message if the customer provided too little money or
		// the exact amount.
			if (amountTendered < price)
				System.out.println("NOT SUFFICIENT AMOUNT: ");
			
			
			
		// User Story #4
		// If the amount tendered is more than the cost of the item, display the number
		// of bills and coins that should be given to the customer.
			if (amountTendered > price)
				System.out.println("test");

	}

}
