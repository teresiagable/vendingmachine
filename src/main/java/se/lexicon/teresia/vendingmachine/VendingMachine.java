package se.lexicon.teresia.vendingmachine;

public class VendingMachine implements I_VendingMachine {
	public MoneyPool myMoney = new MoneyPool();
	public Product[] theProducts = new Product[0];

	public VendingMachine(MoneyPool myMoney, Product[] theProducts) {
		super();
		this.myMoney = myMoney;
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

	@Override
	public void listProducts() {
		for (Product product : theProducts) {
			System.out.println(product.getId() + " " + product.toString());
		}

	}

	@Override
	public boolean purchase(Product prod) {
		int price = prod.getPrice();

		if (this.myMoney.getAmount() >= price) {
			//ask the to the machine to release the product into the "fetch box"
			
			//update the moneypool
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

}
