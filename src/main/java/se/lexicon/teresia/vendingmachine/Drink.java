package se.lexicon.teresia.vendingmachine;

public class Drink extends Product{
	int volume;
	boolean carbonated;
	String taste;
	
	public Drink(int id, String name, int price, int volume, boolean carbonated, String taste) {
		super(id, name, price);
		this.volume = volume;
		this.carbonated = carbonated;
		this.taste = taste;
	}

	@Override
	public String Examine() {
		String productData = super.getName() +" "+ taste +" "+ (carbonated?" carbonated ":"")+ volume/10 +" cl "+ super.getPrice() +" kr "; 
		
		return productData;
	}


	@Override
	public String Use() {
		return "Eating "+ super.getName();
	}

	@Override
	public String toString() {
		return "Drink "+super.getName()+" "+ volume/10 + " cl "+super.getPrice() +" kr ";
	}
	
	
}
