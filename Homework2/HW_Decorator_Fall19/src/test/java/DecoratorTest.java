import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DecoratorTest {

	@Test
	void addAvocadotest() {
		Burger order = new Avocado(new BasicBurger());
		assertEquals(8.5, order.makeBurger(), "Test Failed: Basic Cheeseburger + Avocado: $8.50");
	}
	@Test
	void addBacontest() {
		Burger order = new Bacon(new BasicBurger());
		assertEquals(8.5, order.makeBurger(), "Test Failed: Basic Cheeseburger + Bacon: $8.50");
	}
	@Test
	void addFriedEggtest() {
		Burger order = new FriedEgg(new BasicBurger());
		assertEquals(8.5, order.makeBurger(), "Test Failed: Basic Cheeseburger + Fried Egg: $8.50");
	}
	@Test
	void addGrilledOnionstest() {
		Burger order = new GrilledOnions(new BasicBurger());
		assertEquals(8.5, order.makeBurger(), "Test Failed: Basic Cheeseburger + GrilledOnions: $8.50");
	}
	@Test
	void addRoastedPepperstest() {
		Burger order = new RoastedPeppers(new BasicBurger());
		assertEquals(8.5, order.makeBurger(), "Test Failed: Basic Cheeseburger + Roasted Peppers: $8.50");
	}
	@Test
	void NothingButBasic() {
		Burger order = new BasicBurger();
		assertEquals(6.5, order.makeBurger(), "Test Failed: Basic Cheeseburger: $6.50");
	}
	@Test
	void NothingButAvocado() {
		Burger order = new Avocado(new Avocado(new Avocado(new Avocado(new BasicBurger()))));
		assertEquals(14.5, order.makeBurger(), "Test Failed: Basic Burger + 4*Avocado: $14.50");
	}
	@Test
	void NothingButBacon(){
		Burger order = new Bacon(new Bacon(new Bacon(new Bacon(new BasicBurger()))));
		assertEquals(14.5, order.makeBurger(), "Test Failed: Basic Burger + 4*Bacon: $14.50");
	}
	@Test
	void NothingButFriedEgg(){
		Burger order = new FriedEgg(new FriedEgg(new FriedEgg(new FriedEgg(new BasicBurger()))));
		assertEquals(14.5, order.makeBurger(), "Test Failed: Basic Burger + 4*Fried Egg: $14.50");
	}
	@Test
	void NothingButGrilledOnions(){
		Burger order = new GrilledOnions(new GrilledOnions(new GrilledOnions(new GrilledOnions(new BasicBurger()))));
		assertEquals(14.5, order.makeBurger(), "Test Failed: Basic Burger + 4*Grilled Onions: $14.50");
	}
	@Test
	void NothingButRoastedPeppers(){
		Burger order = new RoastedPeppers(new RoastedPeppers(new RoastedPeppers(new RoastedPeppers(new BasicBurger()))));
		assertEquals(14.5, order.makeBurger(), "Test Failed: Basic Burger + 4*Roasted Peppers: $14.50");
	}
}
