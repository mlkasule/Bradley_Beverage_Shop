/**
 * This class holds details the Smoothie class
 * 
 * @author Mark Kasule
 *
 */
public class Smoothie extends Beverage {

	private int numOfFruits;
	private boolean addProtein;
	private final double PROTEIN_COST = 1.50;
	private final double EXTRA_FRUIT = 0.50;

	public Smoothie(String name, TYPE type, SIZE size, int numOfFruits, boolean addProtein) {
		super(name, type, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}
	public Smoothie(String name, SIZE size, int numOfFruits, boolean addProtein) {
		super(name, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}


	public int getNumOfFruits() {
		return numOfFruits;
	}

	public void setNumOfFruits(int numOfFruits) {
		this.numOfFruits = numOfFruits;
	}

	public boolean getAddProtein() {
		return addProtein;
	}

	public void setAddProtein(boolean addProtein) {
		this.addProtein = addProtein;
	}

	@Override
	public double calcPrice() {

		double price = 0;

		if (getSize().equals(SIZE.SMALL)) {

			if (getAddProtein() == true && getNumOfFruits() > 1)
				price = getBASE_PRICE() + PROTEIN_COST + (numOfFruits - 1 * EXTRA_FRUIT);
			else if (getAddProtein() == true && getNumOfFruits() == 1)
				price = getBASE_PRICE() + PROTEIN_COST;
			else if (getAddProtein() == false && getNumOfFruits() > 1)
				price = getBASE_PRICE() + (numOfFruits - 1 * EXTRA_FRUIT);
			else
				price = getBASE_PRICE();

		} else if (getSize().equals(SIZE.MEDIUM)) {
			if (getAddProtein() == true && getNumOfFruits() > 1)
				price = getBASE_PRICE() + PROTEIN_COST + (numOfFruits - 1 * EXTRA_FRUIT) + (getSIZE_PRICE() * 2);
			else if (getAddProtein() == true && getNumOfFruits() == 1)
				price = getBASE_PRICE() + PROTEIN_COST + (getSIZE_PRICE() * 2);
			else if (getAddProtein() == false && getNumOfFruits() > 1)
				price = getBASE_PRICE() + (numOfFruits - 1 * EXTRA_FRUIT) + (getSIZE_PRICE() * 2);
			else
				price = getBASE_PRICE() + (getSIZE_PRICE() * 2);

		} else if (getSize().equals(SIZE.LARGE)) {

			if (getAddProtein() == true && getNumOfFruits() > 1)
				price = getBASE_PRICE() + PROTEIN_COST + (numOfFruits - 1 * EXTRA_FRUIT) + (getSIZE_PRICE() * 3);
			else if (getAddProtein() == true && getNumOfFruits() == 1)
				price = getBASE_PRICE() + PROTEIN_COST + (getSIZE_PRICE() * 3);
			else if (getAddProtein() == false && getNumOfFruits() > 1)
				price = getBASE_PRICE() + (numOfFruits - 1 * EXTRA_FRUIT) + (getSIZE_PRICE() * 3);
			else
				price = getBASE_PRICE() + (getSIZE_PRICE() * 3);

		}

		return price;
	}

	@Override
	/**
	 * checks equality based on name, type, size of the beverage
	 * 
	 * @param myName
	 * @param myType
	 * @param mySize
	 * @return true or false
	 */
	public boolean equals(String bevName, TYPE bevType, SIZE bevSize) {

		boolean compare = false;

		if (getName().equals(bevName) && getType().equals(bevType) && getSize().equals(bevSize))
			compare = true;

		return compare;
	}

	@Override
	/**
	 * print Smmothie details including the name and size
	 */
	public String toString() {

		String str = "Name: " + getName() + "\nSize: " + getSize() + "\nExtra Protein: " + getAddProtein()
				+ "\nNumber of Fruits:  " + getNumOfFruits() + "\nPrice: " + calcPrice();
		return str;
	}

}
