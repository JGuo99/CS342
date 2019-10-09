
public class GrilledOnions extends McDs {
	private double cost = 2.00; //cost of adding toppings
	//Constructor
	public GrilledOnions(Burger superfly) {
		super(superfly);
		// TODO Auto-generated constructor stub
	}
	//method to add Grilled Onions cost
	private double addOnion() {
		System.out.println(" + Grilled Onions $2.00");
		return cost;
	}
	//method to return the added Grilled Onions to the burger
	public double makeBurger() {
		return superfly.makeBurger() + addOnion();
	}
}
