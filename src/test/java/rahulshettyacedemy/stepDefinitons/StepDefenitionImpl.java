package rahulshettyacedemy.stepDefinitons;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestCpmponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class StepDefenitionImpl extends BaseTest{
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
@Given("I landed on Ecommerce Page")
public void I_landed_on_Ecommerce_Page() throws IOException
{
	//code
	landingPage = launchApplication();
}
//Given Logged in with username <name> and password <password>
@Given("^Logged in with username (.+) and password (.+)$")
public void Logged_in_with_username_and_password(String username, String password)
{
	productCatalogue = landingPage.loginApplication(username,password);

}


  @When("^I add product (.+) from cart and Checkout product and submit the order$") public void
  I_add_product_from_cart_and_Checkout_product_and_submit_the_order(String productName) throws InterruptedException {
  List<WebElement> products = productCatalogue.getProductList();
  productCatalogue.addProductToCart(productName); 
  CartPage cartpage = productCatalogue.goToCartPage();
  Boolean match = cartpage.VerifyProductDisplay(productName);
  Assert.assertTrue(match); 
  CheckoutPage checkoutpage = cartpage.goToCheckout(); 
  checkoutpage.selectcountry("india");
  confirmationPage = checkoutpage.submitOrder();
  }
  


	/*
	 * @When("^Checkout (.+) and submit the order$") public void
	 * Checkout_submit_order(String productName) throws InterruptedException {
	 * 
	 * }
	 */ //Then
   


  @Then("message is displayed on ConfirmationPage") 
  public void  message_is_displayed_on_ConfirmationPage( )
  { 
	  String confirmMessage = confirmationPage.getConfirmationMessage();
	  Assert.assertTrue(confirmMessage.equals("THANKYOU FOR THE ORDER.")); 
  }
  @Then("^\"([^\"]*)\" message is displayed$")
  public void something_message_is_displayed(String strArg1) throws Throwable {
		Assert.assertEquals(strArg1, landingPage.getErrorMessage());

  }
 
 
}
