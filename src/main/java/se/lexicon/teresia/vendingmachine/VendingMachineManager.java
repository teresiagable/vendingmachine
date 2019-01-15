package se.lexicon.teresia.vendingmachine;

import Utils.HelpMe;
import models.Denomination;
import models.Product;
import services.VendingMachine;

public class VendingMachineManager {

	private static VendingMachine theVM;

	public VendingMachineManager(Product[] theProducts) {

		theVM = new VendingMachine(theProducts);
	}

	public void insertMoney() {
		theVM.insertMoney(HelpMe.readIntegerfromUser("How much money do you want to insert?"));
	}

	public Product doPurchase() {
		System.out.println("\nEnter the number of the product you want to purchase:");

		Product theP = theVM.getProductById(HelpMe.readIntegerfromUser());

		boolean succeeded = theVM.purchase(theP);
		return (succeeded ? theP : null);

	}

	public void doUse(Product prod) {
		System.out.println("Do you want to open the " + prod.getName() + "?");
		boolean use = HelpMe.readYesNoFromUser();
		if (use)
			System.out.println(prod.Use());
	}

	public void doExamine() {
		Product theP = theVM.getProductById(HelpMe
				.readIntegerfromUser("Enter the number of the product you want to examine:", theVM.getProductIds()));
		System.out.println(theP.Examine());
	}

	/**
	 * prints how many coins/bills is payed back in the values in Denomination-enum
	 * class
	 */
	public void cashOut() {
		int cash = theVM.getAmount();
		theVM.setAmount(0);
		for (Denomination d : Denomination.values()) {
			if (d.countCoins(cash) > 0)
				System.out.println(d.countCoins(cash) + " st " + d.getValue() + " kr");
		}
		System.out.println();
	}

	public void leave() {
		if (theVM.getAmount() > 0)
			cashOut();
		System.out.println("You leave the vending machine");
		System.exit(0);
	}

	public void listProducts() {
		theVM.listProducts();

	}

	public int getAmount() {
		return theVM.getAmount();
	}

}
