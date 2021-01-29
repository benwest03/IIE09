
public class BackEnd {

	private Beer beers[];

	private int maxBeersStored;
	private int totalBeersStored;
	private int arrayPosition;
	
	public void addNewBeer(String beerName, float beerABV, int beerInventory) {

		this.beers[arrayPosition] = new Beer(beerName, beerABV, beerInventory);

		this.totalBeersStored += 1;
		this.arrayPosition += 1;
	}

	public String getBeerName(int x) {
		String beerName = beers[x].getBeerName();
		return beerName;
	}
	
	public float getBeerABV(int x) {
		float beerABV = beers[x].getBeerABV();
		return beerABV;
	}
	
	public int getBeerInventory(int x) {
		int beerInventory = beers[x].getBeerInventory();
		return beerInventory;
	}
	
	public int getTotalBeersStored() {
		return this.totalBeersStored;
	}

	public BackEnd() {

		arrayPosition = 0;
		totalBeersStored = 0;
		maxBeersStored = 100;

		beers = new Beer[maxBeersStored];

	}
}
