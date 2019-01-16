package se.lexicon.teresia.vendingmachine;

import Utils.HelpMe;
import models.*;

public class App {

	public static void main(String[] args) {

		VendingMachineManager theManager = new VendingMachineManager(getCurrentProducts());

		System.out.println("Welcome to the Vending machine!");

		theManager.listProducts();
		boolean continueShopping = true;

		while (continueShopping) {

			int menuChoice = printAndGetMenuChoice(theManager.getAmount());

			switch (menuChoice) {
			case 1:
				theManager.listProducts();
				break;
			case 2:
				theManager.insertMoney();
				break;
			case 3:
				Product prod = theManager.doPurchase();
				if (prod != null)
					theManager.doUse(prod);
				break;
			case 4:
				theManager.doExamine();
				break;
			case 5:
				theManager.cashOut();
				break;
			case 6:
				theManager.leave();
				break;
			default:
				break;
			}
		}
	}

	private static int printAndGetMenuChoice(int moneyAmount) {

		System.out.println("------------------");
		System.out.println("1. List products");
		System.out.println("2. Insert money");
		System.out.println("3. Purchase");
		System.out.println("4. Examine");
		System.out.println("5. Cash out");
		System.out.println("6. Leave");
		System.out.println("Money inserted: " + moneyAmount);

		return HelpMe.readIntegerfromUser(null,1,6);

	}


	private static Product[] getCurrentProducts() {
		Product[] stuff = new Product[8];
		stuff[0] = new Drink(1, "Coca Cola", 15, 300, true, "Cola taste", "tin");
		stuff[1] = new Drink(2, "Fanta", 12, 300, true, "Orange", "glass bottle");
		stuff[2] = new Drink(3, "Water", 12, 500, false, "Aloe Vera","sippy cup");
		stuff[3] = new Candy(4, "Ahlgrens Bilar", 17, 150, "Sweet","plastic bag");
		stuff[4] = new Candy(5, "Godisrem", 5, 25, "Sour","no packaging");
		stuff[5] = new Candy(6, "Pingvinpinne", 5, 10, "Likkerish and mint", "paper");
		stuff[6] = new Food(7, "Sandwich", 30, 250,"bread etc", "ham and cheese");
		stuff[7] = new Food(8, "Chicken leg", 20, 20,"grilled meat", "pepper and garlic");
		return stuff;
	}
}
