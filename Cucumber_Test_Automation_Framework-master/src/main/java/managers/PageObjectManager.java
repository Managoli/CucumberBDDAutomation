package managers;
  
import org.openqa.selenium.WebDriver;

import pageobjects.ShoppingCartPage;





public class PageObjectManager {
 
	private WebDriver driver;
 
	
	
	private ShoppingCartPage shoppingCartPage;

 
	
 
	public PageObjectManager(WebDriver driver) {
 
		this.driver = driver;
	}
 
	
 

	
	public ShoppingCartPage getShoppingCartPage(){
		 
		return (shoppingCartPage == null) ? shoppingCartPage = new ShoppingCartPage(driver) : shoppingCartPage;
 
	}
 
	
}