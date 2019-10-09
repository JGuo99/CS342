//Abstract Decorator class 
public abstract class McDs implements Burger {
	protected Burger superfly;
	
	public McDs(Burger superfly) {
		this.superfly = superfly;
	}
}
