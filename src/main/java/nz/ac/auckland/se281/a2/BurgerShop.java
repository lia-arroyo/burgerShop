// declaring package
package nz.ac.auckland.se281.a2;

// imports
import java.util.ArrayList;

import nz.ac.auckland.se281.a2.cli.Menu.SIZE;
import nz.ac.auckland.se281.a2.cli.MessagesCLI;

// class declaration
public class BurgerShop {

	// instance fields
	private ArrayList<Item> cart = new ArrayList<Item>(); // keeps track of all items ordered

	// constructors
	public BurgerShop() {

	}

	// methods
	/**
	 * Add a burger in the cart
	 * 
	 * @param name
	 * @param price
	 */
	public void addBurger(String name, float price) {
		// TODO TASK1

		// creating a new Burger instance
		Burger burger = new Burger(name, price);

		// adding burger instance to cart
		cart.add(burger);
	}

	/**
	 * add a snack in the cart, if size is L the price should be incremented by $3
	 * if the size is XL the price should be incremented by $4 (@see
	 * nz.ac.auckland.se281.a2.cli.Menu.SIZE)
	 * 
	 * 
	 * @param name
	 * @param price
	 * @param size
	 */
	public void addSnack(String name, float price, SIZE size) {
		// TODO TASK1

		// creating a new Snack instance
		Snack snack = new Snack(name, price, size);

		// adding snack to cart
		cart.add(snack);
	}

	/**
	 * 
	 * add a drink in the cart
	 * 
	 * if size is L the price should be incremented by $3 if the size is XL the
	 * price should be incremented by $4 (@see
	 * nz.ac.auckland.se281.a2.cli.Menu.SIZE)
	 * 
	 *
	 * @param name
	 * @param price
	 * @param size
	 */
	public void addDrink(String name, float price, SIZE size) {
		// TODO TASK1

		// creating a new Drink instance
		Drink drink = new Drink(name, price, size);

		// adding drink to cart
		cart.add(drink);

	}

	/**
	 * print the content of the cart, or print MessagesCLI.CART_EMPTY if the cart is
	 * empty
	 *
	 *
	 */
	public void showCart() {
		// TODO TASK1

		// checking the cart is empty
		if (cart.isEmpty()) {

			MessagesCLI.CART_EMPTY.printMessage();

		} else {

			// printing each item in cart
			CartHelperMethods.printEachItem(cart);

			// printing the total
			CartHelperMethods.printTotalPrice(cart);

		}
	}

	/**
	 * add a combo in the cart.
	 * 
	 * The price of a combo is the sum of all the items, but the drink would be half
	 * price. Note that in a combo, both snacks and drinks have the same size, and
	 * the combo price must consider the size (@see addSnack and addDrink methods).
	 * 
	 * @param nameBurger
	 * @param priceBurger
	 * @param nameSnack
	 * @param priceSnack
	 * @param nameDrink
	 * @param priceDrink
	 * @param size
	 */
	public void addCombo(String nameBurger, float priceBurger, String nameSnack, float priceSnack, String nameDrink,
			float priceDrink, SIZE size) {
		// TODO TASK2

		// creating new Burger instance
		Burger comboBurger = new Burger(nameBurger, priceBurger);

		// creating new Snack instance
		Snack comboSnack = new Snack(nameSnack, priceSnack, size);

		// creating new Drink instance
		Drink comboDrink = new Drink(nameDrink, priceDrink, size);

		// creating a new Combo instance with the above
		Combo combo = new Combo(comboBurger, comboSnack, comboDrink);

		cart.add(combo);

	}

	/**
	 * remove the item in the cart specified by the position posCart. Note that the
	 * position of the cart start from zero. if postCart is invalid: posCart < 0 OR
	 * posCart >= size of the cart the method prints
	 * MessagesCLI.NOT_VALID_CART_POSITION
	 * 
	 * @param posCart
	 */
	public void removeItem(int posCart) {
		// TODO TASK3

		// prints error if posCart is invalid
		if (posCart < 0 || posCart >= cart.size()) {
			MessagesCLI.NOT_VALID_CART_POSITION.printMessage();
		} else {
			// removes the item in posCart position
			cart.remove(posCart);
		}
	}

	/**
	 * removes all elements in the cart
	 */
	public void clearCart() {
		// TODO TASK3

		// removing all elements in cart
		cart.clear();
	}

	/**
	 * This method confirms the order, showing the estimated pick up time. It also
	 * give a warning if there are missing opportunities for COMBO menus
	 * 
	 */
	public void confirmOrder() {
		// TODO TASK4

		// printing error if cart is empty
		if (cart.isEmpty()) {

			MessagesCLI.ORDER_INVALID_CART_EMPTY.printMessage();

		} else if (CartHelperMethods.potentialCombo(cart)) {

			// prints warning for potential missed combos
			MessagesCLI.MISSED_COMBO.printMessage();

		} else { // if order doesn't contain potential missed combos

			// print cart
			showCart();

			// getting total waiting time in seconds.
			int totalSeconds = CartHelperMethods.waitingTime(cart);

			// converting to hours, mins, and seconds.
			// code adapted from https://stackoverflow.com/a/6118983
			int hours = totalSeconds / 3600;
			int mins = (totalSeconds % 3600) / 60;
			int seconds = totalSeconds % 60;

			// printing order confirmed and estimated waiting time
			System.out.println(MessagesCLI.ESTIMATE_WAITING_TIME.getMessage() + hours + " hours " + mins + " minutes "
					+ seconds + " seconds");

			// Emptying cart
			clearCart();
		}
	}
}
