
public class FriedEgg extends McDs{
	private double cost = 2.00; //cost of adding toppings
	//constructor
	public FriedEgg(Burger superfly) {
		super(superfly);
		// TODO Auto-generated constructor stub
	}
	//method to add FriedEgg cost
	private double addFriedEgg() {
		System.out.println(" + Fried Egg $2.00");
		return cost;
	}
	//method to return the added Fried Egg to the burger
	public double makeBurger() {
		return superfly.makeBurger() + addFriedEgg();
	}
	
}
