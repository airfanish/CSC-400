package criticalThinking;

public class Main {

	public static void main(String[] args) {
		
		//create a bag object
		Bag<String> bagItems = new Bag<>();
		
		//create a second bag object
		Bag<String> bagItems2 = new Bag<>();
		
		//Call the add method on object
		bagItems.add("apple");
		bagItems.add("banana");
		bagItems.add("plum");
		bagItems.add("orange");
		bagItems.add("banana");
		bagItems.add("banana");
		bagItems.add("cilantro");
		bagItems.add("parsley");
		bagItems.add("walnuts");
		bagItems.add("cashews");
		bagItems.add("cilantro");
		bagItems.add("milk");
		bagItems.add("butter");
		bagItems.add("butter");
		
		//print first bag's contents
		System.out.println("Bag 1 Contents: " + bagItems.toString());
		
		//test the contain method & display results
		System.out.println("Contains banana: " + bagItems.contains("banana"));
				
		//test the count method
		System.out.println("Banana count: " + bagItems.count("banana"));
				
		//test removing an item from the bag and display updated results
		bagItems.remove("cilantro");
		System.out.println("Quantity of 1 cilantro has been removed from contents.");
		System.out.println("Bag contents: " + bagItems.toString());
		System.out.println("Contains cilantro: " + bagItems.contains("cilantro"));
		System.out.println("Cilantro count: " + bagItems.count("cilantro"));
		
		//add items to second bag
		bagItems2.add("eggs");
		bagItems2.add("eggs");
		bagItems2.add("eggs");
		bagItems2.add("eggs");
		bagItems2.add("flour");
		bagItems2.add("baking soda");
		bagItems2.add("milk");
		bagItems2.add("milk");

		//print second bag's contents
		System.out.println("Bag 2 Contents: " + bagItems2.toString());
		
		//print size of each bag
		System.out.println("Size of Bag 1: " + bagItems.size());
		System.out.println("Size of Bag 2: " + bagItems2.size());

		//merge bags
		bagItems.merge(bagItems2);
		
		
		//print contents of the merged bags
		System.out.println("Merged Bag Contents: " + bagItems.toString());
		
		//create a distinctBag
		Bag<String> distinctBag = bagItems.distinct();
		System.out.println("Distinct Bag Contents: " + distinctBag.toString());

		
		

		
		
		
	}

	
}
