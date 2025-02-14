package testcases;
import org.junit.jupiter.api.Assertions;
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

        // Hit the URL
        driver.get(properties.getProperty("baseURL"));

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
    // Using xpath with Inner Text
    public void verifying() {

    }

}
