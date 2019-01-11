package se.lexicon.teresia.vendingmachine;

public class Candy extends Product {
	
	int weight;
	String taste;
	
	public Candy(int id, String name, int price, int weight, String taste) {
		super(id, name, price);
		this.weight = weight;
		this.taste = taste;
	}

	@Override
	public String Examine() {
		String productData = super.getName() +" "+ taste +" "+ weight +" g "+ super.getPrice() +" kr "; 
		
		return productData;
	}


	@Override
	public String Use() {
		return "Eating "+ super.getName();
	}

	
	@Override
	public String toString() {
		return "Candy " +super.getName()+" "+ weight + " g :"+super.getPrice()+" kr ";
	} 
	

	

}
