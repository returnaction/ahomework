package nikitatesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestClass {

    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    static void setupClass(){
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by");

        try{
            WebElement coockieButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='cookie-agree']")));
            coockieButton.click();
        } catch(TimeoutException e){
            System.out.println("Окно cookie не появилось, продолжается тест.");
        }
    }


    @Test
    @Order(1)
    public void testCheckBlockText(){
        WebElement titleElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='pay__wrapper']//h2")));
        String titleText = titleElement.getText().replace("\n", " ");
        assertEquals("Онлайн пополнение без комиссии", titleText);
    }

    @Test
    @Order(2)
    public void testCheckThePaymentsLogos(){
        List<WebElement> logos = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='pay__partners']//img")));
        assertEquals(5, logos.size());
    }

    @Test
    @Order(3)
    public void testTheLink(){
        WebElement serviceLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/a")));
        String linkToBeOpened = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

        serviceLink.click();

        for(String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }

        wait.until(ExpectedConditions.urlToBe(linkToBeOpened));
        assertEquals(linkToBeOpened, driver.getCurrentUrl(), "Ссылка не ведет на нужную страницу");
    }

    @Test
    @Order(4)
    public void testTheForm(){
        WebElement phoneField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='connection-phone']")));
        phoneField.click();
        phoneField.sendKeys("297777777");

        WebElement amountField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='connection-sum']")));
        amountField.click();
        amountField.sendKeys("10");

        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='connection-email']")));
        emailField.click();
        emailField.sendKeys("test@test.com");

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='pay-connection']/button")));
        continueButton.click();


        // надо переключиться на новый frame а то он получается будет искать на старом а не на pop up window
        WebElement newFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-iframe")));
        driver.switchTo().frame(newFrame);

        WebElement confirmationWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span")));

        String expectedText = "Оплата: Услуги связи Номер:375297777777";
        String text = confirmationWindow.getText();
        assertEquals(expectedText, text.trim(), "Текс не совпадает");
    }

    @AfterEach
     public void close(){
        if(driver != null){
            driver.quit();
        }
    }

//    @Test
//    public void openURL() throws InterruptedException {
//        driver.get("https://mail.ru/");
//        //driver.findElement(By.id("mailbox"));
//        //WebElement loginButton =  driver.findElement(By.xpath("//button[contains(@class, 'resplash-btn')]"));
//
//        List<WebElement> loginButtons = driver.findElements(By.xpath("//button[contains(@class, 'resplash-btn')]"));
//        assertEquals(4, loginButtons.size());
//        Thread.sleep(10000);
//
//    }

}
