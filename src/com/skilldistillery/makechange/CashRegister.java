package com.skilldistillery.makechange;

import java.util.Scanner;

public class CashRegister {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// listed variables
		int cent = 0;
		int cent5 = 0;
		int cent10 = 0;
		int cent25 = 0;
		int dollar = 0;
		int dollar5 = 0;
		int dollar10 = 0;
		int dollar20 = 0;
		double price;
		double amountTendered;
		int changeGivenBack = amountTendered - price;
		Scanner input;

		// User Story #1
		// The user is prompted asking for the price of the item.
		System.out.println("Please enter the price of the item: ");
		price = sc.nextInt();
		double result = price;

		// User Story #2
		// The user is then prompted asking how much money was tendered by the customer. along with how much they need and if exact change then done
		System.out.println("Amount given: ");
		amountTendered = sc.nextInt();
		double tendered = amountTendered;

		if (amountTendered < price) {
			System.out.println("NOT SUFFICIENT AMOUNT: ");
		}	else if (amountTendered == price) {
			System.out.println("Exact amount. Thank you for your purchase!");
		}	else {
			System.out.println("Your change is: ");
		}
		

	}

}
