import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class test {
	@Test
	void testCategory() {
		Category cat = new Category("Category1", false);
		assertEquals(cat.getName(), "Category1");
		assertEquals(cat.getId(), 2);
	}
	
	@Test
	void testProduct() {
		Product pro = new Product("Product1", 1, 5, 4f, false);
		assertEquals(pro.getName(), "Product1");
		assertEquals(pro.getId(), 1);
		assertEquals(pro.getPrice(), 4f);
		assertEquals(pro.getStock(), 5);
		assertEquals(pro.getCategoryId(), 1);
	}
	
	@Test
	void testUser() {
		User us = new User("danijim99", Ui.hash("qwerty1234"), false);
		assertEquals(us.getUsername(), "danijim99");
		assertEquals(us.getPassword(), Ui.hash("qwerty1234"));
	}

}
