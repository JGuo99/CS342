
public class Avocado extends McDs{
	private double cost = 2.00; //cost of adding toppings
	//constructor
	public Avocado(Burger superfly) {
		super(superfly);
	}
	//method to add Avocado cost
	private double addAvocado() {
		System.out.println(" + Avocado $2.00");
		return cost;
	}
	//method to return the added avocado to the burger
	public double makeBurger() {
		return superfly.makeBurger() + addAvocado();
	}
}
