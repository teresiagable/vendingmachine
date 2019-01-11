package se.lexicon.teresia.vendingmachine;

public enum Denomination {
	_1KR(1,10,0){ public int countCoins(int amount) {return amount%10%5;}}
	,
	_5KR(5,10,1){ public int countCoins(int amount) {return amount%10/5;}},
	_10KR(10,20,2){ public int countCoins(int amount) {return amount%20/10;}},
	_20KR(20,50,3){ public int countCoins(int amount) {return amount%50/20;}},
	_50KR(50,100,4){ public int countCoins(int amount) {return amount%100/50;}},
	_100KR(100,500,5){ public int countCoins(int amount) {return amount%500/100;}},
	_500KR(500,1000,6){ public int countCoins(int amount) {return amount%1000/500;}},
	_1000KR(1000,0,7){ public int countCoins(int amount) {return amount/1000;}};
	
	private int value;
	private int moduloCalc;
	public int index;
	
	private Denomination(int value, int moduloCalc, int index) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}	
	public int getValueByIndex(int index) {
		return this.value;
	}	
	
	public int countCoins(int amount)
	{
		return amount%moduloCalc;///value;
	}
}
