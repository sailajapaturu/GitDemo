package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	

		// TODO Auto-generated constructor stub
	
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		//initilization
		this.driver = driver;
		PageFactory.initElements(driver,this);

	}
   //List <WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
    @FindBy(css=".mb-3")
    List<WebElement> products;
    
    @FindBy(css=".ng-animating")
    WebElement spinner;
    
    //driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
    @FindBy(css="[routerlink*='cart']")
    WebElement Cart;
    
    By productsBy = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");
   
    
    
    public List<WebElement> getProductList()
    {
    	waitForElementToAppear(productsBy);
    	System.out.println(products);
    	System.out.println("sailaja");
    	return products;
    }
    public WebElement getProductByName(String productName)
    {
    	WebElement prod = getProductList().stream().filter(product-> product.findElement
    			(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
    			return prod;
    }
    public void addProductToCart(String productName) throws InterruptedException
    {
    	WebElement prod = getProductByName(productName);
    	prod.findElement(addToCart).click();
    	waitForElementToAppear(toastMessage);
    	waitForElementToDisappear(spinner);
    	
    }
	public CartPage goToCartPage() {
		// TODO Auto-generated method stub
		Cart.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;      
		
	}
    
    

	
}
