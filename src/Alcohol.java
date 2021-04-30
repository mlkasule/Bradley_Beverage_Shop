/**
 * Thsi class holds details about the alcohol class
 * 
 * @author Mark Kasule
 *
 */
public class Alcohol extends Beverage {

	private boolean offeredWeekend;
	private final double WEEKEND_BEV_COST = 0.60;

	// constructors
	public Alcohol(String name, TYPE type, SIZE size, boolean offeredWeekend) {
		super(name, type, size);
		this.offeredWeekend = offeredWeekend;
	}

	/**
	 * checks whether alcohol is offered on weekends
	 * 
	 * @return
	 */
	public boolean isOfferedWeekend() {
		return offeredWeekend;
	}

	/**
	 * Sets the value of weekend
	 * 
	 * @param offeredWeekend
	 */
	public void setOfferedWeekend(boolean offeredWeekend) {
		this.offeredWeekend = offeredWeekend;
	}

	@Override
	/**
	 * Calculates the price of alcohol
	 */
	public double calcPrice() {

		double price = 0;

		if (getSize().equals(SIZE.SMALL)) {
			if (isOfferedWeekend() == true)
				price = getBASE_PRICE() + WEEKEND_BEV_COST;
			else
				price = getBASE_PRICE();
		} else if (getSize().equals(SIZE.MEDIUM)) {
			if (isOfferedWeekend() == true)
				price = getBASE_PRICE() + WEEKEND_BEV_COST + (getSIZE_PRICE() * 2);
			else
				price = getBASE_PRICE() + (getSIZE_PRICE() * 2);
		} else if (getSize().equals(SIZE.LARGE)) {
			if (isOfferedWeekend() == true)
				price = getBASE_PRICE() + WEEKEND_BEV_COST + (getSIZE_PRICE() * 3);
			else
				price = getBASE_PRICE() + (getSIZE_PRICE() * 3);
		}
		return price;

	}

	@Override
	/**
	 * checks equality based on name, type, size of the beverage
	 * 
	 * @param bevName name of beverage
	 * @param bevType type of beverage
	 * @param bevSize size of beverage
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
	 * print Alcohol details including the name and size
	 */
	public String toString() {

		String str = "Name: " + getName() + "\nSize: " + getSize() + "\nOffered of Weekend: " + isOfferedWeekend()
				+ "\nPrice: " + calcPrice();
		return str;
	}

}
