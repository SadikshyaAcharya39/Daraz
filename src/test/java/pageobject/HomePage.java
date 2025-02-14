package pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    // Catch the driver
    public HomePage(WebDriver driver){
        this.driver = driver;
    }


    // Locators   ( Using CSS Selector )

    //  tag and id
//    public By searchButton = By.cssSelector("input#q");


    //  tag name and class
//    public By searchButton = By.cssSelector("input.search-box__input--O34g");

    //  tag name and attribute
//    public By searchButton = By.cssSelector("input[placeholder=\"Search in Daraz\"]");

    // tag name, attribute and class name
//    public By searchButton = By.cssSelector("input.search-box__input--O34g[placeholder=\"Search in Daraz\"]");

    // tag name, attribute and class name
    public By searchButton = By.cssSelector(".search-box__input--O34g[placeholder='Search in Daraz']");

    // For language translator

    // Using xpath with single attribute
//    public By languageTranslationLocator = By.xpath("//div[@id='topActionSwitchLang']");

   // Using XPath with multiple attribute
//    public By languageTranslationLocator = By.xpath("//div[@class='top-links-item white'][@id='topActionSwitchLang']");
    public By languageTranslationOptionsLocator = By.xpath("//div[@id='lzdSwitchPop']");

    // Using XPath with "AND" operator
//    public By languageTranslationLocator = By.xpath("//div[@class='top-links-item white' and @id='topActionSwitchLang']");

    // Using XPath with "OR" Operator
    public By languageTranslationLocator = By.xpath("//div[@class='top-links-item white' or @id='topActionSwitchLang']");


    // Using XPath with inner text

}
