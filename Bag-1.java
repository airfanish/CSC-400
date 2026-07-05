package criticalThinking;

import java.util.ArrayList;

/**
 * A generic Bag class that stores objects using an ArrayList.
 * Supports adding, removing, counting, merging, and retrieving distinct items.
 */
public class Bag<T> {

	//Initialize ArrayList
	private ArrayList<T> bagItems;
	
	/**
 	* Constructs an empty Bag.
 	*/
	public Bag() {
		bagItems = new ArrayList<>();
	}

	/**
 	* Adds an item to the bag if it is not null.
 	*
 	* @param item the item to add to the bag
 	*/
	public void add(T item) {
		if (item != null) {
			bagItems.add(item);
	}
		else {
			System.out.println("Null values cannot be added to the bag.");
		}
	
	/**
 	* Removes an item from the bag.
 	*
 	* @param item the item to remove
 	*/
	public void remove(T item) {
		bagItems.remove(item);
	}
	
	/**
 	* Checks whether the bag contains the specified item.
 	*
 	* @param item the item to search for
 	* @return true if the item is found; otherwise false
 	*/
	public boolean contains(T item) {
		return bagItems.contains(item);
	}
	
	/**
 	* Counts the number of occurrences of an item in the bag.
 	*
 	* @param item the item to count
 	* @return the number of times the item appears
 	*/
	public int count(T item) {
		int count = 0;
		
		for (int i = 0; i < bagItems.size(); i++) {
			if (bagItems.get(i).equals(item)) {
				count++;
			}
		}
		return count;
		
	}
	
	/**
 	* Returns the total number of items in the bag.
 	*
 	* @return the size of the bag
 	*/
	public int size() {
		return bagItems.size();
	}
	
	/**
 	* Merges another bag into this bag.
 	*
 	* @param otherBag the bag to merge
 	*/
	public void merge(Bag<T> otherBag) {
		int i = 0;
		
		for (i = 0; i < otherBag.bagItems.size(); i++) {
			bagItems.add(otherBag.bagItems.get(i));
		}
	}
	
	/**
 	* Creates a new bag containing only distinct items.
 	*
 	* @return a bag containing unique items
 	*/
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
	
	/**
 	* Returns the contents of the bag as a string.
 	*
 	* @return the bag contents
 	*/
	public String toString() {
		return bagItems.toString();
	}
}
