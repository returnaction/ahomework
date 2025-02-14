package nikitatesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    private By amountPaymentLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/span[1]");
    private By numberLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span");
    private By payButtonLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button");
    private By logosinPaymentLocator = By.xpath("//div[contains(@class, 'cards-brands')]//img");
    private By cardNumberPlaceHolderLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/label");
    private By cardExparationPlaceHolderLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/label");
    private By CVCPlaceHolderLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/label");
    private By nameOfTheCardPlaceHolderLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label");




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

    public void fillPaymentsAndCheckTheSum(String phone, String amount, String email){
        WebElement phoneField = waitForElement(phoneFieldLocator);
        phoneField.click();
        phoneField.sendKeys(phone);

        WebElement amountField = waitForElement(amountFieldLocator);
        amountField.click();
        amountField.sendKeys(amount);

        WebElement emailField = waitForElement(emailFieldLocator);
        emailField.click();
        emailField.sendKeys(email);

        WebElement continueButton = waitForElement(continueButtonLocator);
        continueButton.click();

        WebElement newFrame = waitForElement(iFrameLocator);
        driver.switchTo().frame(newFrame);

        // сумма
        WebElement amountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(amountPaymentLocator));
        String amountText = amountElement.getText();
        //amountText = amountText.replace(".00 BYN", "");
        System.out.println("Надпись в окошке: " + amountText);

        // номер телефона
        WebElement phoneTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(numberLocator));
        String phoneText = phoneTextElement.getText();
        phoneText = phoneText.replace("Оплата: Услуги связи Номер:", "");
        System.out.println(phoneText);

        // сумма на кнопке
        WebElement payButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(payButtonLocator));
        String payButtonText = payButtonElement.getText().replace("Оплатить ", "");
        System.out.println("Надпись в кнопке оплатить: " + payButtonText);

        // наличие иконок платежной системы.
        List<WebElement> logos = driver.findElements(logosinPaymentLocator);
        System.out.println("Количество иконок: " + logos.size());

        //надписи в незаполненых полях ввода.
        WebElement cardNumberPlaceHolderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberPlaceHolderLocator));
        String cardNumberPlaceHolderText = cardNumberPlaceHolderElement.getText();
        System.out.println("Плэйсхолдер номер карты: " + cardNumberPlaceHolderText);

        WebElement exparationDateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cardExparationPlaceHolderLocator));
        String exparationDateText = exparationDateElement.getText();
        System.out.println("Exparation Date PlaceHolder: " + exparationDateText);

        WebElement cvcPlaceHolderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CVCPlaceHolderLocator));
        String cvcPlaceHolderText = cvcPlaceHolderElement.getText();
        System.out.println("CVC PlaceHolder: " + cvcPlaceHolderText);

        WebElement nameOfTheCardPlaceHolderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nameOfTheCardPlaceHolderLocator));
        String nameOfTheCardPlaceHolderText = nameOfTheCardPlaceHolderElement.getText();
        System.out.println("Name Of Card PlaceHolder: " + nameOfTheCardPlaceHolderText);
        System.out.println("here");

    }


    // Вспомогательные методы
    private WebElement waitForElement(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected List<WebElement> waitForElementList(By locator){
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
}
