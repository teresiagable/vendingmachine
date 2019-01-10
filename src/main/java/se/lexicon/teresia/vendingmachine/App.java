package se.lexicon.teresia.vendingmachine;

import java.util.Scanner;

public class App {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		MoneyPool theMoney = new MoneyPool();
		Product[] theProducts = getCurrentProducts();
		VendingMachine theVM = new VendingMachine(theMoney, theProducts);

		System.out.println("Welcome to the Vending machine!");

		theVM.listProducts();
		boolean continueShopping = true;

		while (continueShopping) {

			int menuChoice = printAndGetMenuChoise();

			switch (menuChoice) {
			case 1:
				insertMoney(theVM);
				break;
			case 2:
				doPurchase();
				break;
			case 3:
				doExamine();
				break;
			case 4:
				// use the product just bought
				break;
			default:

				break;
			}
		}
		int amount = scanner.nextInt();
		System.out.println(amount);
		theVM.insertMoney(amount);
//        for (int coins : theVM.getChange()) {
//			d.getValue();
//		}
		// continueShopping = continueOrNot();

	}

	private static void doExamine() {
		// TODO Auto-generated method stub

	}

	private static void doPurchase() {
		// TODO Auto-generated method stub

	}

	private static void insertMoney(VendingMachine theVM) {
		System.out.println("How much money do you want to insert?");
		theVM.insertMoney(readIntegerfromUser());
	}

	private static int printAndGetMenuChoise(VendingMachine theVM) {


		System.out.println("Press the number for your choice:");
		System.out.println("1. Insert money");
		System.out.println("2. Purchase");
		System.out.println("3. Examine");
		System.out.println("4. Use");
		System.out.println("5. Leave");
		System.out.println("Money inserted: "+theVM.getAmount());

		return readIntegerfromUser();

	}

	public static int readIntegerfromUser() {
		try {
			System.out.println("Enter a number: ");
			String input = scanner.nextLine();
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("Not a valid number");
			return readIntegerfromUser();
		}
	}

	private static Product[] getCurrentProducts() {
		Product[] stuff = new Product[6];
		stuff[0] = new Drink(0, "Coca Cola", 15, 300, true, "Cola taste");
		stuff[1] = new Drink(1, "Fanta", 15, 300, true, "Orange");
		stuff[2] = new Drink(2, "Sprite", 15, 300, true, "Lemon");
		stuff[3] = new Candy(3, "Ahlgrens Bilar", 15, 300, "Sweet");
		stuff[4] = new Candy(4, "Godisrem", 15, 300, "Sour");
		stuff[5] = new Candy(5, "Pingvinstång", 15, 300, "Likkerish and mint");
		return stuff;
	}
}
