package stepdefinition;

import org.openqa.selenium.WebDriver;
import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageobjects.ShoppingCartPage;

@SuppressWarnings("deprecation")
public class selectProductsStepDefinition {
	
	static WebDriver driver;
	TestContext testContext;
	ShoppingCartPage shoppingCartPage;
	String searchProduct;
	
	@Before
	public void beforeScenario(){
		shoppingCartPage = testContext.getPageObjectManager().getShoppingCartPage();
	}
	
	@After
	public void afterScenario() {
		
	}
	
	public selectProductsStepDefinition(TestContext context) {
		testContext = context;
		System.out.println("System Testing");	
	}
	
	@Given("^I add four different products to my wish list$")
	public void i_add_four_different_products_to_my_wish_list() throws Exception{
		shoppingCartPage.navigateTo_ShoppingCartPage();
		shoppingCartPage.add_SelectedProductTo_Wishlist();
	}

	@When("^I view my wishlist table$")
	public void i_view_my_wishlist_table(){
		shoppingCartPage.viewWishList();
	}

	@Then("^I find total four selected items in my Wishlist$")
	public void i_find_total_four_selected_items_in_my_Wishlist() throws InterruptedException{
		//finding the all selected products in wish list.
		Assert.assertEquals(shoppingCartPage.getElementSize("xpath", "//*[@class='product-name']/a"), 4);
		String items=shoppingCartPage.getTexts("xpath", "//*[@class='product-name']/a");

        Assert.assertEquals(true, items.contains("Modern"));
        Assert.assertEquals(true, items.contains("Bikini"));
        Assert.assertEquals(true, items.contains("Hard top"));
        Assert.assertEquals(true, items.contains("Single Shirt"));
        Thread.sleep(1000);

	}

	@When("^I search for lowest price product$")
	public void i_search_for_lowest_price_product() throws InterruptedException{
		searchProduct = shoppingCartPage.lowestPriceProduct();
        Thread.sleep(2000);
		System.out.println("Search Product is"+searchProduct);
		shoppingCartPage.enterSearchProduct(searchProduct);
        Thread.sleep(2000);
	}

	@When("^I am able to add the lowest price item to my cart$")
	public void i_am_able_to_add_the_lowest_price_item_to_my_cart() throws InterruptedException{
		shoppingCartPage.addSelectedProductToCart();
		Thread.sleep(2000);
	}

	@Then("^I am able to verify the item in my cart$")
	public void i_am_able_to_verify_the_item_in_my_cart(){
		String addedItems = shoppingCartPage.verifyTheCart();
		Assert.assertEquals(true, addedItems.contains(searchProduct));
		shoppingCartPage.closeBrowser();
	}

}
