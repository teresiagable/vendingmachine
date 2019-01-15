package se.lexicon.teresia.vendingmachine;

import java.util.Scanner;

import Utils.HelpMe;
import models.Candy;
import models.Denomination;
import models.Drink;
import models.Food;
import models.Product;
import services.MoneyPool;
import services.VendingMachine;

public class App {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		
		VendingMachineManager theManager = new VendingMachineManager(getCurrentProducts());

		System.out.println("Welcome to the Vending machine!");

		theVM.listProducts();
		boolean continueShopping = true;

		while (continueShopping) {

			int menuChoice = printAndGetMenuChoice(theVM);

			switch (menuChoice) {
			case 1:
				theManager.insertMoney(theVM);
				break;
			case 2:
				Product prod = theManager.doPurchase(theVM);
				if (prod != null)
					theManager.doUse(prod);
				break;
			case 3:
				theManager.doExamine(theVM);
				break;
			case 4:
				theManager.cashOut(theVM);
				break;
			case 5:
				theManager.leave(theVM);
				break;
			default:
				break;
			}
		}
	}

	private static int printAndGetMenuChoice(VendingMachine theVM) {

		System.out.println("------------------");
		System.out.println("1. Insert money");
		System.out.println("2. Purchase");
		System.out.println("3. Examine");
		System.out.println("4. Cash out");
		System.out.println("5. Leave");
		System.out.println("Money inserted: " + theVM.getAmount());

		return HelpMe.readIntegerfromUser();

	}

//	public static int readIntegerfromUser() {
//		try {
//			System.out.println("Enter a number: ");
//			String input = scanner.nextLine();
//			return Integer.parseInt(input);
//		} catch (NumberFormatException e) {
//			System.out.println("Not a valid number");
//			return readIntegerfromUser();
//		}
//	}


	private static Product[] getCurrentProducts() {
		Product[] stuff = new Product[6];
		stuff[0] = new Drink(1, "Coca Cola", 15, 300, true, "Cola taste", "tin");
		stuff[1] = new Drink(2, "Fanta", 12, 300, true, "Orange", "glass bottle");
		stuff[2] = new Drink(3, "Water", 12, 500, false, "Aloe Vera","sippy cup");
		stuff[3] = new Candy(4, "Ahlgrens Bilar", 17, 150, "Sweet","plastic bag");
		stuff[4] = new Candy(5, "Godisrem", 5, 25, "Sour","no packaging");
		stuff[5] = new Candy(6, "Pingvinpinne", 5, 10, "Likkerish and mint", "paper");
		stuff[2] = new Food(7, "Sandwich", 30, 250,"bread etc", "ham and cheese");
		stuff[3] = new Food(7, "Chicken leg", 20, 20,"grilled meat", "pepper and garlic");
		return stuff;
	}
}
