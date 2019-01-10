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
		return myMoney.getAmount();
	}

	@Override
	public int getAmount() {
		return myMoney.getAmount();
	}

	@Override
	public int[] getChange() {
		
		
		return myMoney.getChange();
	}

	@Override
	public void listProducts() {
		for (Product product : theProducts) {
		 System.out.println(product.getId()+" "+product.toString());
		}
		
	}

	@Override
	public boolean purchase(Product thing, MoneyPool theMoney) {
		// TODO Auto-generated method stub
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
