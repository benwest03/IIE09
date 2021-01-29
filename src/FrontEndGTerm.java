
public class FrontEndGTerm {

	private GTerm uiGT;
	private BackEnd backEnd;
	private Beer beers[];
	
	private String tab;
	
	public FrontEndGTerm(BackEnd backEnd) {
		tab = "\t";
		
		beers = new Beer[backEnd.getTotalBeersStored()];
		
		this.backEnd = backEnd;
				
		this.uiGT = new GTerm(500, 500);
		this.uiGT.addTable(500, 400, "Beer Name" + "\t" + "Beer ABV" + "\t" + "Beer Inventory");
		this.uiGT.setXY(0, 400);
		// Beer Name text field 0
		this.uiGT.addTextField("Beer Name", 125);
		// Beer ABV text field 1
		this.uiGT.addTextField("Beer ABV", 125);
		// Beer Inventory text field 2
		this.uiGT.addTextField("Inventory", 125);

		this.uiGT.addButton("Add a Beer", this, "addBeerGTerm");
	}

	public void refreshTable() {
		
		this.uiGT.clearRowsOfTable(0);
		
		int rowsAdded = 0;
		
		int i = backEnd.getTotalBeersStored();
		
		while (i > rowsAdded) {
			
			String addToTableString = backEnd.getBeerName(rowsAdded) + tab + backEnd.getBeerABV(rowsAdded) + tab
					+ backEnd.getBeerInventory(rowsAdded);
			
			this.uiGT.addRowToTable(0, addToTableString);
			
			rowsAdded+=1;
			
		}

	}

	public void addBeerGTerm() {
				
		String beerName = uiGT.getTextFromEntry(0);
		float beerABV = Float.parseFloat(uiGT.getTextFromEntry(1));
		int beerInventory = Integer.parseInt(uiGT.getTextFromEntry(2));
		
		backEnd.addNewBeer(beerName, beerABV, beerInventory);
		
		refreshTable();

	}
}
