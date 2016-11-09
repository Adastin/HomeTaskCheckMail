package Forms;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailPage {
    private WebDriver driver;
    public MailPage(WebDriver driver){
        this.driver = driver;
    }
    public boolean checkValidation(String username){
        String user = driver.findElement(By.xpath("//div[@class=\"_n_b4\"]/span[2]")).getText();
        String surname = username.substring(username.indexOf('.')+1);
        return user.toLowerCase().startsWith(surname);
    }
}
