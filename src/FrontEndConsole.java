import java.util.Scanner;

public class FrontEndConsole {

	private Scanner scan;
	private BackEnd backEnd;

	private String beerName;
	private float beerABV;
	private int beerInventory;

	private String tab;

	public void cleanUserInput(String x) {
		String[] splitData = x.split("/");
		this.beerName = splitData[0];
		this.beerABV = Float.parseFloat(splitData[1]);
		this.beerInventory = Integer.parseInt(splitData[2]);

	}

	public void refreshConsole() {
		System.out.println("Beer Name" + tab + tab + "Beer ABV" + tab + tab + "Current Inventory");
		System.out.println("--------------------------------------------------");

		int rowsAdded = 0;
		int totalBeers = backEnd.getTotalBeersStored();
		while (rowsAdded < totalBeers) {
			
			System.out.println(backEnd.getBeerName(rowsAdded) + tab + tab + backEnd.getBeerABV(rowsAdded) + tab + tab
					+ backEnd.getBeerInventory(rowsAdded));
			
			rowsAdded += 1;
		}

		System.out.println("--------------------------------------------------");

	}

	public void addBeerConsole() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter in a Beer name, an ABV and number in Inventory");
		System.out.println("Seperate them by a slash eg Corona/4.5/256");
		String userInput = scan.nextLine();

		cleanUserInput(userInput);

		backEnd.addNewBeer(this.beerName, this.beerABV, this.beerInventory);

		refreshConsole();
		addBeerConsole();

	}

	public FrontEndConsole(BackEnd backEnd) {
		this.tab = "\t";
		this.backEnd = backEnd;
		addBeerConsole();
	}
}
