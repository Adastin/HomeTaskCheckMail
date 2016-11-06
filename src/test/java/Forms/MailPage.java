package Forms;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailPage {
    private WebDriver driver;
    public MailPage(WebDriver driver){
        this.driver = driver;
    }
    public boolean checkValidation(){
        return driver.findElement(By.id("_ariaId_16")).isEnabled();
    }
}
