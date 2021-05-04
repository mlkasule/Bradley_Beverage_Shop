import java.util.ArrayList;

public class BevShop implements BevShopInterface {
	private int numOfAlcohol_Drinks;
	private ArrayList<Beverage> bevList = new ArrayList<>(); // list of beverages
	private int time; // time
	private DAY orderDay; // day order was placed
	private String customer; // customer name and age
	private int customerAge;
	private final int MINIMUM_AGE = 21; // minimum age to drink
	private final int MAX_ALCOHOL_DRINKS = 3; // maximum drinks
	private final int MAX_FRUIT = 5; // Maximum number of fruits that this shop offers for SMOOTHIE beverage
	private ArrayList<Order> orderList = new ArrayList<>(); // list of orders
	private Order newOrder;

	public BevShop(int numOfAlcohol_Drinks, ArrayList<Beverage> bevList, int time, DAY orderDay, String customer,
			ArrayList<Order> orderList) {
		this.numOfAlcohol_Drinks = numOfAlcohol_Drinks;
		this.bevList = bevList;
		this.time = time;
		this.orderDay = orderDay;
		this.customer = customer;
		this.orderList = orderList;
	}

	public BevShop(BevShop obj) {
		this.numOfAlcohol_Drinks = obj.numOfAlcohol_Drinks;
		this.bevList = obj.bevList;
		this.time = obj.time;
		this.orderDay = obj.orderDay;
		this.customer = obj.customer;
		this.orderList = obj.orderList;
	}

	public BevShop() {

	}

	public int getNumOfAlcoholDrink() {
		return numOfAlcohol_Drinks;
	}

	public void setNumOfAlcoholDrink(int numOfAlcohol_Drinks) {
		this.numOfAlcohol_Drinks = numOfAlcohol_Drinks;
	}

	public ArrayList<Beverage> getBevList() {
		return bevList;
	}

	public void setBevList(ArrayList<Beverage> bevList) {
		this.bevList = bevList;
	}

	public DAY getOrderDay() {
		return orderDay;
	}

	public void setOrderDay(DAY orderDay) {
		this.orderDay = orderDay;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public ArrayList<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
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
		int count = 0;
		boolean reachedMax = false;
		for (int i = 0; i < bevList.size(); i++) {
			if (bevList.get(i).getType().equals(TYPE.ALCOHOL)) {
				count++;
				if (count == MAX_ALCOHOL_DRINKS)
					reachedMax = true;
			}
		}
		return reachedMax;
	}

	/**
	 * check the valid age for the alcohol drink
	 * 
	 * @param age the age
	 * @return returns true if age is more than minimum eligible age , false
	 *         otherwise
	 */
	public boolean validAge(int age) {

		if (age >= MINIMUM_AGE)
			return true;
		else
			return false;
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

		// create/ start new order
		newOrder = new Order(time, day, new Customer(customerName, customerAge));

		// add to list
		orderList.add(newOrder);

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

		newOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);

	}

	/**
	 * process the Alcohol order for the current order by adding it to the current
	 * order
	 * 
	 * @param bevName beverage name
	 * @param size    beverage size
	 */
	public void processAlcoholOrder(String bevName, SIZE size) {

		newOrder.addNewBeverage(bevName, size);
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

		newOrder.addNewBeverage(bevName, size, numOfFruits, addProtien);
	}

	/**
	 * locate an order based on the order number
	 * 
	 * @param orderNo the order number
	 * @return the index of the order in the list of Orders if found or -1 if not
	 *         found
	 */

	public int findOrder(int orderNo) {

		int found = 0;
		for (int i = 0; i < orderList.size(); i++) {
			if (orderList.get(i).getOrderNo() == orderNo)
				found = i;
			else
				found = -1;
		}
		return found;

	}

	/**
	 * locates an order in the list of orders and returns the total value on the
	 * order.
	 * 
	 * @param orderNo the order number
	 * @returns the calculated price on this order.
	 */
	public double totalOrderPrice(int orderNo) {

		double total = 0;

		for (int i = 1; i < orderList.size(); i++) {
			if (orderList.get(i).getOrderNo() == orderNo) {
				total += newOrder.calcOrderTotal();
			}
		}
		return total;
	}

	/**
	 * Calculates the total sale of all the orders for this beverage shop
	 * 
	 * @return the total sale of all the orders
	 */
	public double totalMonthlySale() {
		double total = 0;

		for (int i = 0; i < orderList.size(); i++) {
			total += totalOrderPrice(i);
		}

		return total;
	}

	/**
	 * sorts the orders within this bevShop using the Selection sort algorithm
	 */
	public void sortOrders() {

		for (int i = 1; i < orderList.size(); i++) {

			double highestOrderTotal = totalOrderPrice(0); // highest total in order lists
			int highestOrderIndex = 0; // index of highest order

			if (totalOrderPrice(i) > highestOrderTotal) {
				highestOrderTotal = totalOrderPrice(i);
				highestOrderIndex = i;
			}
		}

		// sorted order array
		for (int i = 0; i < orderList.size(); i++) {
			System.out.println(orderList.get(i));
		}
	}

	/**
	 * returns Order in the list of orders at the index Notes: this method returns
	 * the shallow copy of the order
	 * 
	 * @return Order in the list of orders at the index
	 */
	public Order getOrderAtIndex(int index) {

		int i = 0;

		for (i = 0; i < orderList.size(); i++) {
			if (index == i) {
				orderList.get(index).equals(orderList.get(i));
			}
		}
		return orderList.get(i);
	}

	@Override
	/**
	 * print sorted orders and monthly salary
	 */
	public String toString() {

		String str = "Orders: \n" + totalMonthlySale() + "\n";

		return str + " Monthly Sales: " + totalMonthlySale();
	}

	/**
	 * 
	 * @return max order for alcohol drinks
	 */
	public int getMaxOrderForAlcohol() {

		return MAX_ALCOHOL_DRINKS;
	}

	/**
	 * Check minimum age
	 * 
	 * @return minimum age to drink
	 */
	public int getMinAgeForAlcohol() {

		return MINIMUM_AGE;
	}

	public Order getCurrentOrder() {
		return new Order(newOrder);
	}

	public boolean isMaxFruit(int numOfFruits) {

		boolean maxNum = false; // if num of fruits are more than MAX_FRUIT

		if (numOfFruits == MAX_FRUIT)
			maxNum = true;
		return maxNum;
	}

	/**
	 * total number of monthly orders
	 * 
	 * @return size of order list
	 */
	public double totalNumOfMonthlyOrders() {
		double total = 0;

		for (int i = 0; i < orderList.size(); i++) {
			total += totalOrderPrice(i);
		}

		return total;
	}

}
