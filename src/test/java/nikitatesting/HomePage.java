package nikitatesting;

import com.google.gson.internal.bind.util.ISO8601Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    //Локатор для подтверждения Cookie
    private By cookieButton = By.xpath("//button[@id='cookie-agree']");
    // Локаторы для подтверждения надписи
    private By titleLocator = By.xpath("//div[@class='pay__wrapper']//h2");
    // Локатор для подтверждения логов
    private By logosLocator = By.xpath("//div[@class='pay__partners']//img");

    // Локатор для ссылки
    private By serviceLinkLocator = By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/a");

    // Локаторы для теста формы
    private By phoneFieldLocator = By.xpath("//*[@id='connection-phone']");
    private By amountFieldLocator = By.xpath("//*[@id='connection-sum']");
    private By emailFieldLocator = By.xpath("//*[@id='connection-email']");
    private By continueButtonLocator = By.xpath("//*[@id='pay-connection']/button");
    private By iFrameLocator = By.className("bepaid-iframe");
    private By confirmationWindowLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span");


    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void acceptCookies(){
        try{
            WebElement button = waitForElement(cookieButton);
            System.out.println("Получили элемент Cookie");
            button.click();
            System.out.println("Нажали на кнопку Принять");
        } catch (Exception e){
            System.out.println("Окно cookie не появилось");
        }
    }

    public String getTitleText(){
        WebElement titleElement = waitForElement(titleLocator);
        System.out.println("Получили элемент title");
        return titleElement.getText().replace("\n", " ");
    }

    public List<WebElement> getLogos(){
        System.out.println("Возвращаем элементы логов");
        return waitForElementList(logosLocator);
    }

    public String getTheLink(){
        WebElement serviceLink = waitForElement(serviceLinkLocator);
        System.out.println("Получили элемент ссылки");
        serviceLink.click();
        System.out.println("Нажали на ссылку");

        for(String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }

        System.out.println("Переключились на другое окно");


        wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
        System.out.println("Получили ссылку");
        return driver.getCurrentUrl();
    }

    public String fillPaymentFormAndReturnConfirmationText(String phone, String amount, String email){
        WebElement phoneField = waitForElement(phoneFieldLocator);
        System.out.println("Получили элемент телефона");
        phoneField.click();
        System.out.println("Нажал в поле куда вводится телефон");
        phoneField.sendKeys(phone);
        System.out.println("Ввели телефон " + phone);

        WebElement amountField = waitForElement(amountFieldLocator);
        System.out.println("Получили элемент ввода денег");
        amountField.click();
        System.out.println("Нажал в поле куда вводиться сумма");
        amountField.sendKeys(amount);
        System.out.println("Ввели " + amount + " руб.");

        WebElement emailField = waitForElement(emailFieldLocator);
        System.out.println("Получили элемент электронной почты");
        emailField.click();
        System.out.println("Нажали на поле электронной почты");
        emailField.sendKeys(email);
        System.out.println("Ввели " + email + " почту");

        WebElement continueButton = waitForElement(continueButtonLocator);
        System.out.println("Получили элемент кнопки продолжить");
        continueButton.click();
        System.out.println("Нажали на кнопку продолжить");

        WebElement newFrame = waitForElement(iFrameLocator);
        System.out.println("Получили новый фрейм");
        driver.switchTo().frame(newFrame);
        System.out.println("Переключились на новый фрейм");

        WebElement confirmationWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationWindowLocator));
        System.out.println("Получили элемент из нового фрейма");

        System.out.println("Получили текст");
        return confirmationWindow.getText().trim();
    }


    // Вспомогательные методы
    private WebElement waitForElement(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected List<WebElement> waitForElementList(By locator){
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
}
