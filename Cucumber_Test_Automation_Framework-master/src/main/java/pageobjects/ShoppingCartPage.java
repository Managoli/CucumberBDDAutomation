package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.FileReaderManager;

public class ShoppingCartPage {
	
	WebDriver driver;
	public WebElement element=null;
	public static WebDriverWait wait = null;
	String baseUrl;
	String lProduct;
	
	@FindBy(xpath="//a[text()='Accept all']")
	private WebElement acceptAll;
	
	@FindBy(xpath="//h2[text()='Single Shirt']/parent::a/parent::li/descendant::*/child::a[@data-title='Add to wishlist']")
	private WebElement firatProduct;
	
	@FindBy(xpath="//h2[text()='Modern']/parent::a/parent::li/descendant::*/child::a[@data-title='Add to wishlist']")
	private WebElement secondProduct;
	
	@FindBy(xpath="//h2[text()='Hard top']/parent::a/parent::li/descendant::*/child::a[@data-title='Add to wishlist']")
	private WebElement thirdProduct;
	
	@FindBy(xpath="//h2[text()='Bikini']/parent::a/parent::li/descendant::*/child::a[@data-title='Add to wishlist']")
	private WebElement fourthProduct;
	
	@FindBy(xpath="//h2[text()='Hard top']/parent::a/parent::li/descendant::*/child::a[@data-title='Add to wishlist']")
	private WebElement scrolltillElementPresent;

	@FindBy(xpath="//*[@id='blog']/div[3]/div[1]/div/div/div[3]/div[3]/a/i")
	private WebElement clickWishListView;
	
	@FindBy(xpath="//button[@name='add-to-cart']")
	private WebElement addToCart;
	
	@FindBy(xpath="//*[@id='site-content']/div/div/article/div[1]/div/a")
	private WebElement ViewCart;
	
	@FindBy(xpath="//*[@class='product-price']/descendant::bdi/parent::*/parent::td/child::*|//*[@class='product-price']/descendant::ins")
	private WebElement lowPriceProduct;
	
	public ShoppingCartPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateTo_ShoppingCartPage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		acceptAll.click();
	}
	
	public void add_SelectedProductTo_Wishlist() throws InterruptedException {
		
		firatProduct.click();
		Thread.sleep(2000);
		secondProduct.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		thirdProduct.click();
		Thread.sleep(2000);
		fourthProduct.click();
		Thread.sleep(2000);
		
		
	}
	
	public void viewWishList() {
		clickWishListView.click();
	}
	
	public void countWishListProducts() {
		List<WebElement> optionCount = driver.findElements(By.xpath("//select/option"));
		//int list = optionCount.size();
		System.out.println(optionCount.size());
		//System.out.println("List !!"+list);
		
	}
	
	public int getElementSize(String accessType, String accessName){
        int i=driver.findElements(By.xpath(accessName)).size();
        System.out.println(i);
        return i;
    }
	
    public String getTexts(String accessType, String accessName){
        String temp="";
          List<WebElement> elements = driver.findElements(By.xpath(accessName));
            for (int i=0; i<elements.size();i++){
                temp=temp+elements.get(i).getText()+";";
            }
            return temp;
    }
    
    public String lowestPriceProduct() {
    	List<WebElement> product = driver.findElements(By.xpath("//*[@class='product-price']/descendant::bdi/parent::*/parent::td/child::*|//*[@class='product-price']/descendant::ins"));
        System.out.println("Total Number of Index is " + product.size());
        System.out.println(product.get(0).getText().replace("£", "").replace(".00", ""));
        int minVal =Integer.parseInt(product.get(1).getText().replace("£", "").replace(".00", ""));
        int index = 0;
        for (int i = 0; i <= product.size()-1; i++) {
        	int tmp =Integer.parseInt(product.get(i).getText().replace("£", "").replace(".00", ""));
            System.out.println(tmp);
            if ( minVal >=tmp){
            	minVal = tmp;
            	index = i+1;
            }
        }
        System.out.println(String.valueOf("The Minimum Value is" + minVal));
 
        lProduct = getElementText("xpath", "//*[@id=\"yith-wcwl-row-22\"]/div["+index+"]");
        
        return lProduct;
    }
	
	public void enterSearchProduct(String text) {
		
		driver.findElement(By.xpath("//input[@class='header-search-input']")).sendKeys(text);
		driver.findElement(By.xpath("//button[@class='header-search-button']")).click();
	
	}
	
	public String getElementText(String accessType, String AccessName) {

		element = driver.findElement(By.xpath("//*[@class='product-name']/a[1]"));
		System.out.println(element);
		return element.getText();
	}
	
	public void addSelectedProductToCart() {
		
		addToCart.click();
		ViewCart.click();
	}
	
	public String verifyTheCart() {
		
		String additems=getTexts("xpath", "//*[@class='product-name']/a");
		System.out.println("Added Items !!!!!!"+additems);
		
		return additems;
	}
	
	public void closeBrowser() {
		System.out.println("Clocing All the opned Browsers.");
		//driver.close();
		driver.quit();
	}
	
	

}
