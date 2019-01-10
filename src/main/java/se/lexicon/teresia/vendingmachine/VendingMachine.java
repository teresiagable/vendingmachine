package se.lexicon.teresia.vendingmachine;

public class VendingMachine implements I_VendingMachine{
	MoneyPool myMoney = new MoneyPool();
	Product[] theProducts = new Product[0];
	
	public VendingMachine(MoneyPool myMoney, Product[] theProducts) {
		super();
		this.myMoney = myMoney;
		this.theProducts = theProducts;
	}

	@Override
	public int insertMoney(int money) {
		myMoney.addAmount(money);
		// TODO Auto-generated method stub
		return myMoney.getAmount();
	}

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Denomination[] getChange() {
		myMoney.getChange();
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product[] listProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean purchase(Product thing) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String examine(Product thing) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String use(Product thing) {
		// TODO Auto-generated method stub
		return null;
	}

}
