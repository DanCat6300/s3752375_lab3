import java.util.ArrayList;

public class CustomerList implements iterator{
	private ArrayList<Customer> theList;
	
	public CustomerList() {
		this.theList = new ArrayList<Customer>();
	}
	
	public ArrayList<Customer> getList() {
		return this.theList;
	}
	
	public Customer getCustomer(String id) {
		for (int i = 0; i < this.theList.size(); i++) {
			Customer temp = this.theList.get(i);
			if (temp.getID().equals(id))
				return temp;
		}
		System.out.println("Customer " + id + " not found");
		return null;
	}
	
	public boolean addCustomer(Customer cust) {
		for (int i = 0; i < this.theList.size(); i++) {
			Customer temp = this.theList.get(i);
			if (temp.getID().equals(cust.getID()))
				return false;
		}
		this.theList.add(cust);
		return true;
	}

	int currentCustomer = 0;
	@Override
	public boolean hasNext() {
		if (currentCustomer >= theList.size()) {
			currentCustomer = 0;
			return false;
		}
		return true;
	}

	@Override
	public Object next() {
		return theList.get(currentCustomer++);
	}
}
