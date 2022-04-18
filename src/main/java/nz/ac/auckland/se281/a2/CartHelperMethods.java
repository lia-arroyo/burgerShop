// declaring package
package nz.ac.auckland.se281.a2;

// imports
import java.util.ArrayList;

import nz.ac.auckland.se281.a2.cli.MessagesCLI;

// This class will contain all the helper methods for printing cart
public abstract class CartHelperMethods {

	// printing each item in given cart
	public static void printEachItem(ArrayList<Item> cart) {

		// iterating through cart
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

	// Calculates the total price of a cart
	public static float getTotalPrice(ArrayList<Item> cart) {

		// initialising counter for current total
		float total = 0;

		// iterating through cart
		for (int i = 0; i < cart.size(); i++) {

			// getting each item from cart
			Item item = cart.get(i);

			total += item.getPrice();
		}

		// checking if cart total is eligible for discount
		if (total >= 100.00) {

			// informs user that they're eligible
			MessagesCLI.DISCOUNT.printMessage();

			// applying discount
			total *= 0.75;
		}

		return total;
	}

	// Prints the total price of a cart
	public static void printTotalPrice(ArrayList<Item> cart) {

		// getting total price for order
		float totalPrice = getTotalPrice(cart);

		// printing total price
		System.out.println("Total: $" + String.format("%.02f", totalPrice));
	}

	// Checking if a potential combo is available but not taken up
	public static boolean potentialCombo(ArrayList<Item> cart) {

		// boolean for if there is at least a burger
		boolean isBurger = false;

		// boolean for if there is a snack and drink of same size
		boolean sameSize = false;

		// iterating through each item in the cart
		for (Item item : cart) {

			// checking there is at least one burger
			if (item instanceof Burger) {

				isBurger = true;

			} else if (item instanceof Snack) {

				// downcasting to snack
				Snack snack = (Snack) item;

				// iterate through cart again to compare to current snack
				for (Item otherItem : cart) {

					// compares snack against every other drink, and checking for same size
					if (otherItem instanceof Drink && (((Drink) otherItem).getSize() == snack.getSize())) {
						sameSize = true;
					}
				}
			}
		}

		return isBurger && sameSize;
	}
}
