package automationFramework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyTestCase {

	public static void main(String[] args) {

	// Set the path to ChromeDriver
     System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDriver\\ChromeDriver\\chromedriver.exe");
     
     // Create an instance of WebDriver 
     WebDriver driver = new ChromeDriver();
     
     // Open the login page
     driver.get("https://www.saucedemo.com/");
     
     // Find the username and password fields
     WebElement usernameField = driver.findElement(By.id("user-name"));
     WebElement passwordField = driver.findElement(By.id("password"));

     // Enter username and password
     usernameField.sendKeys("standard_user");
     passwordField.sendKeys("secret_sauce");

     // Find and click the login button
     WebElement loginButton = driver.findElement(By.id("login-button"));
     loginButton.click();
     
     // Verify that the login was successful
     String expectedUrl = "https://www.saucedemo.com/inventory.html";
     String actualUrl = driver.getCurrentUrl();
     
     if (actualUrl.equals(expectedUrl)) {
    	 System.out.println("Login Test Passed. User successfully logged in.");
     } else {
    	 System.out.println("Login Test Failed. User is not logged in.");
     }
     
     // Add product to shopping cart
     WebElement productItem = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
     productItem.click();
     
     // Verify that product has been added to shopping cart
     WebElement removeButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
     if (removeButton.isDisplayed()) {
    	 System.out.println("Add To Cart Test Passed. Product has been successfully added to cart.");
     } else {
    	 System.out.println("Add To Cart Test Failed. Product hasn't been added to cart.");
     }
     
     // Access the shopping cart
     WebElement shoppingCart = driver.findElement(By.id("shopping_cart_container"));
     shoppingCart.click();
     
     // Place Order/Checkout
     WebElement checkoutButton = driver.findElement(By.id("checkout"));
     checkoutButton.click();
     
     // Find the FirstName, LastName and Postal Code fields
     WebElement firstName = driver.findElement(By.id("first-name"));
     WebElement lastName = driver.findElement(By.id("last-name"));
     WebElement zipCode = driver.findElement(By.id("postal-code"));
     
     // Enter the names and postal code
     firstName.sendKeys("Marius");
     lastName.sendKeys("Stefanescu");
     zipCode.sendKeys("061185");
     
     // Find and click the checkout continue button
     WebElement checkoutContinue = driver.findElement(By.id("continue"));
     checkoutContinue.click();
     
     // Find and click the finish button
     WebElement finishButton = driver.findElement(By.id("finish"));
     finishButton.click();
     
     // Verify if the order has been successfully placed and Return Home
     WebElement homeButton = driver.findElement(By.id("back-to-products"));
     if (homeButton.isDisplayed()) {
    	 System.out.println("Place Order Test passed. Order has been successfully placed.");
     } else {
    	 System.out.println("Place Order Test Failed. Order hasn't been placed.");
    	 
     }
     homeButton.click();
     
     // Close browser
     driver.quit();
     
     
	}

}
