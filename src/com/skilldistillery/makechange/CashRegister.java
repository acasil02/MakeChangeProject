package com.skilldistillery.makechange;

import java.util.Scanner;

public class CashRegister {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cent = 0;
		int cent5 = 0;
		int cent10 = 0;
		int cent25 = 0;
		int dollar = 0;
		int dollar5 = 0;
		int dollar10 = 0;
		int dollar20 = 0;

		boolean keepAppRunning = menuChoice(sc);

		while (keepAppRunning) {

			System.out.println("Please enter the price of the item: ");
			int price = convertForRoundingError(sc.nextDouble());
			sc.nextLine();
			System.out.println("Amount given: ");
			int amountTendered = convertForRoundingError(sc.nextDouble());
			sc.nextLine();
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
				displayChangeGivenBack(changeGivenBackCopy, cent, cent5, cent10, cent25, dollar, dollar5, dollar10,
						dollar20);
				cent = 0;
				cent5 = 0;
				cent10 = 0;
				cent25 = 0;
				dollar = 0;
				dollar5 = 0;
				dollar10 = 0;
				dollar20 = 0;
			}
			boolean decision = askForAnotherSale(sc);
			keepAppRunning = decision;
		}
	}

	public static void displayMenu() {
		System.out.println("---------------");
		System.out.println("|    Menu     |");
		System.out.println("| 1: Sale     |");
		System.out.println("| 2: Logout   |");
		System.out.println("---------------");
	}

	public static boolean menuChoice(Scanner sc) {
		boolean keepDisplaying = true;
		while (keepDisplaying) {
			displayMenu();
			int selection = sc.nextInt();
			switch (selection) {
			case 1:
				System.out.println("Hello, Please begin sale!");
				keepDisplaying = false;
				return true;
			case 2:
				System.out.println("Shutting down system, goodbye!");
				keepDisplaying = false;
				return false;
			default:
				System.out.println("Please enter a valid option. Select 1 or 2");
				break;
			}
		}
		return true;
	}

	public static int convertForRoundingError(double cash) {
		int wholeDollars = (int) cash;
		double change = (cash - wholeDollars);
		int roundedChange = ((int) ((change * 100) + 0.5)) + wholeDollars * 100;
		return roundedChange;
	}

	public static boolean askForAnotherSale(Scanner sc) {
		boolean keepSelling = true;
		System.out.println("Would you like to make another sale? Yes or No");
		String choice = sc.nextLine();
		if (choice.equals("Yes") || choice.equals("yes") || choice.equals("Y") || choice.equals("y")) {
			keepSelling = true;
		} else if (choice.equals("No") || choice.equals("no") || choice.equals("N") || choice.equals("n")) {
			keepSelling = false;
			System.out.println("shutting down register. Goodbye!");
		}
		return keepSelling;
	}

	public static void displayChangeGivenBack(int changeGivenBackCopy, int cent, int cent5, int cent10, int cent25,
			int dollar, int dollar5, int dollar10, int dollar20) {
		System.out.println("Your change is: ");
		while (changeGivenBackCopy > 0) {
			if (dollar20 > 1) {
				System.out.println(dollar20 + " twenty dollar bills");
				changeGivenBackCopy -= (2000 * dollar20);
				dollar20 = 0;
			} else if (dollar20 == 1) {
				System.out.println(dollar20 + " twenty dollar bill");
				changeGivenBackCopy -= (2000 * dollar20);
				dollar20 = 0;
			} else if (dollar10 > 1) {
				System.out.println(dollar10 + " ten dollar bills");
				changeGivenBackCopy -= (1000 * dollar10);
				dollar10 = 0;
			} else if (dollar10 == 1) {
				System.out.println(dollar10 + " ten dollar bill");
				changeGivenBackCopy -= (1000 * dollar10);
				dollar10 = 0;
			} else if (dollar5 > 1) {
				System.out.println(dollar5 + " five dollar bills");
				changeGivenBackCopy -= (500 * dollar5);
				dollar5 = 0;
			} else if (dollar5 == 1) {
				System.out.println(dollar5 + " five dollar bill");
				changeGivenBackCopy -= (500 * dollar5);
				dollar5 = 0;
			} else if (dollar > 1) {
				System.out.println(dollar + " one dollar bills");
				changeGivenBackCopy -= (100 * dollar);
				dollar = 0;
			} else if (dollar == 1) {
				System.out.println(dollar + " one dollar bill");
				changeGivenBackCopy -= (100 * dollar);
				dollar = 0;
			} else if (cent25 > 1) {
				System.out.println(cent25 + " quarters");
				changeGivenBackCopy -= (25 * cent25);
				cent25 = 0;
			} else if (cent25 == 1) {
				System.out.println(cent25 + " quarter");
				changeGivenBackCopy -= (25 * cent25);
				cent25 = 0;
			} else if (cent10 > 1) {
				System.out.println(cent10 + " dimes");
				changeGivenBackCopy -= (10 * cent10);
				cent10 = 0;
			} else if (cent10 == 1) {
				System.out.println(cent10 + " dime");
				changeGivenBackCopy -= (10 * cent10);
				cent10 = 0;
			} else if (cent5 > 1) {
				System.out.println(cent5 + " nickels");
				changeGivenBackCopy -= (5 * cent5);
				cent5 = 0;
			} else if (cent5 == 1) {
				System.out.println(cent5 + " nickel");
				changeGivenBackCopy -= (5 * cent5);
				cent5 = 0;
			} else if (cent > 1) {
				System.out.println(cent + " pennies");
				changeGivenBackCopy -= (1 * cent);
				cent = 0;
			} else if (cent == 1) {
				System.out.println(cent + " penny");
				changeGivenBackCopy -= (1 * cent);
				cent = 0;
			}
		}
	}
}
