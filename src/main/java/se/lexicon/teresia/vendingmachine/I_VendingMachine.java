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
	
	/**
	 * @return and array of ints 
	 */
	Denomination[] getChange();
	
	Product[] listProducts();
	boolean purchase(Product thing, MoneyPool money);
	String examine(Product thing);
	String use(Product thing);
	
	
	
}
