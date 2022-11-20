package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	

		// TODO Auto-generated constructor stub
	
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		//initilization
		this.driver = driver;
		PageFactory.initElements(driver,this);

	}
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
    @FindBy(id ="userEmail")
    WebElement userEmail;
    
    @FindBy(id ="userPassword")
    WebElement passwordEle;
    
    @FindBy(id ="login")
    WebElement submit;
    
    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;
    

	public ProductCatalogue loginApplication(String email, String password) 
	{
		// TODO Auto-generated method stub
		userEmail.sendKeys(email);
    	passwordEle.sendKeys(password);
    	submit.click();
    	ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		System.out.println(productCatalogue);

    	return productCatalogue;
	}
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	

	public void goTo() {
		// TODO Auto-generated method stub
		driver.get("https://www.rahulshettyacademy.com/client");
	}
}
