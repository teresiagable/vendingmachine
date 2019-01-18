package services;

import models.Denomination;
import models.Product;

public class VendingMachine implements I_VendingMachine {
	private MoneyPool myMoney = new MoneyPool();
	private Product[] theProducts = new Product[0];

	public VendingMachine(Product[] theProducts) {
		super();
		this.theProducts = theProducts;
	}


	@Override
	public int insertMoney(int money) {
		myMoney.addAmount(money);
		return myMoney.getAmount();
	}

	@Override
	public int getAmount() {
		return myMoney.getAmount();
	}

	public void setAmount(int amount) {
		myMoney.setAmount(amount);
	}
	
	@Override
	public void listProducts() {
		for (Product product : theProducts) {
			System.out.println(product.getId() + " " + product);
		}
	}

	public int[] getProductIds() {
		int[] idArray = new int[theProducts.length];
		int i = 0;
		for (Product product : theProducts) {

			idArray[i] = product.getId();
			i++;
		}
		return idArray;
	}

	public Product getProductById(int id) {
		for (Product product : theProducts) {
			if (product.getId() == id)
				return product;
		}
		return null;
	}

	@Override
	public boolean purchase(Product prod) {

		int price = prod.getPrice();
		if (this.myMoney.getAmount() >= price) {
			// ask the to the machine to release the product into the "fetch box"

			// update the moneypool
			this.myMoney.removeAmount(price);
			return true;
		} else
			System.out.println("Not enought money. Insert more.");
		return false;
	}

	@Override
	public String examine(Product thing) {
		thing.Examine();
		return null;
	}

	@Override
	public String use(Product thing) {
		// TODO Auto-generated method stub
		return null;
	}


	public int[] getDenominationValues() {
	
		int[] denoms = new int[Denomination.values().length];
		int i=0;
		for (Denomination d : Denomination.values()) {
			denoms[i]= d.getValue();
			i++;
		}
		return denoms;
		
	}



}
