/**
 * This class holds details about the coffee class
 * 
 * @author Mark Kasule
 *
 */
public class Coffee extends Beverage {

	private boolean extraShotCoffee;
	private boolean extraShotSyrup;
	private final double COFFEE_SHOT = 0.50;
	private final double EXTRA_SYRUP = 0.50;

	public Coffee(String name, TYPE type, SIZE size, boolean extraShotCoffee, boolean extraShotSyrup) {
		super(name, type, size);
		this.extraShotCoffee = extraShotCoffee;
		this.extraShotSyrup = extraShotSyrup;
	}
	
	public Coffee(String name, SIZE size, boolean extraShotCoffee, boolean extraShotSyrup) {
		super(name, size);
		this.extraShotCoffee = extraShotCoffee;
		this.extraShotSyrup = extraShotSyrup;
	}

	public boolean getExtraShot() {
		return extraShotCoffee;
	}

	public void setExtraShot(boolean extraShotCoffee) {
		this.extraShotCoffee = extraShotCoffee;
	}

	public boolean getExtraSyrup() {
		return extraShotSyrup;
	}

	public void setExtraSyrup(boolean extraShotSyrup) {
		this.extraShotSyrup = extraShotSyrup;
	}

	@Override
	/**
	 * Calculates and returns the beverage price.
	 * 
	 * @return price
	 */
	public double calcPrice() {

		double price = 0;

		if (getSize().equals(SIZE.SMALL)) {

			if (getExtraShot() == true)
				price = getBasePrice() + COFFEE_SHOT;
			else if (getExtraSyrup() == true)
				price = getBasePrice() + EXTRA_SYRUP;
			else if (getExtraShot() == true && getExtraSyrup() == true)
				price = getBasePrice() + EXTRA_SYRUP + EXTRA_SYRUP;
			else
				price = getBasePrice();

		} else if (getSize().equals(SIZE.MEDIUM)) {

			if (getExtraShot() == true)
				price = (getBasePrice() + COFFEE_SHOT) + (getSIZE_PRICE() * 2);
			else if (getExtraSyrup() == true)
				price = (getBasePrice() + EXTRA_SYRUP) + (getSIZE_PRICE() * 2);
			else if (getExtraShot() == true && getExtraSyrup() == true)
				price = (getBasePrice() + COFFEE_SHOT + EXTRA_SYRUP) * (getSIZE_PRICE() * 2);
			else
				price = getBasePrice() * (getSIZE_PRICE() * 2);

		} else if (getSize().equals(SIZE.LARGE)) {
			if (getExtraShot() == true)
				price = (getBasePrice() + COFFEE_SHOT) + (getSIZE_PRICE() * 3);
			else if (getExtraSyrup() == true)
				price = (getBasePrice() + EXTRA_SYRUP) + (getSIZE_PRICE() * 3);
			else if (getExtraShot() == true && getExtraSyrup() == true)
				price = (getBasePrice() + COFFEE_SHOT + EXTRA_SYRUP) + (getSIZE_PRICE() * 3);
			else
				price = getBasePrice() * (getSIZE_PRICE() * 3);
		}

		return price;
	}

	@Override
	/**
	 * checks equality based on name, type, size of the beverage
	 * 
	 * @param bevName
	 * @param bevType
	 * @param bevSize
	 * @return true or false
	 */
	public boolean equals(String bevName, TYPE bevType, SIZE bevSize) {

		boolean compare = false;

		if (getBevName().equals(bevName) && getType().equals(bevType) && getSize().equals(bevSize))
			compare = true;

		return compare;
	}

	@Override
	/**
	 * Print Coffee details including the name and size
	 */
	public String toString() {

		String str = "Name: " + getBevName() + "\nSize: " + getSize() + "\nExtra Coffee Shot: " + getExtraShot()
				+ " Extra Syrup Shot:  " + getExtraSyrup() + "\nPrice: " + calcPrice();
		return str;
	}

}
