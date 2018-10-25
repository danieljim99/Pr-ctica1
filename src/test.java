import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test {

	@Test
	void test() {
		Category cat = new Category("Category1", false);
		Product pro = new Product("Product1", 1, 5, 4f, false);
		assertEquals(cat.getName(), "Category1");
		assertEquals(cat.getId(), 1);
		assertEquals(pro.getName(), "Product1");
		assertEquals(pro.getId(), 1);
		assertEquals(pro.getPrice(), 4f);
		assertEquals(pro.getStock(), 5);
		assertEquals(pro.getCategoryId(), 1);
	}

}
