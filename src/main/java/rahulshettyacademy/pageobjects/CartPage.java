 package rahulshettyacademy.pageobjects;

import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartProducts;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	public boolean VerifyProductDisplay(String productName)
	{
		boolean match = cartProducts.stream().anyMatch(product ->product.getText().equalsIgnoreCase(productName));
		System.out.println(match);
		return match;
	}
	
	public CheckoutPage goToCheckout(){
		checkoutEle.click();
		System.out.println("go to checkout page");
		return new CheckoutPage(driver);
		
	}

}
