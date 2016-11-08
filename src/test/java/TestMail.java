import Forms.LoginPage;
import Forms.MailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestMail {
    private WebDriver driver;
    private String username;
    private String password;
    private String url;
    private long defaultPageLoadTimeout;
    private long defaultConditionTimeout;
    private String webDriver;

    @Parameters ({"username", "password"})
    @BeforeTest
    public void setUp(String username, String password){
        this.username = username;
        this.password = password;
        try {
            FileInputStream fileProperty = new FileInputStream("src/test/resources/config.properties");
            Properties properties = new Properties();
            properties.load(fileProperty);
            url = properties.getProperty("url");
            defaultConditionTimeout = Long.parseLong(properties.getProperty("defaultConditionTimeout"));
            defaultPageLoadTimeout = Long.parseLong(properties.getProperty("defaultPageLoadTimeout"));
            webDriver = properties.getProperty("webDriver");
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty(webDriver, "src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(defaultPageLoadTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(defaultConditionTimeout, TimeUnit.SECONDS);
    }
    @Test
    public void testMail(){
        driver.get(url);
        LoginPage log = new LoginPage(driver);
        log.login(username, password);
        MailPage mailPage = new MailPage(driver);
        assert(mailPage.checkValidation());
    }
    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
