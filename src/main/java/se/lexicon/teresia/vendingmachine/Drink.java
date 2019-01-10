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
		String productData = name +" "+ taste +" "+ (carbonated?" carbonated ":"")+ volume/10 +" cl "+ price +" kr "; 
		
		return productData;
	}


	@Override
	public String Use() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "Drink "+name+" "+ volume/10 + " cl "+price +" kr ";
	}
	
	
}