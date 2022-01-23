import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormTest extends BaseTest {
    @Test
    public void shouldFillFormWithSuccess() {
        driver.get("https://seleniumui.moderntester.pl/form.php#");
        driver.findElement(By.id("inputFirstName3")).sendKeys("Jan");
        driver.findElement(By.id("inputLastName3")).sendKeys("Kowalski");
        driver.findElement(By.id("inputEmail3")).sendKeys("test@gmail.com");
        driver.findElement(By.id("inputAge3")).sendKeys("45");

        List<WebElement> sexRadioButtons = driver.findElements(By.name("gridRadiosSex"));
        sexRadioButtons.get(1).click();

        List<WebElement> yearExperienceRadioButtons = driver.findElements(By.name("gridRadiosExperience"));
        yearExperienceRadioButtons.get(1).click();

        List<WebElement> professionCheckboxes = driver.findElements(By.name("gridCheckboxProfession"));
        professionCheckboxes.get(1).click();

        Select continents = new Select(driver.findElement(By.id("selectContinents")));
        continents.selectByIndex(6);

        Select commands = new Select(driver.findElement(By.id("selectSeleniumCommands")));
        commands.selectByIndex(4);

        File file = new File("src/main/resources/file.txt");
        driver.findElement(By.id("chooseFile")).sendKeys(file.getAbsolutePath());

        driver.findElement(By.cssSelector("[type=submit]")).click();

        String validationTextMessage = driver.findElement(By.id("validator-message")).getText();
        Assert.assertEquals(validationTextMessage, "Form send with success");
    }
}
