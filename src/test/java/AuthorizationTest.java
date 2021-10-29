import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;

@Feature("Тест-кейс Успешный ввод логина и пароля в поле авторизации")
public class AuthorizationTest extends BaseTest {

        @Test
        public void makeAuthorization() {
            new AuthorizationPage(driver)
                    .enterLogin("fominaelena")
                    .enterPassword("1P73BP4Z")
                    .confirmEntry()
                    .confirmSuccessfulAuthentication();
        }
}
