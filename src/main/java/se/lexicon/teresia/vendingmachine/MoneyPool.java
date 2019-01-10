package se.lexicon.teresia.vendingmachine;

public class MoneyPool {

		private int amount=0;

		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		
		public int addAmount(int money)
		{
			this.amount +=money;
			return getAmount();
		}
		
		public int[] getChange()
		{
			//1kr, 5kr, 10kr, 20kr, 50kr, 100kr, 500kr and 1000kr.
			int[] theChange = new int[8];
			
			
			theChange[Denomination._1KR.index] = this.amount%10%5; //1 kr
			theChange[Denomination._5KR.index] = this.amount%10/5; //5 kr
			theChange[Denomination._10KR.index] = this.amount%20/10; //10 kr
			theChange[Denomination._20KR.index] = this.amount%50/20; //20 kr
			theChange[Denomination._50KR.index] = this.amount%100/50; //50 kr
			theChange[Denomination._100KR.index] = this.amount%500/100; //100 kr
			theChange[Denomination._500KR.index] = this.amount%1000/500; //500 kr
			theChange[Denomination._1000KR.index] = this.amount/1000; //1000 kr	
			
//			int howManyDens = 0;
//			
//			for (int value : theChange) {
//				if(value>0) howManyDens++;
//			}
			
//			Denomination[] theRealChange = new Denomination[howManyDens] ;
//			for (Denomination denomination : theChange) {
//				denomination.setNumberOf(Denomination.countCoins(amount));
//			}
		
			return theChange;
		}
}
