/**
 * This abstract class shows the details an order
 * 
 * @author Mark Kasule
 *
 */
public abstract class Beverage {

	private String name;
	private TYPE type;
	private SIZE size;
	private final double BASE_PRICE = 2.0;
	private final double SIZE_PRICE = 1;

	/**
	 * Beverage constructor
	 * 
	 * @param name
	 * @param type
	 * @param size
	 */
	public Beverage(String name, TYPE type, SIZE size) {
		this.name = name;
		this.type = type;
		this.size = size;
	}

	public Beverage(Beverage drinks) {
		this.name = drinks.name;
		this.type = drinks.type;
		this.size = drinks.size;
	}

	// METHODS

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public SIZE getSize() {
		return size;
	}

	public void setSize(SIZE size) {
		this.size = size;
	}

	public double getBASE_PRICE() {
		return BASE_PRICE;
	}

	public double getSIZE_PRICE() {
		return SIZE_PRICE;
	}

	/**
	 * this calculates and returns the beverage price.
	 * 
	 * @return
	 */
	public abstract double calcPrice();

	/**
	 * checks equality based on name, type, size of the beverage
	 * 
	 * @param bevName
	 * @param bevType
	 * @param bevSize
	 * @return true or false
	 */
	public abstract boolean equals(String bevName, TYPE bevType, SIZE bevSize);

	/**
	 * String representation for Beverage including the name and size
	 */
	public abstract String toString();

}
