import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest extends BaseTest {

    @BeforeMethod
    public void openPage() {
        driver.get("https://seleniumui.moderntester.pl/iframes.php");
    }

    @Test
    public void switchFrame() {
        //given
        driver.switchTo().frame("iframe1");
        driver.findElement(By.id("inputFirstName3")).sendKeys("Jan");

        driver.findElement(By.cssSelector("[type=submit]")).click();

        driver.switchTo().defaultContent();
        driver.switchTo().frame("iframe2");
        driver.findElement(By.id("inputLogin")).sendKeys("Jan");

        driver.findElement(By.cssSelector("[type=submit]")).click();

    }
}
