package se.lexicon.teresia.vendingmachine;

import Utils.HelpMe;
import models.Denomination;
import models.Product;
import services.MoneyPool;
import services.VendingMachine;

public class VendingMachineManager {
	private static MoneyPool theMoney = new MoneyPool();
	private static Product[] theProducts;
	private static VendingMachine theVM = new VendingMachine(theMoney, theProducts);
	
	
	
	public VendingMachineManager( Product[] theProducts) {

		this.theProducts = theProducts;
	}

	public static void insertMoney() {
		theVM.insertMoney(HelpMe.readIntegerfromUser("How much money do you want to insert?"));
	}
	
	private static Product getProductById(Product[] theProducts, int id) {
		for (Product product : theProducts) {
			if (product.getId() == id)
				return product;
		}
		return null;
	}
	
	public static Product doPurchase(VendingMachine theVM) {
		System.out.println("\nEnter the number of the product you want to purchase:");

		Product theP = getProductById(theVM.theProducts, HelpMe.readIntegerfromUser());

		boolean succeeded = theVM.purchase(theP);
		return (succeeded ? theP : null);

	}

	public static void doUse(Product prod) {
		System.out.println("Do you want to open the " + prod.getName() + "?");
		boolean use = HelpMe.readYesNoFromUser();
		if (use)
			System.out.println(prod.Use());
	}

	public static void doExamine(VendingMachine theVM) {
		Product theP = getProductById(theVM.theProducts, HelpMe.readIntegerfromUser("Enter the number of the product you want to examine:"));
		System.out.println(theP.Examine());
	}

	public static void cashOut(VendingMachine theVM) {
		int cash = theVM.getAmount();
		theVM.myMoney.setAmount(0);
		for (Denomination d : Denomination.values()) {
			if (d.countCoins(cash) > 0)
				System.out.println(d.countCoins(cash) + " st " + d.getValue() + " kr");
		}
		System.out.println();
	}

	public static void leave(VendingMachine theVM) {
		if (theVM.getAmount() > 0)
			cashOut(theVM);
		System.out.println("You leave the vending machine");
		System.exit(0);
	}

	
	public void listProducts() {
		theVM.listProducts();
		
	}


}
