package se.lexicon.teresia.vendingmachine;

public interface I_VendingMachine {

	/**
	 * @param money amount to add
	 * @return total amount of money
	 */
	int insertMoney(int money);
	
	/**
	 * @return total amount
	 */
	int getAmount();
	
	void listProducts();
	boolean purchase(Product prod);
	String examine(Product prod);
	String use(Product prod);
	
	
	
}
