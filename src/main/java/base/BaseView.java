package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseView {
    protected WebDriver driver;


    public BaseView() {
        this.driver = driver;

        PageFactory.initElements(driver,this);

    }
}
