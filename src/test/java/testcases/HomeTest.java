package testcases;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.HomePage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.HomePage;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Driver;
import java.time.Duration;
import java.util.Properties;

public class HomeTest {
    private WebDriver driver;
    private Properties properties;
    private HomePage homePage;


    @BeforeEach
    public void setUp() {
        // Launch the browser
        driver = new ChromeDriver();

        // Read properties file

        properties = new Properties();
        try(InputStream is = getClass().getResourceAsStream("/application.properties")){
            properties.load(is);
        }
        catch (IOException e) {
            throw new RuntimeException("application.properties file not found");
        }

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Hit the URL
//        driver.get(properties.getProperty("baseURL"));

        driver.get("https://www.nopcommerce.com/en");


        // window maximize
        driver.manage().window().maximize();

        // Sending the driver
        homePage = new HomePage(driver);
    }

    @AfterEach
    public void tearDown(){
        if(driver!= null){
            driver.quit();
        }
    }

    @Test
    public void verifyingSearchButtonOfHomePage(){

        // Verifying the functionality of search

        WebElement searchButton = driver.findElement(homePage.searchButton);
        searchButton.sendKeys("Laptop");

    }

    @Test
    public void verifyingLanguageTranslatorButton(){
        WebElement languageTranslator = driver.findElement(homePage.languageTranslationLocator);
        languageTranslator.click();
        WebElement languageOptions = driver.findElement(homePage.languageTranslationOptionsLocator);
        Assertions.assertTrue(languageOptions.isDisplayed());
    }

    @Test
    // using text method -- Inner Text
    public void verifyingSaveMoreOnAppButton() {
//        WebElement saveMoreOnApp = driver.findElement(homePage.saveMoreOnAppLocator);
//        saveMoreOnApp.click();

//       boolean status = driver.findElement(homePage.saveMoreOnAppLocator).isDisplayed();
//        System.out.println(status);

        String value = driver.findElement(homePage.saveMoreOnAppLocator).getText();
        System.out.println(value);
    }

    @Test
    public void verifyingLoginButton(){
        // Using contains
        WebElement loginButton = driver.findElement(homePage.loginButton);
        loginButton.click();

        // Using start-with
         boolean loginFormStatus = driver.findElement(homePage.loginForm).isDisplayed();
         System.out.println(loginFormStatus);

    }

    @Test
    public void verifyingCartFunctionality(){
        //using chained xpath
        driver.findElement(homePage.cartIconButton).click();
    }

    // Using different get methods
    @Test
    public void tryingDifferentGetMethods(){
        driver.get(properties.getProperty("BaseURL"));  // open the url in the browser.
        driver.getTitle(); // returns the title of the page
        driver.getCurrentUrl(); // return the URL
        driver.getPageSource(); // returns the source code
        driver.getWindowHandles();  // return the ID of the single browser window
        driver.getWindowHandles(); // return the ID's of the multiple browser window    // Example: While clicking on some links and it opens on new window.
    }

    // Using different conditional methods

    /*
    @Test
    public void verifyingDifferentConditionalMethods(){

        driver.findElement().isDisplayed();   // For displaying image and logo
        driver.findElement().isEnabled();     // For hidden
        driver.findElement().isSelected();    checkbox, radio button, drop down

    }

     */


    @Test
    public void verifyingRegistrationForm() throws InterruptedException {
//    WebElement menu = driver.findElement(homePage.buttonLocator);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Create actions
        Actions actions = new Actions(driver);

        // Perform hover actions
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.buttonLocator));
        actions.moveToElement(menu).perform();

        WebElement submenu = wait.until(ExpectedConditions.elementToBeClickable(homePage.chooseOptionsLocator));
        submenu.click();

//    driver.findElement(homePage.chooseOptionsLocator);
//    driver.findElement(homePage.selectRegister);


    wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.firstNameTextBoxLocator)).sendKeys("Sadikshya");
    driver.findElement(homePage.lastNameTextBoxLocator).sendKeys("Acharya");
    driver.findElement(homePage.emailTextBoxLocator).sendKeys("acharya.sadikshya33@gmail.com");
    driver.findElement(homePage.confirmEmailTextBoxLocator).sendKeys("acharya.sadikshya33@gmail.com");
    driver.findElement(homePage.userNameTextBoxLocator).sendKeys("Sadikshya");


        // Handle dropdown selection
        WebElement dropDown = wait.until(ExpectedConditions.elementToBeClickable(homePage.countryDropDownLocator));
        dropDown.click();

        WebElement dropDownOption = wait.until(ExpectedConditions.elementToBeClickable(homePage.dropDownItemSelected));
        dropDownOption.click(); // Selects the dropdown option

//        driver.findElement(homePage.dropDownItemSelected).isSelected();




    }

}
