// declaring package
package nz.ac.auckland.se281.a2;

import java.util.ArrayList;

//class declaration. This class will contain all the helper methods for printing cart
public abstract class CartHelperMethods {

	public static void printEachItem(ArrayList<Item> cart) {
		// iterating through and printing each item in cart
		for (int i = 0; i < cart.size(); i++) {

			// getting each item from cart
			Item item = cart.get(i);

			// printing cart ID i, and name
			System.out.print(i + " - " + item.getName());

			// checks if item is a snack or drink
			if (item instanceof Extras) {
				// downcasting item to Extras
				Extras downcastedItem = (Extras) item;

				// prints size
				System.out.print(" (" + downcastedItem.getSize() + ")");
			}

			// prints price
			System.out.println(": $" + String.format("%.02f", item.getPrice()));
		}
	}

	public static void getTotal() {

	}
}
