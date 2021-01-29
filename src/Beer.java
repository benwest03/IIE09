
public class Beer {
	
	private String beerName;
	private float beerABV;
	private int beerInventory;
	
	public String getBeerName() {
		return this.beerName;
	}

	public float getBeerABV() {
		return this.beerABV;
	}

	public int getBeerInventory() {
		return this.beerInventory;
	}
	
	public Beer(String beerName, float beerABV, int beerInventory) {
		this.beerName = beerName;
		this.beerABV = beerABV;
		this.beerInventory = beerInventory;
	}
}
