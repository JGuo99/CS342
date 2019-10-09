
public class RoastedPeppers extends McDs {
	private double cost = 2.00; //cost of adding toppings
	//Constructor
	public RoastedPeppers(Burger superfly) {
		super(superfly);
		// TODO Auto-generated constructor stub
	}
	//method to add Roasted Peppers cost
	private double addPeppers() {
		System.out.println(" + Roasted Peppers $2.00");
		return cost;
	}
	//method to return the added Roasted Peppers to the burger
	public double makeBurger() {
		return superfly.makeBurger() + addPeppers();
	}
}
