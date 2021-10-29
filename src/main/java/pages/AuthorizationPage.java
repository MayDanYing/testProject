package pages;

import base.BaseView;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage extends BaseView {

    private WebDriver driver;

    //Поле ввода логина
    @FindBy(xpath = ".//input[@class='mira-widget-login-input mira-default-login-page-text-input']")
    private WebElement loginField;

    //Поле ввода пароля
    @FindBy(xpath = ".//input[@name='password']")
    private WebElement passwordField;

    //Кнопка "Войти"
    @FindBy(xpath = ".//button[@class='mira-widget-login-button mira-default-login-page-button-submit']")
    private WebElement enterButton;

    public AuthorizationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //1. Ввести свой логин в поле ввода
    @Step(value = "Enter login credentials")
    public AuthorizationPage enterLogin(String LOGIN) {
        Assert.assertTrue(loginField.isDisplayed());
        loginField.sendKeys(LOGIN);
        return this;
    }

    //2. Ввести свой пароль в поле ввода
    @Step(value = "Enter password credentials")
    public AuthorizationPage enterPassword(String PASSWORD) {
        Assert.assertTrue(passwordField.isDisplayed());
        passwordField.sendKeys(PASSWORD);
        return this;
    }

    //3.Подтвердить ввод. Try/catch нужен для обработки Thread.sleep, т.к. перед шагом №4 необходимо задержаться
    //Иначе не успевает отработать метод getTitle().
    @Step(value = "Confirm entry")
    public AuthorizationPage confirmEntry() {
       try {
        Assert.assertTrue(enterButton.isDisplayed());
        enterButton.click();
        Thread.sleep(2000);}
       catch (InterruptedException exception){
           System.out.println("Catching exception" + exception);
        }
       return this;
    }


    //4.Подтвердить успешную авторизацию.
    @Step(value = "Confirm successful authentication")
    public AuthorizationPage confirmSuccessfulAuthentication() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Главная страница";
        Assert.assertEquals(expectedTitle, actualTitle);
        return this;
    }
}
