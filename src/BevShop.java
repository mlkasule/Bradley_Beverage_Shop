import java.util.ArrayList;

public class BevShop implements BevShopInterface {
	private int numOfAlcohol_Drinks;
	private ArrayList<Integer> orderList; // list of orders
	private int time; // time
	private DAY orderDay; // day order was placed
	private Customer customer; // customer name and age
	private final int MINIMUM_AGE = 21; // minimum age to drink
	private final int MAX_ALCOHOL_DRINKS = 3; // maximum drinks
	private ArrayList<Order> bevList; // list of beverages

	public BevShop(int numOfAlcohol_Drinks, ArrayList<Integer> orderList, int time, DAY orderDay, Customer customer,
			ArrayList<Order> bevList) {
		this.numOfAlcohol_Drinks = numOfAlcohol_Drinks;
		this.orderList = orderList;
		this.time = time;
		this.orderDay = orderDay;
		this.customer = customer;
		this.bevList = bevList;
	}

	public int getNumOfAlcohol_Drinks() {
		return numOfAlcohol_Drinks;
	}

	public void setNumOfAlcohol_Drinks(int numOfAlcohol_Drinks) {
		this.numOfAlcohol_Drinks = numOfAlcohol_Drinks;
	}

	public ArrayList<Integer> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<Integer> orderList) {
		this.orderList = orderList;
	}

	public DAY getOrderDay() {
		return orderDay;
	}

	public void setOrderDay(DAY orderDay) {
		this.orderDay = orderDay;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ArrayList<Order> getBevList() {
		return bevList;
	}

	public void setBevList(ArrayList<Order> bevList) {
		this.bevList = bevList;
	}

	/**
	 * Checks if the time is valid (between 8 and 23 )
	 * 
	 * @param time time represents the time
	 * @return true if times is within the range of 8 to 23 , false otherwise
	 */
	public boolean validTime(int time) {

		if (time >= 8 && time <= 23)
			return true;
		else
			return false;
	}

	/**
	 * checks if the number of alcohol beverages for the current order has reached
	 * the maximum
	 * 
	 * @return true if number of alcohol drinks for the current order has reached
	 *         the maximum , false otherwise
	 */
	public boolean eligibleForMore() {
	}

	/**
	 * check the valid age for the alcohol drink
	 * 
	 * @param age the age
	 * @return returns true if age is more than minimum eligible age , false
	 *         otherwise
	 */
	public boolean validAge(int age) {
	}

	/**
	 * Creates a new order , NO BEVERAGE is added to the order yet
	 * 
	 * @param time         time of the order
	 * @param day          day of the order of type DAY
	 * @param customerName customer name
	 * @param customerAge  customer age
	 */

	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
	}

	/**
	 * process the Coffee order for the current order by adding it to the current
	 * order
	 * 
	 * @param bevName    beverage name
	 * @param size       beverage size
	 * @param extraShot  true if the coffee beverage has extra shot , false
	 *                   otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false
	 *                   otherwise
	 */

	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
	}

	/**
	 * process the Alcohol order for the current order by adding it to the current
	 * order
	 * 
	 * @param bevName beverage name
	 * @param size    beverage size
	 */
	public void processAlcoholOrder(String bevName, SIZE size) {
	}

	/**
	 * process the Smoothie order for the current order by adding it to the current
	 * order
	 * 
	 * @param bevName     beverage name
	 * @param size        beverage size
	 * @param numOfFruits number of fruits to be added
	 * @param addProtien  true if protein is added , false otherwise
	 */
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
	}

	/**
	 * locate an order based on the order number
	 * 
	 * @param orderNo the order number
	 * @return the index of the order in the list of Orders if found or -1 if not
	 *         found
	 */
	public int findOrder(int orderNo) {
	}

	/**
	 * locates an order in the list of orders and returns the total value on the
	 * order.
	 * 
	 * @param orderNo the order number
	 * @returns the calculated price on this order.
	 */
	public double totalOrderPrice(int orderNo) {
	}

	/**
	 * Calculates the total sale of all the orders for this beverage shop
	 * 
	 * @return the total sale of all the orders
	 */
	public double totalMonthlySale() {
	}

	/**
	 * sorts the orders within this bevShop using the Selection sort algorithm
	 */
	public void sortOrders() {
	}

	/**
	 * returns Order in the list of orders at the index Notes: this method returns
	 * the shallow copy of the order
	 * 
	 * @return Order in the list of orders at the index
	 */
	public Order getOrderAtIndex(int index) {
	}

	public String toString() {
		String str = "" ;
		return str + " Monthly Sales: " + /*monthlySales()*/;
	}

}
