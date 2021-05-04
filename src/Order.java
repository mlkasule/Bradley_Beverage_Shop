import java.util.ArrayList;

public class Order implements OrderInterface, Comparable {

	private int orderNumber;
	private int orderTime;
	private DAY orderDay;
	private String customer;
	private int customerAge;
	private Customer custObj;
	private ArrayList<Beverage> bevList; // list of beverages

	public Order(int orderNumber, int orderTime, DAY orderDay, String customer, int customerAge) {

		this.orderNumber = orderNumber;
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = customer;
		this.customerAge = customerAge;
		this.bevList = new ArrayList<>();
	}

	public Order(int orderTime, DAY orderDay, Customer customer) {

		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.custObj = customer;
		this.customer = customer.getName();
		this.customerAge = customer.getAge();
		this.bevList = new ArrayList<>();
	}

	public Order(Order orderList) {

		this.orderNumber = orderList.orderNumber;
		this.orderTime = orderList.orderTime;
		this.orderDay = orderList.orderDay;
		this.customer = orderList.customer;
		this.customerAge = orderList.customerAge;
		this.bevList = orderList.bevList;
		this.custObj = orderList.custObj;
	}

	public int getOrderNo() {
		return orderNumber;
	}

	public void setOrderNo(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}

	public DAY getOrderDay() {
		return orderDay;
	}

	public void setOrderDay(DAY orderDay) {
		this.orderDay = orderDay;
	}

	public Customer getCustomer() {
		return new Customer(custObj);
	}

	public void setCustomerObj(Customer customerObj) {
		this.custObj = new Customer(customerObj);
	}

	public void setCustomerName(String customer) {
		this.customer = customer;
	}

	public String getCustomerName() {
		return customer;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public ArrayList<Beverage> getBevList() {

		for (int i = 0; i < bevList.size(); i++) {
			bevList.get(i);
		}

		return bevList;
	}

	public void setBevList(ArrayList<Beverage> bevList) {
		this.bevList = bevList;
	}

	/**
	 * generates random number
	 * 
	 * @return random number
	 */
	public int getRandomNum() {
		return (int) (10000 + Math.random() * (90000 - 10000) + 1);
	}

	/**
	 * adds coffee order to this order
	 * 
	 * @param bevName    beverage name
	 * @param size       beverage size of type SIZE
	 * @param extraShot  true if the coffee beverage has extra shot , false
	 *                   otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false
	 *                   otherwise
	 */
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		
		//new coffee order
		Coffee newCoffee = new Coffee(bevName, size, extraShot, extraSyrup);
		//add to bev list
		bevList.add(newCoffee);

		// use for loop to add , set idex

	}

	/**
	 * adds alcohol order to this order
	 * 
	 * @param bevName beverage name
	 * @param size    beverage size
	 */
	public void addNewBeverage(String bevName, SIZE size) {

		// new alcohol order
		Alcohol newAlcohol = new Alcohol(bevName, size, false);
		// add to bev list
		bevList.add(newAlcohol);

	}

	/**
	 * Adds the Smoothie beverage to this order
	 * 
	 * @param bevName     beverage name
	 * @param size        beverage size
	 * @param numOfFruits number of fruits added
	 * @param addPRotien  true if protein is added, false otherwise
	 */
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addProtien) {

		// new smoothie order
		Smoothie newSmoothie = new Smoothie(bevName, size, numOfFruits, addProtien);

		// add to bev list
		bevList.add(newSmoothie);
	}

	/**
	 * Calculates and returns the total amount for this order
	 * 
	 * @return total amount for this order
	 */
	public double calcOrderTotal() {
		double total = 0;

		for (int i = 0; i < bevList.size(); i++) {
			total += bevList.get(i).calcPrice();
		}
		return total;
	}

	/**
	 * returns the number of beverages of same type in an order
	 * 
	 * @param type the type of the beverage
	 * @return number of beverages of type type in this order
	 */
	public int findNumOfBeveType(TYPE type) {

		int count = 0;

		for (int i = 0; i < bevList.size(); i++) {
			if (bevList.get(i).getType().equals(type)) {
				count++;
			}
		}
		return count;
	}

	/**
	 * compares similarity of order numbers
	 * 
	 * @param orderNumber
	 * @return status
	 */
	public int compareTo(Order orderNumber) {
		int status = -2;

		if (orderNumber.equals(getOrderNo()))
			status = 0;
		else if ((Integer.parseInt(String.valueOf(orderNumber))) > getOrderNo())
			status = 1;
		else if ((Integer.parseInt(String.valueOf(orderNumber))) < getOrderNo())
			status = -1;
		return status;
	}

	@Override
	public String toString() {
		String str = "Order Number: " + getOrderNo() + "\nOrder time: " + getOrderTime() + "\nOrder day: "
				+ getOrderDay() + "\nCustomer name: " + getCustomer() + " Age: " + getCustomerAge() + "\nBeverages: "
				+ getBevList();
		return str;

	}

	@Override
	public boolean isWeekend() {
		if (getOrderDay().equals(DAY.SATURDAY))
			return true;
		else
			return false;
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		// beverage at itemNo
		bevList.get(itemNo);

		for (int i = 0; i < bevList.size(); i++) {
			if (i == itemNo) {
				bevList.get(itemNo);
			}
		}
		return bevList.get(itemNo);
	}

	public int getTotalItems() {

		return bevList.size();
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}

}
