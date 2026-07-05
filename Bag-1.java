package criticalThinking;

import java.util.ArrayList;

public class Bag<T> {

	//Initialize ArrayList
	private ArrayList<T> bagItems;
	
	//Constructor to create the object
	public Bag() {
		bagItems = new ArrayList<>();
	}
	
	//add items to the bag
	public void add(T item) {
		bagItems.add(item);
	}
	
	//remove items from the bag
	public void remove(T item) {
		bagItems.remove(item);
	}
	
	//check whether bag contains items
	public boolean contains(T item) {
		return bagItems.contains(item);
	}
	
	//implement count
	public int count(T item) {
		int count = 0;
		
		for (int i = 0; i < bagItems.size(); i++) {
			if (bagItems.get(i).equals(item)) {
				count++;
			}
		}
		return count;
		
	}
	
	//return the total number of items in the bag
	public int size() {
		return bagItems.size();
	}
	
	//merge the bags
	public void merge(Bag<T> otherBag) {
		int i = 0;
		
		for (i = 0; i < otherBag.bagItems.size(); i++) {
			bagItems.add(otherBag.bagItems.get(i));
		}
	}
	
	//create a distinct method
	public Bag<T> distinct() {
		//create distinctBag
		Bag<T> distinctBag = new Bag<>();
	
		int i = 0;
	
		for (i = 0; i < bagItems.size(); i++) {
			if (!distinctBag.contains(bagItems.get(i))) { //checks that item is NOT in distinctBag
				distinctBag.add(bagItems.get(i)); //add item to the bag
			}
		}
		return distinctBag;
	}
	
	//print the bag contents
	public String toString() {
		return bagItems.toString();
	}
}
