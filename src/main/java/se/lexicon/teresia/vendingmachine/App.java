package se.lexicon.teresia.vendingmachine;

import java.util.Scanner;

public class App 
{
	private static Scanner scanner = new Scanner(System.in);

    public static void main( String[] args )
    {
    	VendingMachine theVM = new VendingMachine();
    	
        System.out.println( "Hello Vending machine user!" );

        int amount = scanner.nextInt();
        System.out.println(amount);
        theVM.insertMoney(amount);
        for (Denomination d : theVM.getChange()) {
			d.getValue();
		}
        
        
        
    }
}
