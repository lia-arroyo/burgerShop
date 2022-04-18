// declaring package
package nz.ac.auckland.se281.a2;

// class declaration
public abstract class Item {

	// instance fields
	protected String name;
	protected float price;

	// constructor
	public Item(String name, float price) {
		this.name = name;
		this.price = price;
	}

	// getter and setter methods for current fields
	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
