
public class Bacon extends McDs{
	private double cost = 2.00; //cost of adding toppings
	//constructor
	public Bacon(Burger superfly) {
		super(superfly);
		// TODO Auto-generated constructor stub
	}
	//method to add Bacon cost
	private double addBacon() {
		System.out.println(" + Bacon $2.00");
		return cost;
	}
	//method to return the added Bacon to the burger
	@Override
	public double makeBurger() {
		// TODO Auto-generated method stub
		return superfly.makeBurger() + addBacon();
	}
	
}
