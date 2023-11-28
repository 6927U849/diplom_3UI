import config.BaseConfig;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.NavigationPanel;
import pages.ProfilePage;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class LogoutTest extends BaseTest {

    private ProfilePage profilePage;
    private NavigationPanel navigationPanel;
    private LoginPage loginPage;


  private final String LOGIN_URL = BaseConfig.LOGIN_URL;

    @Before
    public void setUp() {
        super.setup(LOGIN_URL);
        registerUser();
        profilePage = new ProfilePage(driver);
        navigationPanel = new NavigationPanel(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("Выход из личного кабинета")
    public void logout() {
        loginPage.login(user.getEmail(), user.getPassword());
        navigationPanel.clickButtonPersonalAccount();
        profilePage.clickButtonExit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        boolean actual = loginPage.isTitleEnterDisplayed();
        assertTrue("Не удалось выйти из личного кабинета", actual);
    }

    @After
    public void tearDown() {
        super.tearDown();
        deleteUser();
    }
}
