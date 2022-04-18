// declaring package
package nz.ac.auckland.se281.a2;

// importing sizes
import nz.ac.auckland.se281.a2.cli.Menu.SIZE;

// class declaration. 'Extras' refers to Snacks and Drinks
public abstract class Extras extends Item {

	// instance fields
	protected SIZE size;

	// constructor that calls on Item's constructor
	public Extras(String name, float mediumPrice, SIZE size) {
		super(name, correctPrice(mediumPrice, size));
		this.size = size;
	}

	// methods

	// getter method for size
	public SIZE getSize() {
		return this.size;
	}

	// returns the correct price of size or drink depending on size
	public static float correctPrice(float mediumPrice, SIZE size) {
		switch (size) {

		case XL:
			return mediumPrice + 4;

		case L:
			return mediumPrice + 3;

		default: // if size is M
			return mediumPrice;

		}
	}

}
