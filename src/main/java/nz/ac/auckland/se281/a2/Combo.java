// Declaring package
package nz.ac.auckland.se281.a2;

// Class declaration
public class Combo extends Item {

	public Combo(Burger burger, Snack snack, Drink drink) {

		// calling item constructor with updated combo name and price
		super(getComboName(burger, snack, drink), getComboPrice(burger, snack, drink));

	}

	// static methods

	// Combines burger, snack, and drink names into one string
	public static String getComboName(Burger burger, Snack snack, Drink drink) {

		// getting burger name
		String burgerName = burger.getName();

		// getting snack name
		String snackName = snack.getName();

		// getting drink name
		String drinkName = drink.getName();

		// adding all strings together, in format required for cart
		return "COMBO : (" + burgerName + ", " + snackName + " (" + snack.getSize() + "), " + drinkName + " ("
				+ drink.getSize() + "))";
	}

	// Gets total price of combo, with sizes accounted for and drink is half priced
	public static float getComboPrice(Burger burger, Snack snack, Drink drink) {

		// Snack and drink prices already account for size pricing.

		// Halving drink price
		float halfDrinkPrice = drink.getPrice() / 2;

		// adding all three prices
		return burger.getPrice() + snack.getPrice() + halfDrinkPrice;

	}

}
