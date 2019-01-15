package services;

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
		
		public void removeAmount(int price) {
			this.amount -=price;
		}
}
