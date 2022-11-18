package rahulshettyacademy.SeleniumFrameworkDesign;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import rahulshettyacademy.TestCpmponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest{
	@Test (groups= {"ErrorHandling"}, retryAnalyzer = rahulshettyacademy.TestCpmponents.Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException
	{
		String productName= "ZARA COAT 3";
		
		landingPage.loginApplication("sailajapturu@gmail.com", "Moksha@16");
		Assert.assertEquals("Incorrect email  password.", landingPage.getErrorMessage());
		
	}
@Test
public void ProductErrorValidation() throws InterruptedException
{
	try
	{
	String productName ="ZARA COAT 3";
	ProductCatalogue productCatalogue = landingPage.loginApplication("sailajapaturu@gmail.com", "Moksha@16");
	List<WebElement>products = productCatalogue.getProductList();
	productCatalogue.addProductToCart(productName);
	
	CartPage cartpage= productCatalogue.goToCartPage();
	Boolean match = cartpage.VerifyProductDisplay("ZARA COAT 33");
	Assert.assertFalse(match);
	}
	catch(Exception ex)
	{
		System.out.println(ex.getMessage());
	}

}
}
