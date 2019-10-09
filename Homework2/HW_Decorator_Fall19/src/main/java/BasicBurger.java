
public class BasicBurger implements Burger {
	private double cost = 6.50;
	@Override
	public double makeBurger() {
		// TODO Auto-generated method stub
		System.out.println("Basic Cheeseburger: $6.50");
		return cost;
	}

}
