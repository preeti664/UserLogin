import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        
        // Initialize the Chrome driver
        driver = new ChromeDriver();
        
        // Open the web page to test
        driver.get("https://example.com/login");
        
        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test
    public void testValidLogin() {
        // Locate the username field and input a valid username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("validUsername");
        
        // Locate the password field and input a valid password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("validPassword");
        
        // Locate and click the login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        
        // Wait for the page to load and check if the login was successful
        WebElement welcomeMessage = driver.findElement(By.id("welcomeMessage"));
        Assert.assertTrue(welcomeMessage.isDisplayed(), "Login was unsuccessful");
    }

    @Test
    public void testInvalidLogin() {
        // Locate the username field and input an invalid username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("invalidUsername");
        
        // Locate the password field and input an invalid password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("invalidPassword");
        
        // Locate and click the login button
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        
        // Check for error message
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed for invalid login");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
