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

			int menuChoice = printAndGetMenuChoice(theVM);

			switch (menuChoice) {
			case 1:
				insertMoney(theVM);
				break;
			case 2:
				Product prod = doPurchase(theVM);
				if (prod != null)
					doUse(prod);
				break;
			case 3:
				doExamine(theVM);
				break;
			case 4:
				cashOut(theVM);
			case 5:
				leave(theVM);
				break;
			default:
				break;
			}
		}
	}

	private static void leave(VendingMachine theVM) {
		if (theVM.getAmount() > 0)
			cashOut(theVM);
		System.out.println("You leave the vending machine");
		System.exit(0);
	}

	private static void cashOut(VendingMachine theVM) {
		int cash = theVM.getAmount();

		for (Denomination d : Denomination.values()) {
			if (d.countCoins(cash) > 0)
				System.out.println(d.countCoins(cash) + " st " + d.getValue() + " kr");
		}
		System.out.println();

	}

	private static void doUse(Product prod) {
		System.out.println("Do you want to open the " + prod.getName() + "?");
		boolean use = readYesNoFromUser();
		if (use)
			System.out.println(prod.Use());
	}

	private static void doExamine(VendingMachine theVM) {
		System.out.println("Enter the number of the product you want to examine:");

		Product theP = getProductById(theVM.theProducts, readIntegerfromUser());
		System.out.println(theP.Examine());

	}

	private static Product doPurchase(VendingMachine theVM) {
		System.out.println("Enter the number of the product you want to purchase:");

		Product theP = getProductById(theVM.theProducts, readIntegerfromUser());

		boolean succeeded = theVM.purchase(theP);
		return (succeeded ? theP : null);

	}

	private static Product getProductById(Product[] theProducts, int id) {
		for (Product product : theProducts) {
			if (product.getId() == id)
				return product;
		}
		return null;
	}

	private static void insertMoney(VendingMachine theVM) {
		System.out.println("How much money do you want to insert?");
		theVM.insertMoney(readIntegerfromUser());
	}

	private static int printAndGetMenuChoice(VendingMachine theVM) {

		System.out.println("Press the number for your choice:");
		System.out.println("1. Insert money");
		System.out.println("2. Purchase");
		System.out.println("3. Examine");
		System.out.println("4. Cash out");
		System.out.println("5. Leave");
		System.out.println("Money inserted: " + theVM.getAmount());

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

	/**
	 * @return false if user has entered N or n, else true
	 */
	private static boolean readYesNoFromUser() {
		String input = scanner.nextLine();
		boolean returnValue = true;
		switch (input) {
		case "Y":
		case "y":
			returnValue = true;
			break;
		case "N":
		case "n":
			returnValue = false;
			break;
		default:
			System.out.println("I'll take that as a YES");
			returnValue = true;
			break;
		}
		return returnValue;
	}

	private static Product[] getCurrentProducts() {
		Product[] stuff = new Product[6];
		stuff[0] = new Drink(1, "Coca Cola", 15, 300, true, "Cola taste");
		stuff[1] = new Drink(2, "Fanta", 12, 300, true, "Orange");
		stuff[2] = new Drink(3, "Water", 12, 500, false, "Aloe Vera");
		stuff[3] = new Candy(4, "Ahlgrens Bilar", 17, 150, "Sweet");
		stuff[4] = new Candy(5, "Godisrem", 5, 25, "Sour");
		stuff[5] = new Candy(6, "Pingvinstång", 5, 10, "Likkerish and mint");
		return stuff;
	}
}
