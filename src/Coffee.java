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

	public boolean isExtraShotCoffee() {
		return extraShotCoffee;
	}

	public void setExtraShotCoffee(boolean extraShotCoffee) {
		this.extraShotCoffee = extraShotCoffee;
	}

	public boolean isExtraShotSyrup() {
		return extraShotSyrup;
	}

	public void setExtraShotSyrup(boolean extraShotSyrup) {
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

			if (isExtraShotCoffee() == true)
				price = getBASE_PRICE() + COFFEE_SHOT;
			else if (isExtraShotSyrup() == true)
				price = getBASE_PRICE() + EXTRA_SYRUP;
			else if (isExtraShotCoffee() == true && isExtraShotSyrup() == true)
				price = getBASE_PRICE() + EXTRA_SYRUP + EXTRA_SYRUP;
			else
				price = getBASE_PRICE();

		} else if (getSize().equals(SIZE.MEDIUM)) {

			if (isExtraShotCoffee() == true)
				price = (getBASE_PRICE() + COFFEE_SHOT) + (getSIZE_PRICE() * 2);
			else if (isExtraShotSyrup() == true)
				price = (getBASE_PRICE() + EXTRA_SYRUP) + (getSIZE_PRICE() * 2);
			else if (isExtraShotCoffee() == true && isExtraShotSyrup() == true)
				price = (getBASE_PRICE() + COFFEE_SHOT + EXTRA_SYRUP) * (getSIZE_PRICE() * 2);
			else
				price = getBASE_PRICE() * (getSIZE_PRICE() * 2);

		} else if (getSize().equals(SIZE.LARGE)) {
			if (isExtraShotCoffee() == true)
				price = (getBASE_PRICE() + COFFEE_SHOT) + (getSIZE_PRICE() * 3);
			else if (isExtraShotSyrup() == true)
				price = (getBASE_PRICE() + EXTRA_SYRUP) + (getSIZE_PRICE() * 3);
			else if (isExtraShotCoffee() == true && isExtraShotSyrup() == true)
				price = (getBASE_PRICE() + COFFEE_SHOT + EXTRA_SYRUP) + (getSIZE_PRICE() * 3);
			else
				price = getBASE_PRICE() * (getSIZE_PRICE() * 3);
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

		if (getName().equals(bevName) && getType().equals(bevType) && getSize().equals(bevSize))
			compare = true;

		return compare;
	}

	@Override
	/**
	 * Print Coffee details including the name and size
	 */
	public String toString() {

		String str = "Name: " + getName() + "\nSize: " + getSize() + "\nExtra Coffee Shot: " + isExtraShotCoffee()
				+ " Extra Syrup Shot:  " + isExtraShotSyrup() + "\nPrice: " + calcPrice();
		return str;
	}

}
