package se.lexicon.teresia.vendingmachine;

public enum Denomination {
	_1KR(1,10,0,0)//{ public int countCoins(int amount) {return amount%10%5;}}
	,
	_5KR(5,10,0,1),
	_10KR(10,20,0,2),
	_20KR(20,50,0,3),
	_50KR(50,100,0,4),
	_100KR(100,500,0,5),
	_500KR(500,1000,0,6),
	_1000KR(1000,0,0,7);//{ public int countCoins(int amount) {return amount/1000;}};
	
	private int value;
	private int moduloCalc;
	private int numberOf;
	public int index;
	
	private Denomination(int value, int moduloCalc, int numberOf, int index) {
		this.value = value;
		//this.moduloCalc = moduloCalc;
		this.numberOf = numberOf;
	}
	
	public int getValue() {
		return this.value;
	}	
	
	public int getNumberOf() {
		return numberOf;
	}

	public void setNumberOf(int numberOf) {
		this.numberOf = numberOf;
	}
	
	public int countCoins(int amount)
	{
		return amount%moduloCalc;///value;
	}

	@Override
	public String toString() {
		return this.numberOf +" st "+this.value + "kronor";
	}
}
