package nikitatesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestClass {
    static WebDriver driver;
    static WebDriverWait wait;
    public HomePage homePage;

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
        homePage = new HomePage(driver, wait);

        homePage.acceptCookies();
    }


//    @Test
//    @Order(1)
//    public void testCheckBlockText(){
//        assertEquals("Онлайн пополнение без комиссии", homePage.getTitleText());
//    }
//
//    @Test
//    @Order(2)
//    public void testCheckThePaymentsLogos(){
//        assertEquals(5, homePage.getLogos().size());
//    }
//
//    @Test
//    @Order(3)
//    public void testTheLink(){
//        String linkToBeOpened = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
//        String actualLink = homePage.getTheLink();
//        assertEquals(linkToBeOpened, actualLink, "Ссылка не ведет на нужную страницу");
//    }
//
//    @Test
//    @Order(4)
//    public void testTheForm(){
//        String expectedText = "Оплата: Услуги связи Номер:375297777777";
//        String actualText = homePage.fillPaymentFormAndReturnConfirmationText("297777777", "10", "test@test.com");
//        assertEquals(expectedText, actualText, "Текс не совпадает");
//    }

    @Test
    @Order(5)
    public void testTheForm2(){

        List<String> values = homePage.fillPaymentsAndCheckTheSum("297777777", "10", "test@test.com");
        assertEquals("10.00 BYN", values.get(0));
        assertEquals("375297777777", values.get(1));
        assertEquals("10.00 BYN", values.get(2));
        assertEquals("Номер карты", values.get(3));
        assertEquals("Срок действия", values.get(4));
        assertEquals("CVC", values.get(5));
        assertEquals("Имя держателя (как на карте)", values.get(6));
        assertEquals("5", values.get(7));
    }

    @AfterEach
     public void close(){
        if(driver != null){
            driver.quit();
        }
    }



}

