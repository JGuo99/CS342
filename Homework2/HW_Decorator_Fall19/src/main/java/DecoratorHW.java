
public class DecoratorHW {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Burger order = new Avocado(new FriedEgg(new GrilledOnions(new BasicBurger())));
		double cost = order.makeBurger();
		System.out.println("Total: $" +cost);
	}

}
