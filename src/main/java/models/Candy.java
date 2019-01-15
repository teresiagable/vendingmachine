package models;

public class Candy extends Product {

	private int weight;
	private String taste;
	private String packaging;

	public Candy(int id, String name, int price, int weight, String taste, String packaging) {
		super(id, name, price);
		this.weight = weight;
		this.taste = taste;
		this.packaging = packaging;
	}

	@Override
	public String Examine() {
		String productData = super.getName() + " " + taste + " " + weight + " g in " + packaging + " "
				+ super.getPrice() + " kr ";

		return productData;
	}

	@Override
	public String Use() {
		return "Eating " + super.getName()+ " *nom nom*";
	}

	@Override
	public String toString() {
		return "Candy " + super.getName() + " " + weight + " g :" + super.getPrice() + " kr ";
	}

}
