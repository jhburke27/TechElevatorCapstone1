package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_EXIT };

	private static final String SUB_MENU_FEED_MONEY = "Feed Money";
	private static final String SUB_MENU_SELECT_PRODUCT = "Select Product";
	private static final String SUB_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String SUB_MENU_SALES_REPORT = "Generate Sales Report";
	private static final String[] SUB_MENU_OPTIONS = { SUB_MENU_FEED_MONEY, SUB_MENU_SELECT_PRODUCT, SUB_MENU_FINISH_TRANSACTION, SUB_MENU_SALES_REPORT };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public VendingMachineCLI() {

	}
	private VendingMachine myVendingMachine = new VendingMachine();
	private SalesReport salesReport = new SalesReport();
	public void run() {
		//creating new vending machine instance

		//loading the products from input file
		myVendingMachine.ProductsFromFile();
		//loop until the user chooses to exit
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				myVendingMachine.displayItems();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				runsSubMenu();
			} else if (choice.equals(MAIN_MENU_EXIT)){
				break;
			}
		}
	}

	public void runsSubMenu(){
		//shows sub menu / user choice
		while(true){
			System.out.println("Current Balance: $" + myVendingMachine.getMoneyFeed().getCurrentBalance());
			String choice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);
			if(choice.equals(SUB_MENU_FINISH_TRANSACTION)){
				myVendingMachine.getMoneyFeed().dispenseChange();
				break;
			} else if(choice.equals(SUB_MENU_FEED_MONEY)){
				myVendingMachine.getMoneyFeed().addMoney();
			} else if(choice.equals(SUB_MENU_SELECT_PRODUCT)){
				myVendingMachine.purchase();
			} else if (choice.equals(SUB_MENU_SALES_REPORT)){
				//code
				salesReport.generateSalesReport();
			}
		}
	}




	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
