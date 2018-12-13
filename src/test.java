import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class test extends LanguageManager{
	@Test
	void testCategory() {
		Category cat = new Category("Category1", false);
		assertEquals(cat.getName(), "Category1");
		assertEquals(cat.getId(), 2);
		assertEquals(Category.searchCategory("Category1"), cat);
		Category.renameCategory("Category1", "NewCategoryName");
		assertEquals(Category.searchCategory("NewCategoryName"), cat);
		assertEquals(Category.printCategories(), 0);
		assertEquals(cat.printProducts(), 0);
		assertEquals(cat.setName("Category1"), 0);
		assertEquals(cat.setId(1), 0);
		assertEquals(Category.removeCategory(5), 0);
		assertEquals(Category.storageTree(), 0);
		assertEquals(Category.renameCategory("Categoriess", "Pepe"), 0);
	}
	
	@Test
	void testProduct() {
		Product pro = new Product("Product1", 1, 5, 4f, false);
		assertEquals(pro.getName(), "Product1");
		assertEquals(pro.getId(), 1);
		assertEquals(pro.getPrice(), 4f);
		assertEquals(pro.getStock(), 5);
		assertEquals(pro.getCategoryId(), 1);
		assertEquals(Category.searchProduct("Product1"), pro);
		assertEquals(pro.information(), 0);
		assertEquals(Product.removeProduct(5), 0);
		assertEquals(pro.addStock(), 0);
		assertEquals(pro.removeStock(), 0);
	}
	
	@Test
	void testUser() {
		User us = new User("danijim99", Ui.hash("qwerty1234"), false);
		assertEquals(us.getUsername(), "danijim99");
		assertEquals(us.getPassword(), Ui.hash("qwerty1234"));
		assertEquals(User.searchUser("danijim99"), us);
		User.loggeduser = us;
		assertEquals(us.addProductCart("Product1", true), 0);
		assertEquals(us.searchProductCart("Product1"), 0);
		assertEquals(us.showCart(), 0);
		assertEquals(us.removeProductCart("Product1"), 0);
		assertEquals(us.setUsername("danijim99"), 0);
		assertEquals(us.setPassword(Ui.hash("qwerty1234")), 0);
	}

	@Test
	void testBackUp() {
		assertEquals(BackUp.rebootAll(), 0);
		assertEquals(BackUp.rebootCartList(), 0);
		assertEquals(BackUp.rebootCategoryList(), 0);
		assertEquals(BackUp.rebootProductList(), 0);
		assertEquals(BackUp.rebootUserList(), 0);
		assertEquals(BackUp.updateAll(), 0);
		assertEquals(BackUp.updateCartList(), 0);
		assertEquals(BackUp.updateCategoryList(), 0);
		assertEquals(BackUp.updateProductList(), 0);
		assertEquals(BackUp.rebootUserList(), 0);
	}
	
	@Test 
	void testLanguageManager() {
		assertEquals(setLanguageEnglish(), 0);
		assertEquals(setLanguageSpanish(), 0);
	}
	
	@Test
	void testUi() {
		assertEquals(Ui.getIntOf("1"), 1);
		assertEquals(Ui.getFloatOf("1.4"), 1.4f);
	}
}
