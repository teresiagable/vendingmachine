package se.lexicon.teresia.vendingmachine;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import services.MoneyPool;

public class MoneyPoolTest {

	
	@Test
	public void check_amount_new_account() {
		MoneyPool myMoney = new MoneyPool();
		
		assertEquals(0, myMoney.getAmount());
	}
	
	@Test
	public void check_insert_amount_() {
		MoneyPool myMoney = new MoneyPool();
		myMoney.addAmount(22);
		assertEquals(22, myMoney.getAmount());
	}
	
}
