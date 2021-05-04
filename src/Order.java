import java.util.ArrayList;

public class Order implements OrderInterface, Comparable {

	private int orderNumber;
	private int orderTime;
	private DAY orderDay;
	private String customer;
	private int customerAge;
	private Customer custObj;
	private ArrayList<Beverage> bevList; // list of beverages

	public Order(int orderNumber, int orderTime, DAY orderDay, String customer, int customerAge,
			ArrayList<Beverage> bevList) {

		this.orderNumber = orderNumber;
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = customer;
		this.customerAge = customerAge;
		this.bevList = bevList;
	}

	public Order(int orderTime, DAY orderDay, String customer, int customerAge, ArrayList<Beverage> bevList) {

		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = customer;
		this.customerAge = customerAge;
		this.bevList = bevList;
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

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
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

		Coffee newCoffee = new Coffee(bevName, size, extraShot, extraSyrup);
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

		Alcohol newAlcohol = new Alcohol(bevName, size, false);
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

		Smoothie newSmothie = new Smoothie(bevName, size, numOfFruits, addProtien);
		bevList.add(newSmothie);
		
		for(int i = 0; i < bevList.size(); i++) {
			bevList.add(newSmothie);
		}
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

		if (orderNumber.equals(getOrderNumber()))
			status = 0;
		else if ((Integer.parseInt(String.valueOf(orderNumber))) > getOrderNumber())
			status = 1;
		else if ((Integer.parseInt(String.valueOf(orderNumber))) < getOrderNumber())
			status = -1;
		return status;
	}

	@Override
	public String toString() {
		String str = "Order Number: " + getOrderNumber() + "\nOrder time: " + getOrderTime() + "\nOrder day: "
				+ getOrderDay() + "\nCustomer name: " + getCustomer() + " Age: " + getCustomerAge() + "\nBeverages: "
				+ getBevList();
		return str;

	}

	@Override
	public boolean isWeekend() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
