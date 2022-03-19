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

		boolean dontKeepAppRunning = displayMenu(sc);

		if (!dontKeepAppRunning) {

			// User Story #1
			// The user is prompted asking for the price of the item.
			System.out.println("Please enter the price of the item: ");
			int price = convertForRoundingError(sc.nextDouble());

			// User Story #2
			// The user is then prompted asking how much money was tendered by the customer.
			// along with how much they need and if exact change then done
			System.out.println("Amount given: ");
			int amountTendered = convertForRoundingError(sc.nextDouble());
			int changeGivenBack = (amountTendered - price);
			int changeGivenBackCopy = changeGivenBack;

			if (amountTendered < price) {
				System.out.println("NOT SUFFICIENT AMOUNT: ");
			} else if (amountTendered == price) {
				System.out.println("Exact amount. Thank you for your purchase!");
			} else {
				while (changeGivenBack != 0) {
					if (changeGivenBack >= 2000) {
						dollar20++;
						changeGivenBack -= 2000;
					} else if (changeGivenBack >= 1000) {
						dollar10++;
						changeGivenBack -= 1000;
					} else if (changeGivenBack >= 500) {
						dollar5++;
						changeGivenBack -= 500;
					} else if (changeGivenBack >= 100) {
						dollar++;
						changeGivenBack -= 100;
					} else if (changeGivenBack >= 25) {
						cent25++;
						changeGivenBack -= 25;
					} else if (changeGivenBack >= 10) {
						cent10++;
						changeGivenBack -= 10;
					} else if (changeGivenBack >= 5) {
						cent5++;
						changeGivenBack -= 5;
					} else if (changeGivenBack >= 1) {
						cent++;
						changeGivenBack -= 1;
					}
				}
				System.out.println(changeGivenBackCopy + " pennies " + cent + " nickles " + cent5 + " dimes " + cent10
						+ " quarters " + cent25 + " dollars " + dollar + " fives " + dollar5 + " tens " + dollar10
						+ " twenties " + dollar20);
			}
		}

	}

	public static int convertForRoundingError(double cash) {
		int wholeDollars = (int) cash;
		double change = (cash - wholeDollars);
		int roundedChange = ((int) ((change * 100) + 0.5)) + wholeDollars * 100;
		return roundedChange;

	}

	public static boolean displayMenu(Scanner sc) {
		System.out.println("---------------");
		System.out.println("|    Menu     |");
		System.out.println("| 1: Sale     |");
		System.out.println("| 2: Logout   |");
		System.out.println("---------------");

		boolean keepDisplaying = true;
		while (keepDisplaying) {
			int selection = sc.nextInt();
			switch (selection) {
			case 1:
				System.out.println("Hello, Please begin sale!");
				return false;
			case 2:
				System.out.println("Shutting down system, goodbye!");
				return true;
			default:
				System.out.println("Please enter a valid option. Select 1 or 2");
				break;
			}
		}
		return true;

	}

	public static void displayChangeGivenBack() {

	}

}
