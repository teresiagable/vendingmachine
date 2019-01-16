package se.lexicon.teresia.vendingmachine;

import static org.junit.Assert.*;

import org.junit.Test;

import models.*;
import services.MoneyPool;
import services.VendingMachine;

public class VendingMachine_Test {

	public static Product[] products = { 
			new Candy(1, "Lollipop", 10, 30, "fruit", "no packaging"),
			new Drink(3, "Coffea", 5, 200, false, "coffea", "cup"),
			new Food(4, "Sandwich", 15, 200, "bread", "bacon") };

	public static VendingMachine VM = new VendingMachine(products);

	@Test
	public void denomination_count_numberofcoins_test() {

		assertEquals(1, Denomination._1KR.countCoins(2766));
		assertEquals(1, Denomination._5KR.countCoins(2766));
		assertEquals(1, Denomination._10KR.countCoins(2766));
		assertEquals(0, Denomination._20KR.countCoins(2766));
		assertEquals(1, Denomination._50KR.countCoins(2766));
		assertEquals(2, Denomination._100KR.countCoins(2766));
		assertEquals(1, Denomination._500KR.countCoins(2766));
		assertEquals(2, Denomination._1000KR.countCoins(2766));

	}

	@Test
	public void create_and_set_price_product_test() {

		assertEquals(10, products[0].getPrice());
		assertEquals(5, products[1].getPrice());
		assertEquals(15, products[2].getPrice());
	}

	@Test
	public void check_amount_new_account() {
		MoneyPool myMoney = new MoneyPool();

		assertEquals(0, myMoney.getAmount());
	}

	@Test
	public void check_insert_remove_amount_() {
		MoneyPool myMoney = new MoneyPool();
		myMoney.addAmount(22);
		assertEquals(22, myMoney.getAmount());

		myMoney.removeAmount(10);
		assertEquals(12, myMoney.getAmount());
	}

	public void VM_insert_money_test() {
		
		VM.insertMoney(100);
		assertEquals(100, VM.getAmount());
	}
	
	public void VM_getProductIds_test() {
		int[] ids = {1,3,4};
		assertArrayEquals(ids,VM.getProductIds());
	}
	
}

