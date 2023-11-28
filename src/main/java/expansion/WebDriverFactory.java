package expansion;

import config.BaseConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class WebDriverFactory {

    public static WebDriver get() {

        final int WAIT_SECONDS_TIMEOUT = Integer.parseInt(BaseConfig.WAIT_SECONDS_TIMEOUT);

          String browserName = System.getProperty("browser").toLowerCase();
        if (browserName == null) {
            browserName = "chrome";
        }


        WebDriver driver;
        switch (browserName) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "yandex":
                driver = createYandexDriver();
                break;
            default:
                throw new RuntimeException("Браузера " + browserName + " не существует");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_SECONDS_TIMEOUT));
        return driver;
    }

    private static WebDriver createYandexDriver() {
       System.setProperty("web-driver.http.factory", "C:\\Program Files\\WebDriver\\bin");
        ChromeOptions options = new ChromeOptions();
       options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        return new ChromeDriver(options);
    }
}
