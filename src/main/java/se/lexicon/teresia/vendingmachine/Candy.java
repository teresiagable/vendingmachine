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
		String productData = name +" "+ taste +" "+ weight +" g "+ price +" kr "; 
		
		return productData;
	}


	@Override
	public String Use() {
		// TODO Auto-generated method stub
		return "Drinking "+ super.name;
	}

	
	@Override
	public String toString() {
		return "Candy " +name+" "+ weight + " g :"+price+" kr ";
	} 
	

	

}
