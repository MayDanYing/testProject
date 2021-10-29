import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private final String MAIN_PAGE = "https://lmslite47vr.demo.mirapolis.ru/mira";
    protected WebDriver driver;

    @BeforeAll
    public static void setUpDr(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void openPage() {
        setUpDriver();
        open();
    }
    @AfterEach
    public void shutDown() {
        if(driver !=null) {
            driver.quit();
        }
    }

    // Проверяем, что находимся на нужной странице
    @Test
    public void confirmTitle()
    {
        driver.get(MAIN_PAGE);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Авторизация";
        Assert.assertEquals(expectedTitle,actualTitle);
        System.out.println("Title is identical");
    }

    // Проверяем, совпадает ли основная часта урла
    @Test
    public void confirmURL()
    {
        driver.get(MAIN_PAGE);
        boolean actualURLResult = driver.getCurrentUrl().contains("https://lmslite47vr.demo.mirapolis.ru/mira");
        Assert.assertEquals(true, actualURLResult);
        System.out.println("URL is identical");
    }

    private void open() {
        //0. Перейти на сайт
        driver.get(MAIN_PAGE);
    }
    private void setUpDriver() {
        ChromeOptions options= new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }
}
