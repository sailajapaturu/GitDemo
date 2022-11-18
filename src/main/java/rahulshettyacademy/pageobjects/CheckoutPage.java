package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	
		@FindBy (css= ".action__submit")
		WebElement submit;
		

		@FindBy (css= "[placeholder*='Select Country']")
		WebElement country;
		
		//.ta-item:nth-of-type(2)
		//button[contains(@class,'ta-item')])[2]
		@FindBy (css= ".ta-item:nth-of-type(2)")
		WebElement selectcountry;
		
		By results = By.cssSelector(".ta-results");
		//driver.findElement(By.cssSelector("[placeholder*='Select Country']")),
		
		public void selectcountry(String countryName) throws InterruptedException
		{
			Actions a= new Actions(driver);
			a.sendKeys(country, countryName).build().perform();
			waitForElementToAppear(By.cssSelector(".ta-results"));
			//Thread.sleep(7000);
			selectcountry.click();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,1500)");
			Thread.sleep(3000);
		}
		public ConfirmationPage submitOrder()
		{
			
			submit.click();
			return new ConfirmationPage(driver);
		}
}
