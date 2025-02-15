package pageobject;


import org.checkerframework.checker.index.qual.PolyUpperBound;
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

    // Using XPath with inner text   teext()
    public By saveMoreOnAppLocator = By.xpath("//span[text()='Save More on App']");

    // Using contains()
    public By loginButton = By.xpath("//a[contains(@data-spm-click,'gostr=/lzdpub.header.tbar;locaid=login')]");

    // USING CONTAINS()
//    public By loginForm = By.xpath("//div[contains(@class,'index_module_loginWrapper__ff031001')]");

    // using starts-with()
    public By loginForm = By.xpath("//div[starts-with(@class,'index_module_loginWrapper__ff031001')]");

    //using chained xpath
    public By cartIconButton = By.xpath("//span[@class='cart-icon-daraz']");

}
