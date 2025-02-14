package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final WebDriver driver;


    // Локатор
   private final By faqTextLocator = By.xpath("//div[@class='Home_SubHeader__zwi_E' and text()='Вопросы о важном']"); // Заголовок раздела «Вопросы о важном».
    private final By headerOrderButton = By.xpath("//div[@class='Header_Nav__AGCXC']//button[text()='Заказать']"); // Кнопка ЗАКАЗАТЬ в шапке страницы
    private final By orderButton = By.xpath("//div[@class='Home_FinishButton__1_cWm']//button[text()='Заказать']"); // Кнопка ЗАКАЗАТЬ внизу страницы
    private final By scooterLogo = By.xpath("//a[contains(@class, 'Header_LogoScooter')]"); // Логотип скутера в шапке страницы
    private final By closeCookiesButton = By.xpath("//button[text()='да все привыкли']"); // кнопка закрывающая баннер с Cookies


    
    public void clickOrderButton() {
        driver.findElement(headerOrderButton).click();
    }

   
    public void clickToSecondOrderButton() {
        closeCookiesIfPresent(); 
        driver.findElement(orderButton).click(); 
    }

   
    public void scrollDownToBottom() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
    }

    
    public boolean isFaqTextDisplayed() {
        WebElement element = driver.findElement(faqTextLocator);
        return element.isDisplayed();
    }

  
    public boolean verifyFaqAnswer(String questionLocator, String expectedAnswerText) {
        closeCookiesIfPresent();

       
        By questionBy = By.xpath(questionLocator);
        WebElement questionElement = driver.findElement(questionBy);

       
        questionElement.click();

        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By answerLocator = By.xpath(questionLocator + "/parent::div/" +
                "following-sibling::div[@data-accordion-component='AccordionItemPanel']");
        WebElement answerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator));

        
        if (answerElement != null && answerElement.isDisplayed()) {
            return answerElement.getText().trim().equals(expectedAnswerText);
        }

        return false;
    }

    public void clickToScooterLogo() {
        driver.findElement(scooterLogo).click();
    }

    public void clousePopUpCookies() {
        driver.findElement(closeCookiesButton).click();
    }

   
    private void closeCookiesIfPresent() {
        if (driver.findElement(closeCookiesButton).isDisplayed()) {
            clousePopUpCookies();
        }
    }
}