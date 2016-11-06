package Forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private String fieldPassword = "password";
    private String fieldUsername = "username";
    private String buttonSubmit = "SubmitCreds";
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void login(String username, String password){
        driver.findElement(By.id(fieldUsername)).sendKeys(username);
        driver.findElement(By.id(fieldPassword)).sendKeys(password);
        driver.findElement(By.id(buttonSubmit)).click();
    }
}
