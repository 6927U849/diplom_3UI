import config.BaseConfig;
import io.qameta.allure.junit4.DisplayName;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.*;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {
    private NavigationPanel navigationPanel;
    public RegistrationPage registrationPage;
    public MainPage mainPage;
    private ResetPasswordPage resetPasswordPage;
    private LoginPage loginPage;

    private final String MAIN_URL = BaseConfig.MAIN_URL;
    private final String REGISTRATION_URL = BaseConfig.REGISTRATION_URL;
    private final String RESET_PASSWORD_URL = BaseConfig.RESET_PASSWORD_URL;


    @Before
    public void setUp() {
        super.setup("");
        registerUser();
        registrationPage = new RegistrationPage(driver);
        resetPasswordPage = new ResetPasswordPage(driver);
        navigationPanel = new NavigationPanel(driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Авторизация по кнопке Войти в аккаунт на главной странице")
    public void loginWithButtonEnterAccountOnMainPage() {
        driver.navigate().to(MAIN_URL);
        mainPage.clickButtonEnterAccount();
        loginPage.login(user.getEmail(), user.getPassword());
        boolean actual = loginPage.isTitleEnterDisplayed();
        assertTrue("Не удалось авторизоваться", actual);
    }

    @Test
    @DisplayName("Авторизация по кнопке Личный кабинет")
    public void loginWithButtonPersonalAccount() {
        driver.navigate().to(MAIN_URL);
        navigationPanel.clickButtonPersonalAccount();
        loginPage.login(user.getEmail(), user.getPassword());
        boolean actual = loginPage.isTitleEnterDisplayed();
        assertTrue("Не удалось авторизоваться", actual);
    }

    @Test
    @DisplayName("Авторизация по кнопке Войти в форме регистрации")
    public void loginWithButtonEnterOnRegistrationForm() {
        driver.navigate().to(REGISTRATION_URL);
        registrationPage.clickButtonEnter();
        loginPage.login(user.getEmail(), user.getPassword());
        boolean actual = loginPage.isTitleEnterDisplayed();
        assertTrue("Не удалось авторизоваться", actual);
    }

    @Test
    @DisplayName("Авторизация через кнопку в форме восстановления пароля")
    public void loginWithResetPasswordForm() {
        driver.navigate().to(RESET_PASSWORD_URL);
        resetPasswordPage.clickButtonEnter();
        loginPage.login(user.getEmail(), user.getPassword());
        boolean actual = loginPage.isTitleEnterDisplayed();
        assertTrue("Не удалось авторизоваться", actual);
    }

    @After
    public void tearDown() {
        super.tearDown();
        deleteUser();
    }

}
